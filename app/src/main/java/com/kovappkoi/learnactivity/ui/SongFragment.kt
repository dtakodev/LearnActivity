package com.kovappkoi.learnactivity.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kovappkoi.learnactivity.adapter.SongAdapter
import com.kovappkoi.learnactivity.databinding.SongFragmentBinding
import com.kovappkoi.learnactivity.model.Song
import com.kovappkoi.learnactivity.viewmodel.SongViewModel


class SongFragment : Fragment() {
    private lateinit var binding: SongFragmentBinding
    private lateinit var songViewModel: SongViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = SongFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //init view model
        songViewModel = ViewModelProvider(requireActivity())[SongViewModel::class.java]

        songViewModel.songs.observe(requireActivity(), Observer {
            binding.rvSong.adapter = SongAdapter(it as ArrayList<Song>)
        })
        //handle click btn upload song
        binding.playShuffle.setOnClickListener { uploadNullSong() }

        //handle search
        binding.searchBar.btnSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(text: String?): Boolean {
                songViewModel.searchSongViaTitle(text!!)
                return true
            }
        })
    }

    private fun uploadNullSong() {
        songViewModel.upSong(Song())
    }
//    @Throws(Exception::class)
//    private fun playAudio(url: String) {
//        killMediaPlayer()
//        mediaPlayer = MediaPlayer()
//        mediaPlayer.setDataSource(url)
//        mediaPlayer.prepare()
//        mediaPlayer.start()
//    }
}