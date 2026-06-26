const fs = require('fs');
let text = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');
let match = text.match(/Color\(0x[0-9A-Fa-f]{8}\)/g);
if (match) {
    let counts = {};
    match.forEach(c => counts[c] = (counts[c] || 0) + 1);
    console.log(counts);
} else {
    console.log("No hardcoded colors found.");
}
