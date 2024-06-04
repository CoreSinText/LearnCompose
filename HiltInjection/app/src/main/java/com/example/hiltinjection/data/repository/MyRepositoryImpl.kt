package com.example.hiltinjection.data.repository

import android.app.Application
import com.example.hiltinjection.data.remote.MyApi
import com.example.hiltinjection.domain.repository.MyRepository

class MyRepositoryImpl(
    private val api: MyApi,
    private val application: Application
) : MyRepository {

    override suspend fun doNetworkCall() {

    }
}