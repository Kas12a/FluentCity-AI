const fs = require('fs');

const code = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');
let newCode = code.replace(
  'onStartPractice = { task ->\n            activePracticeTask = task\n            currentScreen = Screen.LessonValidation\n          }',
  'onStartPractice = { task ->\n            activePracticeTask = task\n            currentScreen = Screen.PracticeModeSelection\n          }'
);

newCode = newCode.replace(
  'onStartPractice = { task ->\n            activePracticeTask = task\n            currentScreen = Screen.LessonValidation\n          }', // If there's another occurrence
  'onStartPractice = { task ->\n            activePracticeTask = task\n            currentScreen = Screen.PracticeModeSelection\n          }'
);

fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', newCode);
console.log('Bypassed LessonValidation');
