package com.example.datastoredi

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.datastoredi.data.dataStore.UserDataStore
import dagger.hilt.android.HiltAndroidApp

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "asd")

@HiltAndroidApp
class MyApplication : Application() {
    lateinit var userDataStore: UserDataStore
    override fun onCreate() {
        super.onCreate()
        userDataStore = UserDataStore(dataStore)
    }
}