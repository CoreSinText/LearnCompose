package com.example.hiltinjectionwithdatastore.data.dataStore

interface UserDataStore {
    suspend fun setName(key: String, name: String)
    suspend fun getName(key: String): String?

}