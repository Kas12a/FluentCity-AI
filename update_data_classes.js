const fs = require('fs');
let text = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');

const target = `data class UserOnboardingData(
  val city: String = "London",
  val skillsToImprove: String = "All", // Speaking, Listening, Reading, Writing, All
  val mainGoal: String = "Daily life", // Daily life, Work, Study, Job interview, Social confidence
  val practiceMinutes: Int = 20, // 10, 20, 30, 45, 60
  val checkSpeaking: String = "",
  val checkListening: String = "",
  val checkReading: String = "",
  val checkWriting: String = ""
)`;

const replacement = `data class UserOnboardingData(
  val city: String = "London",
  val skillsToImprove: String = "All", // Speaking, Listening, Reading, Writing, All
  val mainGoal: String = "Daily life", // Daily life, Work, Study, Job interview, Social confidence
  val practiceMinutes: Int = 20, // 10, 20, 30, 45, 60
  val checkSpeaking: String = "",
  val checkListening1: String = "",
  val checkListening2: String = "",
  val checkListening3: String = "",
  val checkReading1: String = "",
  val checkReading2: String = "",
  val checkReading3: String = "",
  val checkWriting1: String = "",
  val checkWriting2: String = "",
  val checkWriting3: String = ""
)`;

text = text.replace(target, replacement);

const targetResult = `data class CalibrationAnalysisResult(
  @Json(name = "estimatedLevel") val estimatedLevel: String? = null,
  @Json(name = "speakingScore") val speakingScore: Int? = null,
  @Json(name = "listeningScore") val listeningScore: Int? = null,
  @Json(name = "readingScore") val readingScore: Int? = null,
  @Json(name = "writingScore") val writingScore: Int? = null,
  @Json(name = "estimatedLevelDescription") val estimatedLevelDescription: String,`;

const replacementResult = `data class CalibrationAnalysisResult(
  @Json(name = "estimatedLevel") val estimatedLevel: String? = null,
  @Json(name = "speakingScore") val speakingScore: Int? = null,
  @Json(name = "speakingLevel") val speakingLevel: String? = null,
  @Json(name = "listeningScore") val listeningScore: Int? = null,
  @Json(name = "listeningLevel") val listeningLevel: String? = null,
  @Json(name = "readingScore") val readingScore: Int? = null,
  @Json(name = "readingLevel") val readingLevel: String? = null,
  @Json(name = "writingScore") val writingScore: Int? = null,
  @Json(name = "writingLevel") val writingLevel: String? = null,
  @Json(name = "estimatedLevelDescription") val estimatedLevelDescription: String,`;

text = text.replace(targetResult, replacementResult);

fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', text);
