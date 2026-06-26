const fs = require('fs');

const code = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');
const lines = code.split('\n');

const start = lines.findIndex(l => l.includes('fun FluentCityWeeklyReassessmentScreen('));
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

const newScreen = `@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FluentCityWeeklyReassessmentScreen(
  onboardingData: UserOnboardingData,
  calibrationResult: CalibrationAnalysisResult?,
  reassessmentHistory: List<WeeklyReassessmentResult>,
  onBack: () -> Unit
) {
  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text("Progress Review", fontWeight = FontWeight.Bold) },
        navigationIcon = {
          IconButton(onClick = onBack) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
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
      Spacer(modifier = Modifier.height(32.dp))
      
      Box(
        modifier = Modifier
          .size(100.dp)
          .clip(CircleShape)
          .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
      ) {
        Text("🌱", fontSize = 48.sp)
      }
      
      Spacer(modifier = Modifier.height(32.dp))
      
      Text(
        text = "You're Making Progress!",
        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.ExtraBold),
        color = MaterialTheme.colorScheme.primary,
        textAlign = TextAlign.Center
      )
      
      Spacer(modifier = Modifier.height(16.dp))
      
      Text(
        text = "You sounded clearer and more confident this week. Your practice is paying off.",
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f),
        textAlign = TextAlign.Center
      )
      
      Spacer(modifier = Modifier.height(32.dp))
      
      Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        shape = RoundedCornerShape(16.dp)
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Text("Focus for next week:", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
          Spacer(modifier = Modifier.height(8.dp))
          Text("Let's practise building smoother sentences and using more natural expressions.", color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
      }
      
      Spacer(modifier = Modifier.weight(1f))
      
      Button(
        onClick = onBack,
        modifier = Modifier
          .fillMaxWidth()
          .height(56.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
      ) {
        Text("Continue Learning", fontSize = 16.sp, fontWeight = FontWeight.Bold)
      }
    }
  }
}`;

fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', before + '\n' + newScreen + '\n' + after);
console.log('Replaced FluentCityWeeklyReassessmentScreen');
