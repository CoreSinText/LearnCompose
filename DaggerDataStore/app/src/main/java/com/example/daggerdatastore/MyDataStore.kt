package com.example.daggerdatastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MyDataStore @Inject constructor(private val dataStore: DataStore<Preferences>) {

    companion object{
        val STORE_NAME = stringPreferencesKey("store_name")
    }
    val getName: Flow<String> = dataStore.data.map { preferences ->
        preferences[STORE_NAME].toString()
    }

    suspend fun saveName(name:String){
        dataStore.edit {preference->
            preference[STORE_NAME] = name
        }
    }
}