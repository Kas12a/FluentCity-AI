const fs = require('fs');

const code = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');
const lines = code.split('\n');

const startMetric = lines.findIndex(l => l.includes('fun AssessmentMetricItem('));
if (startMetric !== -1) {
  let endMetric = startMetric;
  let braceCount = 0;
  let started = false;
  for (let i = startMetric; i < lines.length; i++) {
    braceCount += (lines[i].match(/\{/g) || []).length;
    braceCount -= (lines[i].match(/\}/g) || []).length;
    if (lines[i].includes('{')) started = true;
    if (started && braceCount === 0) {
      endMetric = i;
      break;
    }
  }
  lines.splice(startMetric - 1, endMetric - startMetric + 2); // Also removes @Composable if it exists
}

const startRubric = lines.findIndex(l => l.includes('fun RubricCategoryCard('));
if (startRubric !== -1) {
  let endRubric = startRubric;
  let braceCount = 0;
  let started = false;
  for (let i = startRubric; i < lines.length; i++) {
    braceCount += (lines[i].match(/\{/g) || []).length;
    braceCount -= (lines[i].match(/\}/g) || []).length;
    if (lines[i].includes('{')) started = true;
    if (started && braceCount === 0) {
      endRubric = i;
      break;
    }
  }
  lines.splice(startRubric - 1, endRubric - startRubric + 2); 
}

const startRubricClass = lines.findIndex(l => l.includes('data class RubricCategoryItem('));
if (startRubricClass !== -1) {
  let endRubricClass = startRubricClass;
  let braceCount = 0;
  let started = false;
  for (let i = startRubricClass; i < lines.length; i++) {
    braceCount += (lines[i].match(/\{/g) || []).length;
    braceCount -= (lines[i].match(/\}/g) || []).length;
    if (lines[i].includes('{') || lines[i].includes('(')) started = true; // Wait, data class might end with ) if no body
    if (started && braceCount === 0 && !lines[i].includes('(') && !lines[i].includes('=')) {
      // It's a bit tricky to parse data class boundaries without proper AST.
      // We will just find the next top-level or blank line.
    }
  }
}

// Since data class might be simple, let's just do regex replacement
let newCode = lines.join('\n');
newCode = newCode.replace(/data class RubricCategoryItem\([\s\S]*?\n\)/g, '');

fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', newCode);
console.log('Removed unused components');
