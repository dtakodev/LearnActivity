package com.kovappkoi.learnactivity.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kovappkoi.learnactivity.databinding.AlbumFragmentBinding

class AlbumFragment : Fragment() {
    private lateinit var binding: AlbumFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = AlbumFragmentBinding.inflate(layoutInflater)
        return binding.root
    }
}