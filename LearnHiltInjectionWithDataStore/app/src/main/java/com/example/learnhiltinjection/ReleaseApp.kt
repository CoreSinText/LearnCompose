package com.example.learnhiltinjection

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

private const val USER_PREFERENCE = "user_preference"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_PREFERENCE)

class ReleaseApp() : Application() {
    lateinit var userDataStore: UserDataStore
    override fun onCreate() {
        super.onCreate()
        userDataStore = UserDataStore(dataStore)
    }
}