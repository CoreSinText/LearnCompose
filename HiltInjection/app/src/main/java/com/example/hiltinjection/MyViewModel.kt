package com.example.hiltinjection

import androidx.lifecycle.ViewModel
import com.example.hiltinjection.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val repository: MyRepository) : ViewModel() {
    suspend fun clickMe(){
        repository.doNetworkCall()
    }
}