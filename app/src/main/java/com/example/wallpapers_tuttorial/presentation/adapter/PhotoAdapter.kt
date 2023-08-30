package com.example.wallpapers_tuttorial.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wallpapers_tuttorial.databinding.ItemPhotoBinding
import com.example.wallpapers_tuttorial.domain.model.UnsplashPhoto
import com.squareup.picasso.Picasso

class PhotoAdapter(private var photos:List<UnsplashPhoto>):RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

   inner class ViewHolder (val binding:ItemPhotoBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAdapter.ViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoAdapter.ViewHolder, position: Int) {
        val photo = photos[position]
        Picasso.get().load(photo.urls.regular).into(holder.binding.photoImageView)
    }
    fun updatePhotoData(newPhotos:List<UnsplashPhoto>){
        photos = newPhotos
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return photos.size
    }
}