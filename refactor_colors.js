const fs = require('fs');
let text = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');

// 1. Replace containerColor = MaterialTheme.colorScheme.onSurface with surface
text = text.replace(/containerColor = MaterialTheme\.colorScheme\.onSurface(?!Variant)/g, 'containerColor = MaterialTheme.colorScheme.surface');

// 2. Replace text/icon colors from background to onSurface
text = text.replace(/color = MaterialTheme\.colorScheme\.background/g, 'color = MaterialTheme.colorScheme.onSurface');
text = text.replace(/tint = MaterialTheme\.colorScheme\.background/g, 'tint = MaterialTheme.colorScheme.onSurface');

// 3. Replace outlineVariant with onSurfaceVariant for text colors
text = text.replace(/color = MaterialTheme\.colorScheme\.outlineVariant/g, 'color = MaterialTheme.colorScheme.onSurfaceVariant');
text = text.replace(/tint = MaterialTheme\.colorScheme\.outlineVariant/g, 'tint = MaterialTheme.colorScheme.onSurfaceVariant');

// 4. In StepCityInput, the chip uses background(MaterialTheme.colorScheme.surfaceVariant). Let's make sure it's correct.

fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', text);
console.log("Replacements done.");
