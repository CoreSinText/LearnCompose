package com.example.hiltinjectionwithdatastore.data.dataStore

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.hiltinjectionwithdatastore.data.uiState.UserDSUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserDataStoreImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : UserDataStore {

    private companion object {
        val USER = stringPreferencesKey("user")
        const val TAG = "DATASTORE_USER"
    }

    override suspend fun setName(name: String) {
        dataStore.edit {
            it[USER] = name
        }
    }

    override fun getName(): Flow<UserDSUiState> {
        return dataStore.data.catch {
            if (it is Exception) {
                Log.e(TAG, it.toString())
                emit(emptyPreferences())
            }
            }.map {
            val name = it[USER] ?: ""
            UserDSUiState(name)
            }
        }


}