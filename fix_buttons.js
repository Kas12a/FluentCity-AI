const fs = require('fs');
let text = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');

text = text.replace(/containerColor = MaterialTheme\.colorScheme\.secondary,\s*contentColor = MaterialTheme\.colorScheme\.onSurface/g, 'containerColor = MaterialTheme.colorScheme.secondary, contentColor = MaterialTheme.colorScheme.onSecondary');
text = text.replace(/containerColor = MaterialTheme\.colorScheme\.primary,\s*contentColor = MaterialTheme\.colorScheme\.onSurface/g, 'containerColor = MaterialTheme.colorScheme.primary, contentColor = MaterialTheme.colorScheme.onPrimary');
text = text.replace(/containerColor = MaterialTheme\.colorScheme\.tertiary,\s*contentColor = MaterialTheme\.colorScheme\.onSurface/g, 'containerColor = MaterialTheme.colorScheme.tertiary, contentColor = MaterialTheme.colorScheme.onTertiary');
text = text.replace(/containerColor = if \(failedCheckCount > 0\) MaterialTheme\.colorScheme\.outlineVariant else MaterialTheme\.colorScheme\.primary,\s*contentColor = MaterialTheme\.colorScheme\.onSurface/g, 'containerColor = if (failedCheckCount > 0) MaterialTheme.colorScheme.outlineVariant else MaterialTheme.colorScheme.primary, contentColor = if (failedCheckCount > 0) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onPrimary');

fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', text);
console.log("Replaced button colors for better contrast.");
