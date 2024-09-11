package com.example.datastoredi.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.datastoredi.MyApplication
import com.example.datastoredi.data.dataStore.UserDataStore
import com.example.datastoredi.data.uiState.UiStateUserDataStore
import com.example.datastoredi.data.uiState.uiStateScreenFirst
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ViewModelScreenFirst(private val userDataStore: UserDataStore) : ViewModel() {
    private val _uiState = MutableStateFlow(uiStateScreenFirst())
    val uiState = _uiState.asStateFlow()

    val uiStateUserDataStore: StateFlow<UiStateUserDataStore> =
        userDataStore.currentUserName.map { userName ->
            UiStateUserDataStore(userName)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = UiStateUserDataStore("Unknown")
        )

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MyApplication)
                ViewModelScreenFirst(application.userDataStore)
            }
        }
    }
    fun changeName(newName: String) {
        _uiState.update { it.copy(name = newName) }
    }

    fun saveName() {
        viewModelScope.launch {
            userDataStore.saveUserName(_uiState.value.name)
        }
    }
}