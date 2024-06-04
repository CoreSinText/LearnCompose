package com.example.hiltinjectionwithdatastore.data.dataStore

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("user_preferences")

class UserDataStoreImpl @Inject constructor(
    private val context: Context
) : UserDataStore {

    private companion object {
        val USER = stringPreferencesKey("user")
        const val TAG = "DATASTORE_USER"
    }

    override suspend fun setName(name: String) {
        context.dataStore.edit {
            it[USER] = name
        }
    }

    override val getName: Flow<String>
        get() = context.dataStore.data.catch {
            if (it is Exception) {
                Log.e(TAG, it.message.toString())
                emit(emptyPreferences())
            }
        }.map {
            it[USER] ?: ""
        }

}