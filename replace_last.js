const fs = require('fs');
let text = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');
text = text.replace(/Color\(0xFF1D4ED8\)/g, 'MaterialTheme.colorScheme.primary');
fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', text);
