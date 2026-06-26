const fs = require('fs');
let text = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');

const replacements = {
  // Surface variants
  'Color\\(0xFFE2E8F0\\)': 'MaterialTheme.colorScheme.surfaceVariant',
  'Color\\(0xFFF1F5F9\\)': 'MaterialTheme.colorScheme.surfaceVariant',
  'Color\\(0xFFF8FAFC\\)': 'MaterialTheme.colorScheme.background',
  'Color\\(0xFFF8FAF7\\)': 'MaterialTheme.colorScheme.background',

  // Warning / Amber
  'Color\\(0xFFFFFBEB\\)': 'MaterialTheme.colorScheme.secondaryContainer',
  'Color\\(0xFFFEF3C7\\)': 'MaterialTheme.colorScheme.secondaryContainer',
  'Color\\(0xFFFDE68A\\)': 'MaterialTheme.colorScheme.secondaryContainer',
  'Color\\(0xFFB45309\\)': 'MaterialTheme.colorScheme.onSecondaryContainer',
  'Color\\(0xFF92400E\\)': 'MaterialTheme.colorScheme.onSecondaryContainer',
  'Color\\(0xFF78350F\\)': 'MaterialTheme.colorScheme.onSecondaryContainer',
  'Color\\(0xFFD97706\\)': 'MaterialTheme.colorScheme.secondary',
  'Color\\(0xFFF97316\\)': 'MaterialTheme.colorScheme.secondary',

  // Success / Green
  'Color\\(0xFFE6F4EA\\)': 'MaterialTheme.colorScheme.tertiaryContainer',
  'Color\\(0xFFF0FDF4\\)': 'MaterialTheme.colorScheme.tertiaryContainer',
  'Color\\(0xFFDCFCE7\\)': 'MaterialTheme.colorScheme.tertiaryContainer',
  'Color\\(0xFFECFDF5\\)': 'MaterialTheme.colorScheme.tertiaryContainer',
  'Color\\(0xFFD1FAE5\\)': 'MaterialTheme.colorScheme.tertiaryContainer',
  'Color\\(0xFFA7F3D0\\)': 'MaterialTheme.colorScheme.tertiaryContainer',
  'Color\\(0xFF059669\\)': 'MaterialTheme.colorScheme.tertiary',
  'Color\\(0xFF15803D\\)': 'MaterialTheme.colorScheme.tertiary',
  'Color\\(0xFF065F46\\)': 'MaterialTheme.colorScheme.onTertiaryContainer',
  'Color\\(0xFF047857\\)': 'MaterialTheme.colorScheme.onTertiaryContainer',
  'Color\\(0xFF045F43\\)': 'MaterialTheme.colorScheme.onTertiaryContainer',
  'Color\\(0xFF166534\\)': 'MaterialTheme.colorScheme.onTertiaryContainer',
  'Color\\(0xFF14532D\\)': 'MaterialTheme.colorScheme.onTertiaryContainer',

  // Blue / Info
  'Color\\(0xFFF0FDFA\\)': 'MaterialTheme.colorScheme.primaryContainer',
  'Color\\(0xFFE0F2FE\\)': 'MaterialTheme.colorScheme.primaryContainer',
  'Color\\(0xFFEFF6FF\\)': 'MaterialTheme.colorScheme.primaryContainer',
  'Color\\(0xFFBFDBFE\\)': 'MaterialTheme.colorScheme.primaryContainer',
  'Color\\(0xFFDBEAFE\\)': 'MaterialTheme.colorScheme.primaryContainer',
  'Color\\(0xFFF0F9FF\\)': 'MaterialTheme.colorScheme.primaryContainer',
  'Color\\(0xFF3B82F6\\)': 'MaterialTheme.colorScheme.primary',
  'Color\\(0xFF0284C7\\)': 'MaterialTheme.colorScheme.primary',
  'Color\\(0xFF2563EB\\)': 'MaterialTheme.colorScheme.primary',
  'Color\\(0xFF0EA5E9\\)': 'MaterialTheme.colorScheme.primary',
  'Color\\(0xFF0369A1\\)': 'MaterialTheme.colorScheme.onPrimaryContainer',
  'Color\\(0xFF0F766E\\)': 'MaterialTheme.colorScheme.onPrimaryContainer',
  'Color\\(0xFF1E40AF\\)': 'MaterialTheme.colorScheme.onPrimaryContainer',
  'Color\\(0xFF1E3A8A\\)': 'MaterialTheme.colorScheme.onPrimaryContainer',
  'Color\\(0xFF0C4A6E\\)': 'MaterialTheme.colorScheme.onPrimaryContainer',
  'Color\\(0xFF032F30\\)': 'MaterialTheme.colorScheme.onPrimaryContainer',

  // Red / Error
  'Color\\(0xFFFEF2F2\\)': 'MaterialTheme.colorScheme.errorContainer',
  'Color\\(0xFFFEE2E2\\)': 'MaterialTheme.colorScheme.errorContainer',
  'Color\\(0xFFFCA5A5\\)': 'MaterialTheme.colorScheme.errorContainer',
  'Color\\(0xFFFECACA\\)': 'MaterialTheme.colorScheme.errorContainer',
  'Color\\(0xFFDC2626\\)': 'MaterialTheme.colorScheme.error',
  'Color\\(0xFFB91C1C\\)': 'MaterialTheme.colorScheme.error',
  'Color\\(0xFF991B1B\\)': 'MaterialTheme.colorScheme.onErrorContainer',
  'Color\\(0xFF7F1D1D\\)': 'MaterialTheme.colorScheme.onErrorContainer',

  // Purples and Pinks (Fallback to primary or secondary)
  'Color\\(0xFFFDF2F8\\)': 'MaterialTheme.colorScheme.secondaryContainer',
  'Color\\(0xFFFBCFE8\\)': 'MaterialTheme.colorScheme.secondaryContainer',
  'Color\\(0xFFF5F3FF\\)': 'MaterialTheme.colorScheme.primaryContainer',
  'Color\\(0xFFDDD6FE\\)': 'MaterialTheme.colorScheme.primaryContainer',
  'Color\\(0xFFECE9FC\\)': 'MaterialTheme.colorScheme.primaryContainer',
  'Color\\(0xFFDB2777\\)': 'MaterialTheme.colorScheme.secondary',
  'Color\\(0xFFEC4899\\)': 'MaterialTheme.colorScheme.secondary',
  'Color\\(0xFF8B5CF6\\)': 'MaterialTheme.colorScheme.primary',
  'Color\\(0xFF7C3AED\\)': 'MaterialTheme.colorScheme.primary',
  'Color\\(0xFF6D28D9\\)': 'MaterialTheme.colorScheme.primary',
  'Color\\(0xFF5B21B6\\)': 'MaterialTheme.colorScheme.onPrimaryContainer',
  'Color\\(0xFF4C1D95\\)': 'MaterialTheme.colorScheme.onPrimaryContainer',
  'Color\\(0xFF9D174D\\)': 'MaterialTheme.colorScheme.onSecondaryContainer',
  'Color\\(0xFF831843\\)': 'MaterialTheme.colorScheme.onSecondaryContainer',
  
  // Teal 
  'Color\\(0xFF06B6D4\\)': 'MaterialTheme.colorScheme.primary',
  
  // Brown
  'Color\\(0xFF451A03\\)': 'MaterialTheme.colorScheme.onSecondaryContainer',
};

for (const [key, value] of Object.entries(replacements)) {
  text = text.replace(new RegExp(key, 'g'), value);
}

fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', text);
console.log("Colors replaced.");
