package com.example.learnhiltinjection

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class UserDataStore(private val dataStore: DataStore<Preferences>) {
    companion object {
        val USER_NAME = stringPreferencesKey("user_name")
    }

    val getName: Flow<String> = dataStore.data.map {
        it[USER_NAME] ?: ""
    }.catch {
        if (it is IOException) Log.d("DataStore Error", it.toString())
        else throw it
    }

    suspend fun changeUserName(name: String) {
        dataStore.edit {
            it[USER_NAME] = name
        }
    }
}