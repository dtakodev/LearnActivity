package com.kovappkoi.learnactivity

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kovappkoi.learnactivity.databinding.ActivityPlaymusicBinding
import com.kovappkoi.learnactivity.model.Song
import com.kovappkoi.learnactivity.utils.Constants

class PlayActivity : AppCompatActivity() {

    private lateinit var title: String
    private lateinit var sub: String
    private lateinit var avt: String
    private lateinit var url: String
    private lateinit var author: String
    private var mediaPlayer: MediaPlayer? = null


    private lateinit var binding: ActivityPlaymusicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaymusicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = intent.getStringExtra(Constants.TITLE)!!
        sub = intent.getStringExtra(Constants.SUB)!!
        avt = intent.getStringExtra(Constants.AVT)!!
        author = intent.getStringExtra(Constants.AUTHOR)!!
        url = intent.getStringExtra(Constants.URL)!!

        //bind data
        binding.title = title
        binding.sub = sub
        binding.author = author
        binding.avt = avt
        binding.url = url

        if (mediaPlayer != null) {
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
            playAudio(url)
        }else{
            playAudio(url)
        }
    }
    private fun playAudio(url: String) {
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setDataSource(url)
        mediaPlayer!!.prepare()
        mediaPlayer!!.start()
    }

}