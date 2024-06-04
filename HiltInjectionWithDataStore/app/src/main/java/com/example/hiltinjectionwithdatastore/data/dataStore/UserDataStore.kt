package com.example.hiltinjectionwithdatastore.data.dataStore

import kotlinx.coroutines.flow.Flow

interface UserDataStore {
    suspend fun setName( name: String)
    val getName:Flow<String>

}