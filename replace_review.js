const fs = require('fs');

const code = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');
const lines = code.split('\n');

const start = lines.findIndex(l => l.includes('fun FluentCityReviewScreen('));
let actualStart = start;
while (actualStart > 0 && (lines[actualStart - 1].startsWith('@Composable') || lines[actualStart - 1].startsWith('@OptIn'))) {
  actualStart--;
}

let braceCount = 0;
let started = false;
let end = start;
for (let i = start; i < lines.length; i++) {
  braceCount += (lines[i].match(/\{/g) || []).length;
  braceCount -= (lines[i].match(/\}/g) || []).length;
  if (lines[i].includes('{')) started = true;
  if (started && braceCount === 0) {
    end = i;
    break;
  }
}

const before = lines.slice(0, actualStart).join('\n');
const after = lines.slice(end + 1).join('\n');

const newScreen = `@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FluentCityReviewScreen(
  reviewItems: List<ReviewItem>,
  onBack: () -> Unit
) {
  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text("Review Mode", fontWeight = FontWeight.Bold) },
        navigationIcon = {
          IconButton(onClick = onBack) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
      )
    },
    containerColor = MaterialTheme.colorScheme.background
  ) { paddingValues ->
    if (reviewItems.isEmpty()) {
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
      ) {
        Text("🎉", fontSize = 64.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
          "All caught up!",
          style = MaterialTheme.typography.titleLarge,
          fontWeight = FontWeight.Bold,
          color = MaterialTheme.colorScheme.primary
        )
        Text(
          "You have no items to review right now.",
          style = MaterialTheme.typography.bodyMedium,
          color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
        )
      }
    } else {
      LazyColumn(
        modifier = Modifier
          .fillMaxSize()
          .padding(paddingValues)
          .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        items(reviewItems) { item ->
          Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            shape = RoundedCornerShape(16.dp)
          ) {
            Column(modifier = Modifier.padding(16.dp)) {
              Text(
                text = "Instead of:",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
              )
              Text(
                text = "\\"\${item.original}\\"",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                fontStyle = FontStyle.Italic
              )
              Spacer(modifier = Modifier.height(12.dp))
              Text(
                text = "Try saying:",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
              )
              Text(
                text = "\\"\${item.corrected}\\"",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
              )
            }
          }
        }
      }
    }
  }
}`;

fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', before + '\n' + newScreen + '\n' + after);
console.log('Replaced FluentCityReviewScreen');
