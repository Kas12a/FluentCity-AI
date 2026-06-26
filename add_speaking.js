const fs = require('fs');
let text = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');

const stepSpeakingQuestionCode = `
@Composable
fun StepSpeakingQuestion(
  title: String,
  infoMsg: String,
  value: String,
  onValueChange: (String) -> Unit,
  placeholder: String,
  testTag: String
) {
  val context = LocalContext.current
  var microphoneBlocked by remember { mutableStateOf(false) }

  val speechRecognizerLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.StartActivityForResult(),
    onResult = { result ->
      if (result.resultCode == android.app.Activity.RESULT_OK) {
        val data = result.data
        val results = data?.getStringArrayListExtra(android.speech.RecognizerIntent.EXTRA_RESULTS)
        val spokenText = results?.get(0) ?: ""
        if (spokenText.isNotEmpty()) {
          val current = value.trim()
          val newText = if (current.isEmpty()) spokenText else current + " " + spokenText
          onValueChange(newText)
        }
      }
    }
  )

  val permissionLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.RequestPermission(),
    onResult = { isGranted ->
      if (isGranted) {
        microphoneBlocked = false
        val intent = android.content.Intent(android.speech.RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
          putExtra(android.speech.RecognizerIntent.EXTRA_LANGUAGE_MODEL, android.speech.RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
          putExtra(android.speech.RecognizerIntent.EXTRA_PROMPT, "Speak your answer...")
        }
        try {
          speechRecognizerLauncher.launch(intent)
        } catch (e: Exception) {
          android.util.Log.e("FluentCity", "Failed to launch speech recognizer", e)
        }
      } else {
        microphoneBlocked = true
      }
    }
  )

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .widthIn(max = 500.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Box(
      modifier = Modifier
        .size(64.dp)
        .clip(CircleShape)
        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)),
      contentAlignment = Alignment.Center
    ) {
      Icon(
        imageVector = Icons.Default.Info,
        contentDescription = null,
        tint = MaterialTheme.colorScheme.primary,
        modifier = Modifier.size(32.dp)
      )
    }

    Spacer(modifier = Modifier.height(16.dp))

    Text(
      text = title,
      style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
      textAlign = TextAlign.Center,
      color = MaterialTheme.colorScheme.onBackground
    )

    Spacer(modifier = Modifier.height(8.dp))

    Text(
      text = infoMsg,
      style = MaterialTheme.typography.bodyMedium,
      color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.65f),
      textAlign = TextAlign.Center,
      modifier = Modifier.padding(horizontal = 8.dp)
    )

    Spacer(modifier = Modifier.height(24.dp))

    if (microphoneBlocked) {
      Text(
        text = "Microphone access is blocked. You can still type your answer.",
        color = MaterialTheme.colorScheme.error,
        style = MaterialTheme.typography.bodySmall,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(bottom = 12.dp)
      )
    }

    OutlinedTextField(
      value = value,
      onValueChange = onValueChange,
      placeholder = { Text(placeholder) },
      minLines = 4,
      maxLines = 8,
      colors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = MaterialTheme.colorScheme.onSurface,
        unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
        focusedContainerColor = MaterialTheme.colorScheme.surface,
        unfocusedContainerColor = MaterialTheme.colorScheme.surface,
        focusedBorderColor = MaterialTheme.colorScheme.primary,
        unfocusedBorderColor = MaterialTheme.colorScheme.outline,
        focusedLabelColor = MaterialTheme.colorScheme.primary,
        focusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
        unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
        cursorColor = MaterialTheme.colorScheme.primary
      ),
      shape = RoundedCornerShape(16.dp),
      modifier = Modifier
        .fillMaxWidth()
        .height(160.dp)
        .testTag(testTag)
    )

    Spacer(modifier = Modifier.height(16.dp))

    Button(
      onClick = {
        if (androidx.core.content.ContextCompat.checkSelfPermission(context, android.Manifest.permission.RECORD_AUDIO) == android.content.pm.PackageManager.PERMISSION_GRANTED) {
          microphoneBlocked = false
          val intent = android.content.Intent(android.speech.RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(android.speech.RecognizerIntent.EXTRA_LANGUAGE_MODEL, android.speech.RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(android.speech.RecognizerIntent.EXTRA_PROMPT, "Speak your answer...")
          }
          try {
            speechRecognizerLauncher.launch(intent)
          } catch (e: Exception) {
             android.util.Log.e("FluentCity", "Failed to launch speech recognizer", e)
          }
        } else {
          permissionLauncher.launch(android.Manifest.permission.RECORD_AUDIO)
        }
      },
      colors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.onSecondaryContainer
      ),
      shape = RoundedCornerShape(24.dp),
      modifier = Modifier.height(48.dp)
    ) {
      Icon(
        imageVector = Icons.Default.Mic,
        contentDescription = "Record Voice",
        modifier = Modifier.size(20.dp)
      )
      Spacer(modifier = Modifier.width(8.dp))
      Text(
        text = "Tap to Speak",
        fontWeight = FontWeight.Bold
      )
    }
  }
}
`;

const markerIndex = text.indexOf('@Composable\nfun StepWritingQuestion(');
if (markerIndex !== -1) {
  text = text.substring(0, markerIndex) + stepSpeakingQuestionCode + '\n\n' + text.substring(markerIndex);
  fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', text);
  console.log('Successfully injected StepSpeakingQuestion.');
} else {
  console.log('Marker not found.');
}
