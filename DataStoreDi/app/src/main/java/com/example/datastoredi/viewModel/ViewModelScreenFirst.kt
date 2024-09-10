package com.example.datastoredi.viewModel

import androidx.lifecycle.ViewModel
import com.example.datastoredi.data.uiState.uiStateScreenFirst
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ViewModelScreenFirst() : ViewModel() {
    private val _uiState = MutableStateFlow(uiStateScreenFirst())
    val uiState = _uiState.asStateFlow()

    fun changeName(newName: String) {
        _uiState.update {
            uiStateScreenFirst(name = newName)
        }
    }
}