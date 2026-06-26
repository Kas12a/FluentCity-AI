const fs = require('fs');
let text = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');

const newMetricsUI = `
            Spacer(modifier = Modifier.height(16.dp))
            DividerHorizontal(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f))
            Spacer(modifier = Modifier.height(16.dp))

            // Scores Row
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              if (calibrationResult?.speakingLevel != null) {
                AssessmentMetricItem(modifier = Modifier.weight(1f), label = "SPEAKING", value = calibrationResult.speakingLevel)
              }
              if (calibrationResult?.listeningLevel != null) {
                AssessmentMetricItem(modifier = Modifier.weight(1f), label = "LISTENING", value = calibrationResult.listeningLevel)
              }
              if (calibrationResult?.readingLevel != null) {
                AssessmentMetricItem(modifier = Modifier.weight(1f), label = "READING", value = calibrationResult.readingLevel)
              }
              if (calibrationResult?.writingLevel != null) {
                AssessmentMetricItem(modifier = Modifier.weight(1f), label = "WRITING", value = calibrationResult.writingLevel)
              }
            }
`;

const replaceRegex = /\/\/ Three Main Metrics Request[\s\S]*?\/\/ Evaluation details card/;
if (replaceRegex.test(text)) {
    text = text.replace(replaceRegex, newMetricsUI + '\n          }\n        }\n\n        Spacer(modifier = Modifier.height(20.dp))\n\n        // Evaluation details card');
    fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', text);
    console.log('Successfully updated metrics UI.');
} else {
    console.log('Metrics UI section not found.');
}
