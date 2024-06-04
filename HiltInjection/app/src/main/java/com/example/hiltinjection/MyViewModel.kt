package com.example.hiltinjection

import androidx.lifecycle.ViewModel
import com.example.hiltinjection.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(repository: MyRepository) : ViewModel() {
}