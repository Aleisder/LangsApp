package com.tsarenko.langsapp.di

import com.tsarenko.langsapp.data.remote.LangsApi
import com.tsarenko.langsapp.data.repository.LangsRepositoryImpl
import com.tsarenko.langsapp.domain.repository.LangsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideLangsApi(retrofit: Retrofit): LangsApi {
        return retrofit.create(LangsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLangsRepository(langsApi: LangsApi): LangsRepository {
        return LangsRepositoryImpl(langsApi)
    }

}