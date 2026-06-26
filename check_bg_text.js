const fs = require('fs');
let text = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');
let match = text.match(/color = MaterialTheme\.colorScheme\.background/g);
console.log('Background text usages:', match ? match.length : 0);
let match2 = text.match(/color = MaterialTheme\.colorScheme\.outlineVariant/g);
console.log('OutlineVariant text usages:', match2 ? match2.length : 0);
