const fs = require('fs');

const code = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');
const lines = code.split('\n');

const start = lines.findIndex(l => l.includes('fun FluentCityProgressScreen('));
let end = start;
let braceCount = 0;
let started = false;
for (let i = start; i < lines.length; i++) {
  const line = lines[i];
  braceCount += (line.match(/\{/g) || []).length;
  braceCount -= (line.match(/\}/g) || []).length;
  if (line.includes('{')) started = true;
  if (started && braceCount === 0) {
    end = i;
    break;
  }
}

const before = lines.slice(0, start).join('\n');
const after = lines.slice(end + 1).join('\n');

const newProgress = `@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun FluentCityProgressScreen(
  onboardingData: UserOnboardingData,
  dayTasks: List<DayTask>,
  calibrationResult: CalibrationAnalysisResult?,
  completedDays: Set<Int>,
  learningProfile: LearningProfile?,
  onBack: () -> Unit,
  onStartPractice: (DayTask) -> Unit,
  recordedMistakes: List<RecordedMistake> = emptyList(),
  reviewItems: List<ReviewItem> = emptyList(),
  confidenceRatings: Map<Int, String> = emptyMap(),
  sessionImprovements: Map<Int, ImprovementDetail> = emptyMap()
) {
  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text("Progress", fontWeight = FontWeight.Bold) },
        navigationIcon = {
          IconButton(onClick = onBack) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
      )
    },
    containerColor = MaterialTheme.colorScheme.background
  ) { paddingValues ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
        .padding(24.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Spacer(modifier = Modifier.height(24.dp))
      
      Box(
        modifier = Modifier
          .size(120.dp)
          .clip(CircleShape)
          .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
      ) {
        Text("📈", fontSize = 64.sp)
      }
      
      Spacer(modifier = Modifier.height(32.dp))
      
      Text(
        text = "Your English is Improving!",
        style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.ExtraBold),
        color = MaterialTheme.colorScheme.primary,
        textAlign = TextAlign.Center
      )
      
      Spacer(modifier = Modifier.height(8.dp))
      
      Text(
        text = "Keep up the daily practice to build your confidence and fluency.",
        fontSize = 16.sp,
        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
        textAlign = TextAlign.Center
      )
      
      Spacer(modifier = Modifier.height(48.dp))
      
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
      ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
          Text(text = "\${completedDays.size}", fontSize = 32.sp, fontWeight = FontWeight.Black, color = MaterialTheme.colorScheme.primary)
          Text(text = "Days Completed", fontSize = 14.sp, color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f))
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
          val mins = 12 + (completedDays.size * onboardingData.practiceMinutes)
          Text(text = "\$mins", fontSize = 32.sp, fontWeight = FontWeight.Black, color = MaterialTheme.colorScheme.secondary)
          Text(text = "Minutes Practiced", fontSize = 14.sp, color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f))
        }
      }
      
      Spacer(modifier = Modifier.weight(1f))
      
      Button(
        onClick = onBack,
        modifier = Modifier
          .fillMaxWidth()
          .height(56.dp),
        colors = ButtonDefaults.buttonColors(
          containerColor = MaterialTheme.colorScheme.primary
        ),
        shape = RoundedCornerShape(16.dp)
      ) {
        Text("Back to Dashboard", fontWeight = FontWeight.Bold, fontSize = 16.sp)
      }
    }
  }
}`;

fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', before + '\n' + newProgress + '\n' + after);
console.log('Replaced progress screen');
