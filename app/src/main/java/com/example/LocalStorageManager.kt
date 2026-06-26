package com.example

import android.content.Context
import android.content.SharedPreferences
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.moshi.Types

class LocalStorageManager(context: Context) {
    val prefs: SharedPreferences = context.getSharedPreferences("fluentcity_prefs", Context.MODE_PRIVATE)
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    inline fun <reified T> save(key: String, value: T) {
        val adapter = moshi.adapter(T::class.java)
        val json = adapter.toJson(value)
        prefs.edit().putString(key, json).apply()
    }

    inline fun <reified T> load(key: String, defaultValue: T): T {
        val json = prefs.getString(key, null) ?: return defaultValue
        val adapter = moshi.adapter(T::class.java)
        return try {
            adapter.fromJson(json) ?: defaultValue
        } catch (e: Exception) {
            defaultValue
        }
    }
    
    // For maps and lists, we need parameterized types
    fun saveCompletedDays(days: Set<Int>) {
        val adapter = moshi.adapter<Set<Int>>(Types.newParameterizedType(Set::class.java, Integer::class.java))
        prefs.edit().putString("completed_days", adapter.toJson(days)).apply()
    }

    fun loadCompletedDays(): Set<Int> {
        val json = prefs.getString("completed_days", null) ?: return emptySet()
        val adapter = moshi.adapter<Set<Int>>(Types.newParameterizedType(Set::class.java, Integer::class.java))
        return try { adapter.fromJson(json) ?: emptySet() } catch(e: Exception) { emptySet() }
    }
    
    fun saveConfidenceRatings(ratings: Map<Int, String>) {
        val adapter = moshi.adapter<Map<Int, String>>(Types.newParameterizedType(Map::class.java, Integer::class.java, String::class.java))
        prefs.edit().putString("confidence_ratings", adapter.toJson(ratings)).apply()
    }
    
    fun loadConfidenceRatings(): Map<Int, String> {
        val json = prefs.getString("confidence_ratings", null) ?: return emptyMap()
        val adapter = moshi.adapter<Map<Int, String>>(Types.newParameterizedType(Map::class.java, Integer::class.java, String::class.java))
        return try { adapter.fromJson(json) ?: emptyMap() } catch(e: Exception) { emptyMap() }
    }
    
    fun saveSessionPerformanceScores(scores: Map<Int, Int>) {
        val adapter = moshi.adapter<Map<Int, Int>>(Types.newParameterizedType(Map::class.java, Integer::class.java, Integer::class.java))
        prefs.edit().putString("session_performance_scores", adapter.toJson(scores)).apply()
    }
    
    fun loadSessionPerformanceScores(): Map<Int, Int> {
        val json = prefs.getString("session_performance_scores", null) ?: return emptyMap()
        val adapter = moshi.adapter<Map<Int, Int>>(Types.newParameterizedType(Map::class.java, Integer::class.java, Integer::class.java))
        return try { adapter.fromJson(json) ?: emptyMap() } catch(e: Exception) { emptyMap() }
    }
    
    fun saveSessionImprovements(improvements: Map<Int, ImprovementDetail>) {
        val adapter = moshi.adapter<Map<Int, ImprovementDetail>>(Types.newParameterizedType(Map::class.java, Integer::class.java, ImprovementDetail::class.java))
        prefs.edit().putString("session_improvements", adapter.toJson(improvements)).apply()
    }
    
    fun loadSessionImprovements(): Map<Int, ImprovementDetail> {
        val json = prefs.getString("session_improvements", null) ?: return emptyMap()
        val adapter = moshi.adapter<Map<Int, ImprovementDetail>>(Types.newParameterizedType(Map::class.java, Integer::class.java, ImprovementDetail::class.java))
        return try { adapter.fromJson(json) ?: emptyMap() } catch(e: Exception) { emptyMap() }
    }
    
    fun saveReviewItems(items: List<ReviewItem>) {
        val adapter = moshi.adapter<List<ReviewItem>>(Types.newParameterizedType(List::class.java, ReviewItem::class.java))
        prefs.edit().putString("review_items", adapter.toJson(items)).apply()
    }
    
    fun loadReviewItems(defaultItems: List<ReviewItem>): List<ReviewItem> {
        val json = prefs.getString("review_items", null) ?: return defaultItems
        val adapter = moshi.adapter<List<ReviewItem>>(Types.newParameterizedType(List::class.java, ReviewItem::class.java))
        return try { adapter.fromJson(json) ?: defaultItems } catch(e: Exception) { defaultItems }
    }
    
    fun saveRecordedMistakes(mistakes: List<RecordedMistake>) {
        val adapter = moshi.adapter<List<RecordedMistake>>(Types.newParameterizedType(List::class.java, RecordedMistake::class.java))
        prefs.edit().putString("recorded_mistakes", adapter.toJson(mistakes)).apply()
    }
    
    fun loadRecordedMistakes(defaultMistakes: List<RecordedMistake>): List<RecordedMistake> {
        val json = prefs.getString("recorded_mistakes", null) ?: return defaultMistakes
        val adapter = moshi.adapter<List<RecordedMistake>>(Types.newParameterizedType(List::class.java, RecordedMistake::class.java))
        return try { adapter.fromJson(json) ?: defaultMistakes } catch(e: Exception) { defaultMistakes }
    }

    fun saveReassessmentHistory(history: List<WeeklyReassessmentResult>) {
        val adapter = moshi.adapter<List<WeeklyReassessmentResult>>(Types.newParameterizedType(List::class.java, WeeklyReassessmentResult::class.java))
        prefs.edit().putString("reassessment_history", adapter.toJson(history)).apply()
    }
    
    fun loadReassessmentHistory(): List<WeeklyReassessmentResult> {
        val json = prefs.getString("reassessment_history", null) ?: return emptyList()
        val adapter = moshi.adapter<List<WeeklyReassessmentResult>>(Types.newParameterizedType(List::class.java, WeeklyReassessmentResult::class.java))
        return try { adapter.fromJson(json) ?: emptyList() } catch(e: Exception) { emptyList() }
    }
    
    fun saveCustomRegeneratedTasks(tasks: Map<Int, DayTask>) {
        val adapter = moshi.adapter<Map<Int, DayTask>>(Types.newParameterizedType(Map::class.java, Integer::class.java, DayTask::class.java))
        prefs.edit().putString("custom_regenerated_tasks", adapter.toJson(tasks)).apply()
    }
    
    fun loadCustomRegeneratedTasks(): Map<Int, DayTask> {
        val json = prefs.getString("custom_regenerated_tasks", null) ?: return emptyMap()
        val adapter = moshi.adapter<Map<Int, DayTask>>(Types.newParameterizedType(Map::class.java, Integer::class.java, DayTask::class.java))
        return try { adapter.fromJson(json) ?: emptyMap() } catch(e: Exception) { emptyMap() }
    }

    fun clearAll() {
        prefs.edit().clear().apply()
    }
}
