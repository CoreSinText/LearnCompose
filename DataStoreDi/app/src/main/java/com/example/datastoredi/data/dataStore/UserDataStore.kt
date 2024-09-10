package com.example.datastoredi.data.dataStore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserDataStore(private val dataStore: DataStore<Preferences>) {
    private companion object {
        val USER_NAME = stringPreferencesKey("")
    }

    val currentUserName: Flow<String> =
        dataStore.data.map { preferences -> preferences[USER_NAME].toString() }

    suspend fun saveUserName(newName: String) {
        dataStore.edit { preferences -> preferences[USER_NAME] = newName }
    }
}