package com.kovappkoi.learnactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.kovappkoi.learnactivity.databinding.ActivityMainBinding
import com.kovappkoi.learnactivity.ui.AlbumFragment
import com.kovappkoi.learnactivity.ui.HomeFragment
import com.kovappkoi.learnactivity.ui.SongFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        transToFragment(HomeFragment() as Fragment)
        navigateApp()
    }

    private fun navigateApp() {
        binding.navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_home -> {
                    //navigate fragment
                    // TODO:
                    transToFragment(HomeFragment() as Fragment)
                    true
                }
                R.id.action_songs -> {
                    transToFragment(SongFragment() as Fragment)
                    true
                }
                R.id.action_album -> {
                    transToFragment(AlbumFragment() as Fragment)
                    true
                }
                else -> false
            }

        }
    }

    private fun transToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container_fragment, fragment)
            .commit()
    }

}