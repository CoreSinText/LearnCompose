package com.example.hiltinjectionwithdatastore

import androidx.lifecycle.ViewModel
import com.example.hiltinjectionwithdatastore.data.dataStore.UserDataStoreImpl
import com.example.hiltinjectionwithdatastore.data.uiState.MyUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val userDataStoreImpl: UserDataStoreImpl
) : ViewModel() {
    private val _uiState = MutableStateFlow(MyUiState())
    val uiState: StateFlow<MyUiState> = _uiState.asStateFlow()
    val storeName = userDataStoreImpl.getName


    fun changeName(name: String) {
        _uiState.update {
            it.copy(name = name)
        }
    }


    suspend fun saveName() {
        userDataStoreImpl.setName(uiState.value.name)
    }
}