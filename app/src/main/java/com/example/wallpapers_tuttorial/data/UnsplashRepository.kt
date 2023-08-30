package com.example.wallpapers_tuttorial.data

import com.example.wallpapers_tuttorial.domain.UnsplashApiService
import com.example.wallpapers_tuttorial.domain.model.UnsplashPhoto

class UnsplashRepository(private val apiService: UnsplashApiService) {
    suspend fun getPhotos(page:Int,perPage:Int):List<UnsplashPhoto>{
        val clientId = "RsOW_EDBkmJBeB_SG0-sMVvMALOWLYND-sIXsItVGmQ"
        return apiService.getPhotos(clientId,page, perPage)
    }
}