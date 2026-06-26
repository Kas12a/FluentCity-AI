const fs = require('fs');
let text = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');

text = text.replace(/\.background\(MaterialTheme\.colorScheme\.onSurface, CircleShape\)/g, '.background(Color.Transparent, CircleShape)');

fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', text);
console.log("Replaced onSurface circles with Transparent.");
