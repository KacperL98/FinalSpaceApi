package com.example.finalspaceapi.di

import com.example.finalspaceapi.common.Constants
import com.example.finalspaceapi.data.remote.FinalSpaceApi
import com.example.finalspaceapi.data.repository.FinalSpaceRepositoryImpl
import com.example.finalspaceapi.domain.repsoitory.FinalSpaceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideFinalSpaceApi(): FinalSpaceApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FinalSpaceApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFinalSpaceRepository(api: FinalSpaceApi): FinalSpaceRepository {
        return FinalSpaceRepositoryImpl(api)
    }
}