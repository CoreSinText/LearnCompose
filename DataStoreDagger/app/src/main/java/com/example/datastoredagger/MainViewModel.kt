package com.example.datastoredagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : ViewModel() {
    val nameFlow = dataStoreManager.nameFlow.asLiveData()

    fun saveName(name: String) {
        viewModelScope.launch {
            dataStoreManager.saveName(name)
        }
    }
}