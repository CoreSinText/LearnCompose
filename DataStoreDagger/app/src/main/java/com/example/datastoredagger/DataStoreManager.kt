package com.example.datastoredagger


import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataStoreManager @Inject constructor(@ApplicationContext context: Context) {
    private val dataStore = context.createDataStore("user_prefs")

    companion object {
        val NAME_KEY = stringPreferencesKey("USER_NAME")
    }

    suspend fun saveName(name: String) {
        dataStore.edit { prefs ->
            prefs[NAME_KEY] = name
        }
    }

    val nameFlow: Flow<String?> = dataStore.data
        .map { prefs -> prefs[NAME_KEY] }
}
