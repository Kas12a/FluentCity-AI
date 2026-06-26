const fs = require('fs');
let text = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');

text = text.replace(/Color\(0xFF0F172A\)/g, "MaterialTheme.colorScheme.background");
text = text.replace(/Color\(0xFF1E293B\)/g, "MaterialTheme.colorScheme.surface");
text = text.replace(/Color\(0xFF14B8A6\)/g, "MaterialTheme.colorScheme.primary");
text = text.replace(/Color\(0xFFF59E0B\)/g, "MaterialTheme.colorScheme.secondary");
text = text.replace(/Color\(0xFF334155\)/g, "MaterialTheme.colorScheme.outline");
text = text.replace(/Color\(0xFF94A3B8\)/g, "MaterialTheme.colorScheme.onSurfaceVariant");
text = text.replace(/Color\(0xFF64748B\)/g, "MaterialTheme.colorScheme.onSurfaceVariant");
text = text.replace(/Color\(0xFF475569\)/g, "MaterialTheme.colorScheme.outlineVariant");
text = text.replace(/Color\(0xFFCBD5E1\)/g, "MaterialTheme.colorScheme.outlineVariant");
text = text.replace(/Color\(0xFF022C22\)/g, "MaterialTheme.colorScheme.onPrimary");
text = text.replace(/Color\(0xFF042F2E\)/g, "MaterialTheme.colorScheme.onPrimary");
text = text.replace(/Color\.White\.copy\(alpha = 0\.6f\)/g, "MaterialTheme.colorScheme.onSurfaceVariant");
text = text.replace(/Color\.White\.copy\(alpha = 0\.7f\)/g, "MaterialTheme.colorScheme.onSurfaceVariant");
text = text.replace(/Color\.White\.copy\(alpha = 0\.5f\)/g, "MaterialTheme.colorScheme.onSurfaceVariant");
text = text.replace(/Color\.White\.copy\(alpha = 0\.8f\)/g, "MaterialTheme.colorScheme.onSurface");
text = text.replace(/Color\.White/g, "MaterialTheme.colorScheme.onSurface");
text = text.replace(/Color\(0xFFEF4444\)/g, "MaterialTheme.colorScheme.error");
text = text.replace(/Color\(0xFFF87171\)/g, "MaterialTheme.colorScheme.error");
text = text.replace(/Color\(0xFF4ADE80\)/g, "MaterialTheme.colorScheme.tertiary");
text = text.replace(/Color\(0xFF22C55E\)/g, "MaterialTheme.colorScheme.tertiary");
text = text.replace(/Color\(0xFF10B981\)/g, "MaterialTheme.colorScheme.tertiary");
text = text.replace(/Color\(0xFF0D9488\)/g, "MaterialTheme.colorScheme.primary");

fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', text);
