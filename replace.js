const fs = require('fs');
let text = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');

const oldInstructions = '      - Listening: "${onboardingData.checkListening}"\n      - Reading: "${onboardingData.checkReading}"\n      - Writing: "${onboardingData.checkWriting}"';

const newInstructions = '      - Listening: Q1: "${onboardingData.checkListening1}", Q2: "${onboardingData.checkListening2}", Q3: "${onboardingData.checkListening3}"\n      - Reading: Q1: "${onboardingData.checkReading1}", Q2: "${onboardingData.checkReading2}", Q3: "${onboardingData.checkReading3}"\n      - Writing: Daily life: "${onboardingData.checkWriting1}", Formal: "${onboardingData.checkWriting2}", Opinion: "${onboardingData.checkWriting3}"';

text = text.replace(oldInstructions, newInstructions);

const oldScores = `      2. 'speakingScore': Integer from 0 to 100 representing their speaking score (if provided, else null).
      3. 'listeningScore': Integer from 0 to 100 representing their listening score (if provided, else null).
      4. 'readingScore': Integer from 0 to 100 representing their reading score (if provided, else null).
      5. 'writingScore': Integer from 0 to 100 representing their writing score (if provided, else null).`;

const newScores = `      2. 'speakingScore': Integer from 0 to 100 representing their speaking score (if provided, else null).
      3. 'speakingLevel': e.g. "A1", "A2", "B1", "B2", "C1", "C2" based on CEFR standards for speaking.
      4. 'listeningScore': Integer from 0 to 100 representing their listening score (if provided, else null).
      5. 'listeningLevel': e.g. "A1", "A2", "B1", "B2", "C1", "C2" based on CEFR standards for listening.
      6. 'readingScore': Integer from 0 to 100 representing their reading score (if provided, else null).
      7. 'readingLevel': e.g. "A1", "A2", "B1", "B2", "C1", "C2" based on CEFR standards for reading.
      8. 'writingScore': Integer from 0 to 100 representing their writing score (if provided, else null).
      9. 'writingLevel': e.g. "A1", "A2", "B1", "B2", "C1", "C2" based on CEFR standards for writing.`;

text = text.replace(oldScores, newScores);

text = text.replace("      6. 'estimatedLevelDescription'", "      10. 'estimatedLevelDescription'");
text = text.replace("      7. 'weaknesses'", "      11. 'weaknesses'");
text = text.replace("      8. 'structureCohesionFeedback'", "      12. 'structureCohesionFeedback'");
text = text.replace("      9. 'practicalScenariosFeedback'", "      13. 'practicalScenariosFeedback'");
text = text.replace("      10. 'nextMilestoneFeedback'", "      14. 'nextMilestoneFeedback'");
text = text.replace("      11. 'dayPlan'", "      15. 'dayPlan'");
text = text.replace("      12. 'mainStrengths'", "      16. 'mainStrengths'");
text = text.replace("      13. 'commonMistakes'", "      17. 'commonMistakes'");
text = text.replace("      14. 'preferredPracticeStyle'", "      18. 'preferredPracticeStyle'");

fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', text);
console.log('Replaced prompt fields.');
