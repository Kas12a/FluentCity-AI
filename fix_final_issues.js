const fs = require('fs');
let code = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');

code = code.replace(/onCompleteReassessment: \(Map<String, String>\) -> Unit/g, 'onCompleteReassessment: (WeeklyReassessmentAnswers) -> Unit');

code = code.replace(/item\.original\}/g, 'item.originalPrompt}');
code = code.replace(/item\.corrected\}/g, 'item.targetPhrase}');

fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', code);
console.log('Fixed types and property names');
