const fs = require('fs');

const code = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');
let newCode = code.replace(
  'fun FluentCityReviewScreen(\n  reviewItems: List<ReviewItem>,\n  onBack: () -> Unit\n)',
  'fun FluentCityReviewScreen(\n  reviewItems: List<ReviewItem>,\n  recordedMistakes: List<RecordedMistake> = emptyList(),\n  simulatedTimeOffsetDays: Int = 0,\n  onUpdateItem: (ReviewItem) -> Unit = {},\n  onBack: () -> Unit\n)'
);

newCode = newCode.replace(
  'fun FluentCityWeeklyReassessmentScreen(\n  onboardingData: UserOnboardingData,\n  calibrationResult: CalibrationAnalysisResult?,\n  reassessmentHistory: List<WeeklyReassessmentResult>,\n  onBack: () -> Unit\n)',
  'fun FluentCityWeeklyReassessmentScreen(\n  onboardingData: UserOnboardingData,\n  calibrationResult: CalibrationAnalysisResult?,\n  reassessmentHistory: List<WeeklyReassessmentResult>,\n  isReassessing: Boolean = false,\n  reassessmentError: String? = null,\n  onCompleteReassessment: (Map<String, String>) -> Unit = {},\n  activeReassessmentResult: WeeklyReassessmentResult? = null,\n  onDismissResult: () -> Unit = {},\n  onBack: () -> Unit\n)'
);

// We also need to fix `item.original` in FluentCityReviewScreen, as ReviewItem might not have `original` and `corrected`.
// Let's check ReviewItem properties.
fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', newCode);
console.log('Fixed signatures!');
