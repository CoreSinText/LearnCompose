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
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ViewModelScreenSecond(private val userDataStore: UserDataStore):ViewModel() {
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
}