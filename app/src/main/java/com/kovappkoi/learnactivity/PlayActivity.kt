package com.kovappkoi.learnactivity

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kovappkoi.learnactivity.databinding.ActivityPlaymusicBinding
import com.kovappkoi.learnactivity.utils.Constants

class PlayActivity : AppCompatActivity() {

    companion object {
        const val TAG = "PlayActivity"
    }

    private lateinit var title: String
    private lateinit var sub: String
    private lateinit var avt: String
    private lateinit var url: String
    private lateinit var author: String
    private lateinit var mediaPlayer: MediaPlayer


    private lateinit var binding: ActivityPlaymusicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaymusicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate")
        title = intent.getStringExtra(Constants.TITLE)!!
        sub = intent.getStringExtra(Constants.SUB)!!
        avt = intent.getStringExtra(Constants.AVT)!!
        author = intent.getStringExtra(Constants.AUTHOR)!!
        url = intent.getStringExtra(Constants.URL)!!
//        getPreferences(MODE_PRIVATE).edit().putString()
        //bind data
        binding.title = title
        binding.sub = sub
        binding.author = author
        binding.avt = avt
        binding.url = url


        playAudio(url)
    }


    override fun onBackPressed() {
        super.onBackPressed()
        Log.d(TAG, "onBackpress")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
//        mediaPlayer!!.start()
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
//        mediaPlayer?.stop()
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")

    }

    private fun playAudio(url: String) {
        mediaPlayer = MediaPlayer()
        mediaPlayer.setDataSource(url)
        mediaPlayer.prepare()
        mediaPlayer.start()


    }

}