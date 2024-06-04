package com.example.hiltinjectionwithdatastore.data.dataStore

import kotlinx.coroutines.flow.Flow

interface UserDataStore {
    suspend fun setName(key: String, name: String)
    val getName:Flow<String>

}