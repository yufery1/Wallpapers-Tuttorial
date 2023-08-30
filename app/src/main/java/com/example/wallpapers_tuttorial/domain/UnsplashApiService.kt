package com.example.wallpapers_tuttorial.domain

import com.example.wallpapers_tuttorial.domain.model.UnsplashPhoto
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApiService {
    @GET("photos")
    suspend fun getPhotos(
        @Query("client_id") clientId:String,
        @Query("page") page:Int,
        @Query("per_page") perPage:Int,
    ):List<UnsplashPhoto>
}