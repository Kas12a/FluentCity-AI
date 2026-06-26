const fs = require('fs');

const code = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');
const lines = code.split('\n');

const start = lines.findIndex(l => l.includes('fun FluentCityCheckResultPage('));
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
fun FluentCityCheckResultPage(
  onboardingData: UserOnboardingData,
  calibrationResult: CalibrationAnalysisResult?,
  isCalibrating: Boolean,
  calibrationError: String?,
  onRetry: () -> Unit,
  onContinue: () -> Unit,
  onBack: () -> Unit
) {
  val scrollState = rememberScrollState()

  if (isCalibrating) {
    Scaffold(
      modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
      Box(
        modifier = Modifier
          .fillMaxSize()
          .background(MaterialTheme.colorScheme.background)
          .padding(paddingValues)
          .padding(24.dp),
        contentAlignment = Alignment.Center
      ) {
        Column(
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center,
          modifier = Modifier.fillMaxWidth().widthIn(max = 450.dp)
        ) {
          CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary,
            strokeWidth = 4.dp,
            modifier = Modifier.size(64.dp)
          )
          Spacer(modifier = Modifier.height(24.dp))
          Text(
            text = "Building your personalized plan",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
          )
        }
      }
    }
    return
  }

  Scaffold(
    modifier = Modifier.fillMaxSize()
  ) { paddingValues ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
        .padding(paddingValues)
    ) {
      Column(
        modifier = Modifier
          .fillMaxSize()
          .verticalScroll(scrollState)
          .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Spacer(modifier = Modifier.height(64.dp))
        
        Box(
          modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer),
          contentAlignment = Alignment.Center
        ) {
          Text("🏆", fontSize = 48.sp)
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Text(
          text = "Your plan is ready!",
          style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.ExtraBold),
          color = MaterialTheme.colorScheme.primary,
          textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
          text = "We designed a custom 7-day study plan to help you feel confident in \${onboardingData.city}.",
          style = MaterialTheme.typography.bodyLarge,
          color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f),
          textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.weight(1f))
        
        Button(
          onClick = onContinue,
          modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(bottom = 16.dp),
          colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
          shape = RoundedCornerShape(16.dp)
        ) {
          Text("Start Your Journey", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
        
        Spacer(modifier = Modifier.height(24.dp))
      }
    }
  }
}`;

fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', before + '\n' + newScreen + '\n' + after);
console.log('Replaced FluentCityCheckResultPage');
