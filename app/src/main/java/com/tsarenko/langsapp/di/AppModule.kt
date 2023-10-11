package com.tsarenko.langsapp.di

import com.tsarenko.langsapp.data.remote.LangsApi
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
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://localhost:8080")
            .build()
    }

    @Provides
    @Singleton
    fun provideLangsService(retrofit: Retrofit): LangsApi {
        return retrofit.create(LangsApi::class.java)
    }

}