package com.example.wallpapers_tuttorial.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpapers_tuttorial.data.UnsplashRepository
import com.example.wallpapers_tuttorial.domain.model.UnsplashPhoto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(private val repository: UnsplashRepository):ViewModel() {
    private val _photos = MutableStateFlow<List<UnsplashPhoto>>(emptyList())
    val photos:StateFlow<List<UnsplashPhoto>> = _photos

    private var currentPage = 1
    init {
        fetchPhotos()
    }

    private fun fetchPhotos() {
        viewModelScope.launch {
            val newPhotos = repository.getPhotos(currentPage,50 )//Загружаем 20 фотографий
            _photos.emit(_photos.value + newPhotos)
            currentPage++
        }
    }
}