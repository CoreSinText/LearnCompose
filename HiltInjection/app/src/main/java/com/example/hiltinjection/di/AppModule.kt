package com.example.hiltinjection.di

import android.app.Application
import com.example.hiltinjection.data.remote.MyApi
import com.example.hiltinjection.data.repository.MyRepositoryImpl
import com.example.hiltinjection.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMyApi(): MyApi {
        return Retrofit.Builder().baseUrl("https://api.restful-api.dev/").build().create(MyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMyRepository(myApi: MyApi, app: Application): MyRepository {
        return MyRepositoryImpl(myApi, app)
    }
}