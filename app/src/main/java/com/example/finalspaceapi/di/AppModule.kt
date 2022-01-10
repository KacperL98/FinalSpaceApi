package com.example.finalspaceapi.di

import com.example.finalspaceapi.common.Constants
import com.example.finalspaceapi.data.remote.FinalSpaceApi
import com.example.finalspaceapi.data.repository.FinalSpaceRepositoryImpl
import com.example.finalspaceapi.domain.repsoitory.FinalSpaceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideFinalSpaceApi(): FinalSpaceApi {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
        client.addInterceptor(loggingInterceptor)
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