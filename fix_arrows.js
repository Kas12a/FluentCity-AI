const fs = require('fs');
let code = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');

code = code.replace(/Icons\.Default\.ArrowBack/g, 'Icons.AutoMirrored.Filled.ArrowBack');
code = code.replace(/Icons\.Filled\.ArrowBack/g, 'Icons.AutoMirrored.Filled.ArrowBack');
code = code.replace(/Icons\.Default\.ArrowForward/g, 'Icons.AutoMirrored.Filled.ArrowForward');
code = code.replace(/Icons\.Filled\.ArrowForward/g, 'Icons.AutoMirrored.Filled.ArrowForward');

// Add imports
if (!code.includes('import androidx.compose.material.icons.automirrored.filled.ArrowBack')) {
  code = code.replace(
    'import androidx.compose.material.icons.filled.ArrowBack',
    'import androidx.compose.material.icons.filled.ArrowBack\nimport androidx.compose.material.icons.automirrored.filled.ArrowBack'
  );
}

if (!code.includes('import androidx.compose.material.icons.automirrored.filled.ArrowForward')) {
  code = code.replace(
    'import androidx.compose.material.icons.filled.ArrowForward',
    'import androidx.compose.material.icons.filled.ArrowForward\nimport androidx.compose.material.icons.automirrored.filled.ArrowForward'
  );
}

fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', code);
console.log('Fixed Arrow icons');
