package com.example.wallpapers_tuttorial.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.wallpapers_tuttorial.domain.model.UnsplashPhoto

class DiffCallback:DiffUtil.ItemCallback<UnsplashPhoto>() {
    override fun areItemsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto): Boolean {
        return oldItem == newItem
    }
}