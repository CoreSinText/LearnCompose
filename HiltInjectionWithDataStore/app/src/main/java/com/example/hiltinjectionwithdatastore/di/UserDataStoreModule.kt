package com.example.hiltinjectionwithdatastore.di

import android.content.Context
import com.example.hiltinjectionwithdatastore.data.dataStore.UserDataStore
import com.example.hiltinjectionwithdatastore.data.dataStore.UserDataStoreImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserDataStoreModule {

@Singleton
@Provides
fun provideUserDataStore(@ApplicationContext context: Context):UserDataStore = UserDataStoreImpl(context)
}