package com.example.wallpapers_tuttorial.di

import com.example.wallpapers_tuttorial.SNP.BASE_URL
import com.example.wallpapers_tuttorial.data.UnsplashRepository
import com.example.wallpapers_tuttorial.domain.UnsplashApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUnsplashApiService():UnsplashApiService{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
        return retrofit.create(UnsplashApiService::class.java)
    }
    @Provides
    @Singleton
    fun provideUnsplashRepository(apiService:UnsplashApiService):UnsplashRepository{
        return UnsplashRepository(apiService)
    }
}