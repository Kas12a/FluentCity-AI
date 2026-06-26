const fs = require('fs');
let text = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');

const newAssessmentPage = `fun FluentCityAssessmentCheckPage(
  initialData: UserOnboardingData,
  onComplete: (UserOnboardingData) -> Unit,
  onBack: () -> Unit
) {
  val skills = initialData.skillsToImprove.lowercase()
  val testSequence = mutableListOf<String>()
  if (skills == "all" || skills.contains("speaking")) testSequence.add("Speaking")
  if (skills == "all" || skills.contains("listening")) testSequence.add("Listening")
  if (skills == "all" || skills.contains("reading")) testSequence.add("Reading")
  if (skills == "all" || skills.contains("writing")) testSequence.add("Writing")

  if (testSequence.isEmpty()) testSequence.add("Speaking")

  var stepIndex by remember { mutableStateOf(0) }
  
  var speakingText by remember { mutableStateOf(initialData.checkSpeaking) }
  var listeningText by remember { mutableStateOf(initialData.checkListening) }
  var readingText by remember { mutableStateOf(initialData.checkReading) }
  var writingText by remember { mutableStateOf(initialData.checkWriting) }

  val maxSteps = testSequence.size
  val progress = (stepIndex + 1).toFloat() / maxSteps.toFloat()
  val focusManager = LocalFocusManager.current

  Scaffold(
    modifier = Modifier.fillMaxSize(),
    topBar = {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .background(MaterialTheme.colorScheme.background)
          .padding(
            top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding() + 12.dp,
            bottom = 12.dp,
            start = 16.dp,
            end = 16.dp
          ),
        verticalAlignment = Alignment.CenterVertically
      ) {
        IconButton(
          onClick = {
            if (stepIndex > 0) {
              stepIndex -= 1
            } else {
              onBack()
            }
          }
        ) {
          Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back Step",
            tint = MaterialTheme.colorScheme.primary
          )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = "Let's check your English",
          style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
          color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
          text = "Question \${stepIndex + 1} of \$maxSteps",
          style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
          color = MaterialTheme.colorScheme.secondary
        )
      }
    },
    bottomBar = {
      Surface(
        color = MaterialTheme.colorScheme.onSurface,
        modifier = Modifier
          .fillMaxWidth()
          .navigationBarsPadding()
      ) {
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp),
          contentAlignment = Alignment.Center
        ) {
          val currentSkill = testSequence[stepIndex]
          val isEnabled = when(currentSkill) {
            "Speaking" -> speakingText.isNotBlank()
            "Listening" -> listeningText.isNotBlank()
            "Reading" -> readingText.isNotBlank()
            "Writing" -> writingText.isNotBlank()
            else -> true
          }

          Button(
            onClick = {
              focusManager.clearFocus()
              if (stepIndex < maxSteps - 1) {
                stepIndex += 1
              } else {
                val completedData = initialData.copy(
                  checkSpeaking = speakingText,
                  checkListening = listeningText,
                  checkReading = readingText,
                  checkWriting = writingText
                )
                onComplete(completedData)
              }
            },
            modifier = Modifier
              .fillMaxWidth()
              .widthIn(max = 400.dp)
              .height(52.dp)
              .testTag("assessment_check_next_button")
              .shadow(4.dp, RoundedCornerShape(26.dp)),
            colors = ButtonDefaults.buttonColors(
              containerColor = MaterialTheme.colorScheme.primary,
              contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            shape = RoundedCornerShape(26.dp),
            enabled = isEnabled
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = if (stepIndex == maxSteps - 1) "Submit Answers" else "Continue",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
              )
              Spacer(modifier = Modifier.width(8.dp))
              Icon(
                imageVector = if (stepIndex == maxSteps - 1) Icons.Default.CheckCircle else Icons.Default.ArrowForward,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
              )
            }
          }
        }
      }
    }
  ) { paddingValues ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
        .padding(paddingValues)
        .padding(horizontal = 20.dp)
    ) {
      Column(
        modifier = Modifier
          .fillMaxSize()
          .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        // Step indicator bar
        LinearProgressIndicator(
          progress = progress,
          modifier = Modifier
            .fillMaxWidth()
            .height(6.dp)
            .clip(RoundedCornerShape(3.dp)),
          color = MaterialTheme.colorScheme.primary,
          trackColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
        )

        Spacer(modifier = Modifier.height(28.dp))

        when (testSequence[stepIndex]) {
          "Speaking" -> {
            StepWritingQuestion(
              title = "Speaking Task",
              infoMsg = "Call your landlord about the heater. Your heater is broken! Explain the problem to your landlord as a spoken message.",
              value = speakingText,
              onValueChange = { speakingText = it },
              placeholder = "e.g. Hello Mr. Smith, this is Liam from apartment 4B. I am calling to let you know that our central heating is not working...",
              testTag = "speaking_check_q1"
            )
          }
          "Listening" -> {
            StepWritingQuestion(
              title = "Listening Task",
              infoMsg = "Transcript: 'Attention passengers, the next train to Paddington will depart from platform 3.'\\nWhat platform does the train leave from?",
              value = listeningText,
              onValueChange = { listeningText = it },
              placeholder = "e.g. The train departs from platform...",
              testTag = "listening_check_q1"
            )
          }
          "Reading" -> {
            StepWritingQuestion(
              title = "Reading Task",
              infoMsg = "Read this message: 'Hi! Could you please send me the quarterly report by 3 PM tomorrow?'\\nWhat is the sender asking for and by when?",
              value = readingText,
              onValueChange = { readingText = it },
              placeholder = "e.g. They need the quarterly report by tomorrow afternoon...",
              testTag = "reading_check_q1"
            )
          }
          "Writing" -> {
            StepWritingQuestion(
              title = "Writing Task",
              infoMsg = "Write a short email to your boss asking for tomorrow off due to a doctor's appointment.",
              value = writingText,
              onValueChange = { writingText = it },
              placeholder = "e.g. Dear Sarah, I would like to request tomorrow off...",
              testTag = "writing_check_q1"
            )
          }
        }

        Spacer(modifier = Modifier.height(24.dp))
      }
    }
  }
}`;

const startIdx = text.indexOf('fun FluentCitySpeakingCheckPage');
const endIdx = text.indexOf('@Composable\nfun StepWritingQuestion');

if (startIdx !== -1 && endIdx !== -1) {
    const before = text.substring(0, startIdx);
    const after = text.substring(endIdx);
    const replaced = before + newAssessmentPage + '\n\n' + after;
    fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', replaced);
    console.log("Successfully replaced FluentCitySpeakingCheckPage with FluentCityAssessmentCheckPage.");
} else {
    console.log("Could not find start or end index.", startIdx, endIdx);
}
