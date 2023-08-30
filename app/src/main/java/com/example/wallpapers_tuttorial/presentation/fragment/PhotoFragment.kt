package com.example.wallpapers_tuttorial.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.fragment.app.viewModels
import com.example.wallpapers_tuttorial.R
import com.example.wallpapers_tuttorial.databinding.FragmentPhotoBinding
import com.example.wallpapers_tuttorial.presentation.adapter.PhotoAdapter
import com.example.wallpapers_tuttorial.presentation.viewModel.PhotoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PhotoFragment : Fragment() {
    private val binding by lazy {
        FragmentPhotoBinding.inflate(layoutInflater)
    }

    private val viewModel:PhotoViewModel by viewModels()
    private lateinit var adapter:PhotoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = PhotoAdapter(emptyList())
        binding.photoRecyclerView.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.photos.collect{
                photos->
                adapter.updatePhotoData(photos)
            }
        }
    }

}