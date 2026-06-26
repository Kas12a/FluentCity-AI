const fs = require('fs');

const code = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');
const lines = code.split('\n');

const start = lines.findIndex(l => l.includes('fun PracticeFeedbackScreen('));
let actualStart = start;
while (actualStart > 0 && (lines[actualStart - 1].startsWith('@Composable') || lines[actualStart - 1].startsWith('@OptIn'))) {
  actualStart--;
}

let braceCount = 0;
let started = false;
let end = start;
for (let i = start; i < lines.length; i++) {
  braceCount += (lines[i].match(/\{/g) || []).length;
  braceCount -= (lines[i].match(/\}/g) || []).length;
  if (lines[i].includes('{')) started = true;
  if (started && braceCount === 0) {
    end = i;
    break;
  }
}

const before = lines.slice(0, actualStart).join('\n');
const after = lines.slice(end + 1).join('\n');

const newScreen = `@Composable
fun PracticeFeedbackScreen(
  task: DayTask,
  cityName: String,
  character: ChatCharacter,
  feedback: SessionFeedback?,
  isLoading: Boolean,
  onCompleted: () -> Unit,
  onBackToChat: () -> Unit
) {
  Scaffold(
    modifier = Modifier.fillMaxSize(),
    topBar = {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .background(MaterialTheme.colorScheme.background)
          .padding(
            top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding() + 12.dp,
            bottom = 16.dp,
            start = 16.dp,
            end = 16.dp
          )
      ) {
        Column {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
          ) {
            Box(
              modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface)
                .border(1.dp, MaterialTheme.colorScheme.primary, CircleShape),
              contentAlignment = Alignment.Center
            ) {
              Text(text = character.avatar, fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column {
              Text(
                text = "\${character.name}'s Feedback",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold, letterSpacing = (-0.3).sp),
                color = MaterialTheme.colorScheme.onSurface
              )
            }
            Spacer(modifier = Modifier.weight(1f))
            TextButton(
              onClick = onBackToChat,
              contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
              colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.primary)
            ) {
              Text("Back 💬", fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }
          }
        }
      }
    }
  ) { paddingValues ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
        .padding(paddingValues),
      contentAlignment = Alignment.Center
    ) {
      if (isLoading) {
        Column(
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center,
          modifier = Modifier.padding(24.dp)
        ) {
          CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary,
            strokeWidth = 3.5.dp,
            modifier = Modifier.size(48.dp)
          )
          Spacer(modifier = Modifier.height(16.dp))
          Text(
            text = "Reviewing your practice...",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSurface
          )
        }
      } else if (feedback != null) {
        Column(
          modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Spacer(modifier = Modifier.height(24.dp))
          
          Text("🎉", fontSize = 64.sp)
          Spacer(modifier = Modifier.height(16.dp))
          
          Text(
            text = "Great job today!",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.ExtraBold),
            color = MaterialTheme.colorScheme.primary
          )
          
          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = "You sounded clearer today. Let's keep practicing to build smoother sentences.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
          )
          
          Spacer(modifier = Modifier.height(48.dp))
          
          feedback.improvement?.let { imp ->
            Card(
              modifier = Modifier.fillMaxWidth(),
              colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
              shape = RoundedCornerShape(16.dp)
            ) {
              Column(modifier = Modifier.padding(16.dp)) {
                Text("Tip for next time:", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(8.dp))
                
                Text("Instead of saying:", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text("\\"\${imp.userOriginal}\\"", fontStyle = FontStyle.Italic, color = MaterialTheme.colorScheme.onSurface)
                
                Spacer(modifier = Modifier.height(12.dp))
                
                Text("Try making it more natural:", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
                Text("\\"\${imp.natural}\\"", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onPrimaryContainer)
              }
            }
            Spacer(modifier = Modifier.height(32.dp))
          }
          
          Spacer(modifier = Modifier.weight(1f))
          
          Button(
            onClick = onCompleted,
            modifier = Modifier
              .fillMaxWidth()
              .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            shape = RoundedCornerShape(16.dp)
          ) {
            Text("Finish Practice", fontSize = 16.sp, fontWeight = FontWeight.Bold)
          }
          
          Spacer(modifier = Modifier.height(24.dp))
        }
      }
    }
  }
}`;

fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', before + '\n' + newScreen + '\n' + after);
console.log('Replaced PracticeFeedbackScreen');
