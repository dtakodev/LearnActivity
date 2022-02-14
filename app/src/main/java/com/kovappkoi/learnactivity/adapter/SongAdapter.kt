package com.kovappkoi.learnactivity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kovappkoi.learnactivity.click.Onclickitem
import com.kovappkoi.learnactivity.databinding.ItemSongBinding
import com.kovappkoi.learnactivity.model.Song

class SongAdapter(
    private val listSong: ArrayList<Song>

) :
    RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    class SongViewHolder(val binding: ItemSongBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        return SongViewHolder(ItemSongBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.binding.song = listSong[position]
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return listSong.size
    }
}