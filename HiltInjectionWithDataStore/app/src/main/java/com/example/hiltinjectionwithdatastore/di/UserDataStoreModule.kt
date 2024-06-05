package com.example.hiltinjectionwithdatastore.di

import com.example.hiltinjectionwithdatastore.data.dataStore.UserDataStore
import com.example.hiltinjectionwithdatastore.data.dataStore.UserDataStoreImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UserDataStoreModule {

@Singleton
@Binds
abstract fun bindUserDataStore(dataStoreImpl: UserDataStoreImpl): UserDataStore
}