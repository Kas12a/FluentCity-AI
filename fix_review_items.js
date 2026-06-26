const fs = require('fs');

const code = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');
let newCode = code.replace(
  'text = "\\\\"\\$\\{item.original\\}\\\\\\""',
  'text = "\\\\"\\$\\{item.originalPrompt\\}\\\\\\""'
);

newCode = newCode.replace(
  'text = "\\\\"\\$\\{item.corrected\\}\\\\\\""',
  'text = "\\\\"\\$\\{item.targetPhrase\\}\\\\\\""'
);

fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', newCode);
console.log('Fixed property names in ReviewItem!');
