package com.example.hiltinjection.data.repository

import android.app.Application
import android.util.Log
import com.example.hiltinjection.R
import com.example.hiltinjection.data.remote.MyApi
import com.example.hiltinjection.domain.repository.MyRepository

class MyRepositoryImpl(
    private val api: MyApi,
    private val appContext: Application
) : MyRepository {

    init {
        val app = appContext.getText(R.string.app_name)

    }
    override suspend fun doNetworkCall() {
        Log.d("Hello", "Hi i am working")
    }
}