package com.example.hiltinjectionwithdatastore.data.dataStore

import com.example.hiltinjectionwithdatastore.data.uiState.UserDSUiState
import kotlinx.coroutines.flow.Flow

interface UserDataStore {
    suspend fun setName( name: String)
    fun getName(): Flow<UserDSUiState>

}