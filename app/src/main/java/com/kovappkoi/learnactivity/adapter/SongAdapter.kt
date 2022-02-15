package com.kovappkoi.learnactivity.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kovappkoi.learnactivity.PlayActivity
import com.kovappkoi.learnactivity.databinding.ItemSongBinding
import com.kovappkoi.learnactivity.model.Song
import com.kovappkoi.learnactivity.utils.Constants

class SongAdapter(
    private val listSong: ArrayList<Song>, private val activity: Activity
) :
    RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

//    companion object {
//        lateinit var callback: Callback
//    }

    class SongViewHolder(val binding: ItemSongBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        return SongViewHolder(ItemSongBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.binding.song = listSong[position]
        holder.binding.songContainer.setOnClickListener {

            val intent = Intent(activity, PlayActivity::class.java)
            intent.putExtra(Constants.TITLE, listSong[position].title)
            intent.putExtra(Constants.SUB, listSong[position].sub)
            intent.putExtra(Constants.URL, listSong[position].url)
            intent.putExtra(Constants.AUTHOR, listSong[position].author)
            intent.putExtra(Constants.AVT, listSong[position].avt)
            activity.startActivity(intent)
//            Toast.makeText(activity, "Đã click item số $position", Toast.LENGTH_SHORT).show()
//            callback.onClickItem(listSong[position])
        }
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return listSong.size
    }
}

interface Callback {
    fun onClickItem(song: Song)
}