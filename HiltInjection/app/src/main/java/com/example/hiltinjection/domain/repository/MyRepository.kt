package com.example.hiltinjection.domain.repository

interface MyRepository {

    suspend fun doNetworkCall()
}