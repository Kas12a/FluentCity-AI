const fs = require('fs');
let text = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');
let match = text.match(/containerColor = MaterialTheme\.colorScheme\.onSurface/g);
console.log('onSurface cards:', match ? match.length : 0);
let match2 = text.match(/containerColor = MaterialTheme\.colorScheme\.surface\b/g);
console.log('surface cards:', match2 ? match2.length : 0);
