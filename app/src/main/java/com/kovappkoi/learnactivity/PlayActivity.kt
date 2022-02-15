package com.kovappkoi.learnactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kovappkoi.learnactivity.databinding.ActivityPlaymusicBinding
import com.kovappkoi.learnactivity.utils.Constants

class PlayActivity : AppCompatActivity() {
    private lateinit var title: String

    private lateinit var binding: ActivityPlaymusicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaymusicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = intent.getStringExtra(Constants.TITLE)!!
    }
}