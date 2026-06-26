package com.example

import android.content.Context
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

object FirebaseManager {
    private const val TAG = "FirebaseManager"
    private var isInitialized = false
    private var isConfigured = false

    fun initialize(context: Context) {
        if (isInitialized) return
        
        val apiKey = BuildConfig.FIREBASE_API_KEY
        val appId = BuildConfig.FIREBASE_APPLICATION_ID
        val projectId = BuildConfig.FIREBASE_PROJECT_ID

        val hasConfig = apiKey.isNotBlank() && apiKey != "YOUR_FIREBASE_API_KEY" &&
                        appId.isNotBlank() && appId != "YOUR_FIREBASE_APPLICATION_ID" &&
                        projectId.isNotBlank() && projectId != "YOUR_FIREBASE_PROJECT_ID"

        if (!hasConfig) {
            Log.w(TAG, "Firebase configuration is not fully set. Falling back to local storage.")
            isInitialized = true
            isConfigured = false
            return
        }

        try {
            if (FirebaseApp.getApps(context).isEmpty()) {
                val options = FirebaseOptions.Builder()
                    .setApiKey(apiKey)
                    .setApplicationId(appId)
                    .setProjectId(projectId)
                    .build()
                FirebaseApp.initializeApp(context, options)
            }
            isInitialized = true
            isConfigured = true
            Log.i(TAG, "Firebase initialized successfully with options.")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to initialize Firebase", e)
            isInitialized = true
            isConfigured = false
        }
    }

    fun isFirebaseAvailable(): Boolean {
        return isInitialized && isConfigured
    }

    fun getCurrentUserId(): String? {
        if (!isFirebaseAvailable()) return null
        return try {
            FirebaseAuth.getInstance().currentUser?.uid
        } catch (e: Exception) {
            null
        }
    }

    fun ensureAnonymousAuth(onComplete: (String?) -> Unit) {
        if (!isFirebaseAvailable()) {
            onComplete(null)
            return
        }
        try {
            val auth = FirebaseAuth.getInstance()
            val currentUser = auth.currentUser
            if (currentUser != null) {
                onComplete(currentUser.uid)
            } else {
                auth.signInAnonymously()
                    .addOnSuccessListener { authResult ->
                        val uid = authResult.user?.uid
                        Log.i(TAG, "Signed in anonymously with UID: $uid")
                        onComplete(uid)
                    }
                    .addOnFailureListener { e ->
                        Log.e(TAG, "Failed anonymous auth", e)
                        onComplete(null)
                    }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Exception during Auth", e)
            onComplete(null)
        }
    }

    fun loadUserData(userId: String, onComplete: (Map<String, Any>?) -> Unit) {
        if (!isFirebaseAvailable()) {
            onComplete(null)
            return
        }
        try {
            FirebaseFirestore.getInstance().collection("users").document(userId)
                .get()
                .addOnSuccessListener { document ->
                    if (document != null && document.exists()) {
                        onComplete(document.data)
                    } else {
                        onComplete(null)
                    }
                }
                .addOnFailureListener { e ->
                    Log.e(TAG, "Failed loading Firestore user data", e)
                    onComplete(null)
                }
        } catch (e: Exception) {
            Log.e(TAG, "Exception during Firestore read", e)
            onComplete(null)
        }
    }

    fun saveUserData(userId: String, data: Map<String, Any?>, onComplete: (Boolean) -> Unit = {}) {
        if (!isFirebaseAvailable()) {
            onComplete(false)
            return
        }
        try {
            val nonNullData = data.filterValues { it != null }
            FirebaseFirestore.getInstance().collection("users").document(userId)
                .set(nonNullData)
                .addOnSuccessListener {
                    Log.i(TAG, "User data successfully saved to Firestore.")
                    onComplete(true)
                }
                .addOnFailureListener { e ->
                    Log.e(TAG, "Failed saving user data to Firestore", e)
                    onComplete(false)
                }
        } catch (e: Exception) {
            Log.e(TAG, "Exception during Firestore write", e)
            onComplete(false)
        }
    }

    fun syncSharedPreferencesToFirestore(userId: String, localStorageManager: LocalStorageManager) {
        if (!isFirebaseAvailable()) return
        
        val prefs = localStorageManager.prefs
        val allData = mapOf(
            "onboarding_data" to prefs.getString("onboarding_data", ""),
            "completed_days" to prefs.getString("completed_days", ""),
            "confidence_ratings" to prefs.getString("confidence_ratings", ""),
            "session_performance_scores" to prefs.getString("session_performance_scores", ""),
            "session_improvements" to prefs.getString("session_improvements", ""),
            "selected_practice_mode" to prefs.getString("selected_practice_mode", ""),
            "streak_count" to prefs.getString("streak_count", ""),
            "calibration_result" to prefs.getString("calibration_result", ""),
            "learning_profile" to prefs.getString("learning_profile", ""),
            "custom_regenerated_tasks" to prefs.getString("custom_regenerated_tasks", ""),
            "reassessment_history" to prefs.getString("reassessment_history", ""),
            "current_reassessment_answers" to prefs.getString("current_reassessment_answers", ""),
            "review_items" to prefs.getString("review_items", ""),
            "simulated_time_offset" to prefs.getString("simulated_time_offset", ""),
            "recorded_mistakes" to prefs.getString("recorded_mistakes", ""),
            "updatedAt" to System.currentTimeMillis()
        )
        saveUserData(userId, allData)
    }

    fun syncFirestoreToSharedPreferences(userId: String, localStorageManager: LocalStorageManager, onComplete: (Boolean) -> Unit) {
        loadUserData(userId) { data ->
            if (data != null) {
                val prefs = localStorageManager.prefs
                val edit = prefs.edit()
                data.forEach { (key, value) ->
                    if (value is String && value.isNotEmpty()) {
                        edit.putString(key, value)
                    }
                }
                edit.apply()
                onComplete(true)
            } else {
                onComplete(false)
            }
        }
    }

    // --- Structured Data Helpers ---

    fun updateUserProfile(userId: String, data: Map<String, Any?>, onComplete: (Boolean) -> Unit = {}) {
        if (!isFirebaseAvailable()) {
            onComplete(false)
            return
        }
        val nonNullData = data.filterValues { it != null }
        FirebaseFirestore.getInstance().collection("users").document(userId)
            .set(nonNullData, com.google.firebase.firestore.SetOptions.merge())
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener {
                Log.e(TAG, "Failed to update user profile", it)
                onComplete(false)
            }
    }

    fun updateSkillLevel(userId: String, skill: String, data: Map<String, Any?>, onComplete: (Boolean) -> Unit = {}) {
        if (!isFirebaseAvailable()) {
            onComplete(false)
            return
        }
        val nonNullData = data.filterValues { it != null }
        FirebaseFirestore.getInstance().collection("users").document(userId)
            .collection("skillLevels").document(skill)
            .set(nonNullData, com.google.firebase.firestore.SetOptions.merge())
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener {
                Log.e(TAG, "Failed to update skill level for $skill", it)
                onComplete(false)
            }
    }

    fun savePracticeSession(userId: String, sessionId: String, data: Map<String, Any?>, onComplete: (Boolean) -> Unit = {}) {
        if (!isFirebaseAvailable()) {
            onComplete(false)
            return
        }
        val nonNullData = data.filterValues { it != null }
        FirebaseFirestore.getInstance().collection("users").document(userId)
            .collection("practiceSessions").document(sessionId)
            .set(nonNullData, com.google.firebase.firestore.SetOptions.merge())
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener {
                Log.e(TAG, "Failed to save practice session $sessionId", it)
                onComplete(false)
            }
    }

    fun saveMistake(userId: String, mistakeId: String, data: Map<String, Any?>, onComplete: (Boolean) -> Unit = {}) {
        if (!isFirebaseAvailable()) {
            onComplete(false)
            return
        }
        val nonNullData = data.filterValues { it != null }
        FirebaseFirestore.getInstance().collection("users").document(userId)
            .collection("mistakes").document(mistakeId)
            .set(nonNullData, com.google.firebase.firestore.SetOptions.merge())
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener {
                Log.e(TAG, "Failed to save mistake $mistakeId", it)
                onComplete(false)
            }
    }

    fun saveReviewItem(userId: String, reviewItemId: String, data: Map<String, Any?>, onComplete: (Boolean) -> Unit = {}) {
        if (!isFirebaseAvailable()) {
            onComplete(false)
            return
        }
        val nonNullData = data.filterValues { it != null }
        FirebaseFirestore.getInstance().collection("users").document(userId)
            .collection("reviewItems").document(reviewItemId)
            .set(nonNullData, com.google.firebase.firestore.SetOptions.merge())
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener {
                Log.e(TAG, "Failed to save review item $reviewItemId", it)
                onComplete(false)
            }
    }

    fun saveProgressSnapshot(userId: String, date: String, data: Map<String, Any?>, onComplete: (Boolean) -> Unit = {}) {
        if (!isFirebaseAvailable()) {
            onComplete(false)
            return
        }
        val nonNullData = data.filterValues { it != null }
        FirebaseFirestore.getInstance().collection("users").document(userId)
            .collection("progressSnapshots").document(date)
            .set(nonNullData, com.google.firebase.firestore.SetOptions.merge())
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener {
                Log.e(TAG, "Failed to save progress snapshot for $date", it)
                onComplete(false)
            }
    }

    fun updateAppSettings(userId: String, data: Map<String, Any?>, onComplete: (Boolean) -> Unit = {}) {
        if (!isFirebaseAvailable()) {
            onComplete(false)
            return
        }
        val nonNullData = data.filterValues { it != null }
        FirebaseFirestore.getInstance().collection("users").document(userId)
            .collection("settings").document("app")
            .set(nonNullData, com.google.firebase.firestore.SetOptions.merge())
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener {
                Log.e(TAG, "Failed to update app settings", it)
                onComplete(false)
            }
    }

    fun linkWithEmailAndPassword(email: String, pass: String, onComplete: (Boolean, String?) -> Unit) {
        if (!isFirebaseAvailable()) {
            onComplete(false, "Firebase not available")
            return
        }
        val user = FirebaseAuth.getInstance().currentUser
        if (user == null) {
            onComplete(false, "No active anonymous user")
            return
        }
        
        val credential = com.google.firebase.auth.EmailAuthProvider.getCredential(email, pass)
        user.linkWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onComplete(true, null)
                } else {
                    onComplete(false, task.exception?.message ?: "Unknown error")
                }
            }
    }

    fun linkWithGoogle(idToken: String, onComplete: (Boolean, String?) -> Unit) {
        if (!isFirebaseAvailable()) {
            onComplete(false, "Firebase not available")
            return
        }
        val user = FirebaseAuth.getInstance().currentUser
        if (user == null) {
            onComplete(false, "No active anonymous user")
            return
        }

        val credential = com.google.firebase.auth.GoogleAuthProvider.getCredential(idToken, null)
        user.linkWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onComplete(true, null)
                } else {
                    onComplete(false, task.exception?.message ?: "Unknown error")
                }
            }
    }
}
