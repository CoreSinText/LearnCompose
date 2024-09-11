package com.example.datastoredi

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.datastoredi.data.dataStore.UserDataStore

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "asd")

class MyApplication : Application() {
    private lateinit var userDataStore: UserDataStore
    override fun onCreate() {
        super.onCreate()
        userDataStore = UserDataStore(dataStore)
    }
}