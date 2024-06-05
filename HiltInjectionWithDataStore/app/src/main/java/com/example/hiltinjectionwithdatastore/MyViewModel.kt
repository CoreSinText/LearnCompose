package com.example.hiltinjectionwithdatastore

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltinjectionwithdatastore.data.dataStore.UserDataStoreImpl
import com.example.hiltinjectionwithdatastore.data.uiState.MyUiState
import com.example.hiltinjectionwithdatastore.data.uiState.UserDSUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val userDataStoreImpl: UserDataStoreImpl
) : ViewModel() {
    private val _uiState = MutableStateFlow(MyUiState())
    val uiState: StateFlow<MyUiState> = _uiState.asStateFlow()
    val nameStore: StateFlow<UserDSUiState> = userDataStoreImpl.getName().map {
        UserDSUiState(it.toString())
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000L),
        UserDSUiState()
    )


    fun changeName(name: String) {
        _uiState.update {
            it.copy(name = name)
        }
    }


    suspend fun saveName() {
        viewModelScope.launch {
            userDataStoreImpl.setName(uiState.value.name)
            Log.d("TEST", userDataStoreImpl.getName().toString())
        }
    }
}