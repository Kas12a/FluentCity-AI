const fs = require('fs');
let text = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');

const newAssessmentPage = `enum class AssessmentStep {
  SPEAKING_1,
  LISTENING_1, LISTENING_2, LISTENING_3,
  READING_1, READING_2, READING_3,
  WRITING_1, WRITING_2, WRITING_3
}

@Composable
fun FluentCityAssessmentCheckPage(
  initialData: UserOnboardingData,
  onComplete: (UserOnboardingData) -> Unit,
  onBack: () -> Unit
) {
  val skills = initialData.skillsToImprove.lowercase()
  val testSequence = mutableListOf<AssessmentStep>()
  
  if (skills == "all" || skills.contains("speaking")) {
    testSequence.add(AssessmentStep.SPEAKING_1)
  }
  if (skills == "all" || skills.contains("listening")) {
    testSequence.add(AssessmentStep.LISTENING_1)
    testSequence.add(AssessmentStep.LISTENING_2)
    testSequence.add(AssessmentStep.LISTENING_3)
  }
  if (skills == "all" || skills.contains("reading")) {
    testSequence.add(AssessmentStep.READING_1)
    testSequence.add(AssessmentStep.READING_2)
    testSequence.add(AssessmentStep.READING_3)
  }
  if (skills == "all" || skills.contains("writing")) {
    testSequence.add(AssessmentStep.WRITING_1)
    testSequence.add(AssessmentStep.WRITING_2)
    testSequence.add(AssessmentStep.WRITING_3)
  }

  if (testSequence.isEmpty()) testSequence.add(AssessmentStep.SPEAKING_1)

  var stepIndex by remember { mutableStateOf(0) }
  
  var speakingText by remember { mutableStateOf(initialData.checkSpeaking) }
  var listening1 by remember { mutableStateOf(initialData.checkListening1) }
  var listening2 by remember { mutableStateOf(initialData.checkListening2) }
  var listening3 by remember { mutableStateOf(initialData.checkListening3) }
  var reading1 by remember { mutableStateOf(initialData.checkReading1) }
  var reading2 by remember { mutableStateOf(initialData.checkReading2) }
  var reading3 by remember { mutableStateOf(initialData.checkReading3) }
  var writing1 by remember { mutableStateOf(initialData.checkWriting1) }
  var writing2 by remember { mutableStateOf(initialData.checkWriting2) }
  var writing3 by remember { mutableStateOf(initialData.checkWriting3) }

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
          text = "Question ${"$"}{stepIndex + 1} of $maxSteps",
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
          val currentStep = testSequence[stepIndex]
          val isEnabled = when(currentStep) {
            AssessmentStep.SPEAKING_1 -> speakingText.isNotBlank()
            AssessmentStep.LISTENING_1 -> listening1.isNotBlank()
            AssessmentStep.LISTENING_2 -> listening2.isNotBlank()
            AssessmentStep.LISTENING_3 -> listening3.isNotBlank()
            AssessmentStep.READING_1 -> reading1.isNotBlank()
            AssessmentStep.READING_2 -> reading2.isNotBlank()
            AssessmentStep.READING_3 -> reading3.isNotBlank()
            AssessmentStep.WRITING_1 -> writing1.isNotBlank()
            AssessmentStep.WRITING_2 -> writing2.isNotBlank()
            AssessmentStep.WRITING_3 -> writing3.isNotBlank()
          }

          Button(
            onClick = {
              focusManager.clearFocus()
              if (stepIndex < maxSteps - 1) {
                stepIndex += 1
              } else {
                val completedData = initialData.copy(
                  checkSpeaking = speakingText,
                  checkListening1 = listening1,
                  checkListening2 = listening2,
                  checkListening3 = listening3,
                  checkReading1 = reading1,
                  checkReading2 = reading2,
                  checkReading3 = reading3,
                  checkWriting1 = writing1,
                  checkWriting2 = writing2,
                  checkWriting3 = writing3
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
          AssessmentStep.SPEAKING_1 -> {
            StepSpeakingQuestion(
              title = "Speaking Task",
              infoMsg = "Call your landlord about the heater. Your heater is broken! Explain the problem to your landlord as a spoken message.",
              value = speakingText,
              onValueChange = { speakingText = it },
              placeholder = "e.g. Hello Mr. Smith, this is Liam from apartment 4B. I am calling to let you know that our central heating is not working...",
              testTag = "speaking_check_q1"
            )
          }
          AssessmentStep.LISTENING_1 -> {
            StepWritingQuestion(
              title = "Listening Task (1/3)",
              infoMsg = "Transcript: 'Attention passengers, the next train to Paddington will depart from platform 3. Please mind the gap.'\\n\\nWhat platform does the train leave from?",
              value = listening1,
              onValueChange = { listening1 = it },
              placeholder = "e.g. The train departs from platform 3...",
              testTag = "listening_check_q1"
            )
          }
          AssessmentStep.LISTENING_2 -> {
            StepWritingQuestion(
              title = "Listening Task (2/3)",
              infoMsg = "Transcript: 'Hi, I'd like a flat white to go, please. Oh, and a chocolate croissant if you have any left.'\\n\\nWhat did the customer order?",
              value = listening2,
              onValueChange = { listening2 = it },
              placeholder = "e.g. They ordered a flat white and a croissant...",
              testTag = "listening_check_q2"
            )
          }
          AssessmentStep.LISTENING_3 -> {
            StepWritingQuestion(
              title = "Listening Task (3/3)",
              infoMsg = "Transcript: 'Welcome to the museum! The special exhibition is on the second floor, right past the gift shop.'\\n\\nWhere is the special exhibition?",
              value = listening3,
              onValueChange = { listening3 = it },
              placeholder = "e.g. On the second floor...",
              testTag = "listening_check_q3"
            )
          }
          AssessmentStep.READING_1 -> {
            StepWritingQuestion(
              title = "Reading Task (1/3)",
              infoMsg = "Read this message: 'Hi! Could you please send me the quarterly report by 3 PM tomorrow?'\\n\\nWhat is the sender asking for and by when?",
              value = reading1,
              onValueChange = { reading1 = it },
              placeholder = "e.g. They need the quarterly report by tomorrow afternoon...",
              testTag = "reading_check_q1"
            )
          }
          AssessmentStep.READING_2 -> {
            StepWritingQuestion(
              title = "Reading Task (2/3)",
              infoMsg = "Read this notice: 'The library will be closed this Friday for maintenance. Normal hours resume on Saturday.'\\n\\nWhen will the library reopen?",
              value = reading2,
              onValueChange = { reading2 = it },
              placeholder = "e.g. It reopens on Saturday...",
              testTag = "reading_check_q2"
            )
          }
          AssessmentStep.READING_3 -> {
            StepWritingQuestion(
              title = "Reading Task (3/3)",
              infoMsg = "Read this ad: 'Fresh organic apples on sale today! Buy one bag, get the second half price.'\\n\\nWhat is the special offer?",
              value = reading3,
              onValueChange = { reading3 = it },
              placeholder = "e.g. The second bag is half price...",
              testTag = "reading_check_q3"
            )
          }
          AssessmentStep.WRITING_1 -> {
            StepWritingQuestion(
              title = "Writing Task: Daily Life",
              infoMsg = "Write a short text message to a friend asking if they want to get dinner tonight.",
              value = writing1,
              onValueChange = { writing1 = it },
              placeholder = "e.g. Hey! Are you free for dinner tonight?...",
              testTag = "writing_check_q1"
            )
          }
          AssessmentStep.WRITING_2 -> {
            StepWritingQuestion(
              title = "Writing Task: Formal Email",
              infoMsg = "Write a short email to your boss asking for tomorrow off due to a doctor's appointment.",
              value = writing2,
              onValueChange = { writing2 = it },
              placeholder = "e.g. Dear Sarah, I would like to request tomorrow off...",
              testTag = "writing_check_q2"
            )
          }
          AssessmentStep.WRITING_3 -> {
            StepWritingQuestion(
              title = "Writing Task: Opinion",
              infoMsg = "Write a short paragraph about why you think learning a new language is important.",
              value = writing3,
              onValueChange = { writing3 = it },
              placeholder = "e.g. I believe learning a new language is important because...",
              testTag = "writing_check_q3"
            )
          }
        }

        Spacer(modifier = Modifier.height(24.dp))
      }
    }
  }
}`;

const startMarker = 'fun FluentCityAssessmentCheckPage';
const endMarker = '@Composable\nfun StepSpeakingQuestion';

const startIdx = text.indexOf(startMarker);
const endIdx = text.indexOf(endMarker);

if (startIdx !== -1 && endIdx !== -1) {
  // Find the exact @Composable annotation before startMarker
  const prefix = text.lastIndexOf('@Composable', startIdx);
  if (prefix !== -1) {
    const before = text.substring(0, prefix);
    const after = text.substring(endIdx);
    text = before + newAssessmentPage + '\n\n' + after;
    fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', text);
    console.log("Updated FluentCityAssessmentCheckPage");
  } else {
    console.log("Could not find @Composable before fun.");
  }
} else {
  console.log("Could not find markers.");
}
