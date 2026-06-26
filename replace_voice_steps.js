const fs = require('fs');

const code = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');
const lines = code.split('\n');

const startIndex = lines.findIndex(l => l.includes('if (currentStep == VoiceMissionStep.WARMUP) {'));

// find "else {" followed by "// Chat UI for ROLEPLAY"
let endIndex = -1;
for (let i = startIndex; i < lines.length; i++) {
  if (lines[i].includes('else {') && lines[i+1].includes('// Chat UI for ROLEPLAY')) {
    endIndex = i;
    break;
  }
}

if (startIndex !== -1 && endIndex !== -1) {
  const before = lines.slice(0, startIndex).join('\n');
  const after = lines.slice(endIndex + 1).join('\n');

  const feedbackCode = `      if (currentStep == VoiceMissionStep.FEEDBACK) {
        Text("Mission Complete! 🎉", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.ExtraBold)
        Spacer(modifier = Modifier.height(16.dp))
        
        Card(modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState())) {
          Column(modifier = Modifier.padding(16.dp)) {
            Text("Short Feedback", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.secondary)
            Spacer(modifier = Modifier.height(8.dp))
            
            Text("What you said:", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.error)
            Text(feedbackData?.improvement?.userOriginal ?: latestUserMessage, fontStyle = FontStyle.Italic)
            
            Spacer(modifier = Modifier.height(12.dp))
            Text("Better way to say it:", fontWeight = FontWeight.Bold, color = Color(0xFF00796B))
            Text(feedbackData?.improvement?.natural ?: feedbackData?.grammar?.naturalVersion ?: "Great as is!")
            
            Spacer(modifier = Modifier.height(24.dp))
            Button(
              onClick = { 
                onCompleted(task.day, feedbackData, emptyList(), "Confident") 
              },
              modifier = Modifier.fillMaxWidth().height(50.dp),
              shape = RoundedCornerShape(12.dp)
            ) {
              Text("Finish & Save Progress", fontWeight = FontWeight.Bold)
            }
          }
        }
      }
      else {`;

  fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', before + '\n' + feedbackCode + '\n' + after);
  console.log('Replaced steps');
} else {
  console.log('Could not find bounds: start=' + startIndex + ' end=' + endIndex);
}
