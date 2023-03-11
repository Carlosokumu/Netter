package com.carlos.data.di

import com.carlos.data.MainRepository
import com.carlos.data.MainRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsMainRepository(
        mainRepositoryImpl: MainRepositoryImp
    ): MainRepository


}