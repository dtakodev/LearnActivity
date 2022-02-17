package com.kovappkoi.learnactivity

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.kovappkoi.learnactivity.databinding.ActivityMainBinding
import com.kovappkoi.learnactivity.ui.AlbumFragment
import com.kovappkoi.learnactivity.ui.HomeFragment
import com.kovappkoi.learnactivity.ui.SongFragment
import com.kovappkoi.learnactivity.utils.SongUtil

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                // Permission is granted. Continue the action or workflow in your
                // app.
                Log.d("MainActivity", SongUtil.getAllSongFromDevice(this)[0])

            } else {
                // Explain to the user that the feature is unavailable because the
                // features requires a permission that the user has denied. At the
                // same time, respect the user's decision. Don't link to system
                // settings in an effort to convince the user to change their
                // decision.
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED -> {
                //  requires the permission.
                requestPermissionLauncher.launch(
                    Manifest.permission.READ_EXTERNAL_STORAGE
                )
            }
            else ->{
                Log.d("MainActivity", SongUtil.getAllSongFromDevice(this)[0])
            }

        }
//        Log.d("MainActivity", SongUtil.getAllSongFromDevice(this)[0])

        transToFragment(HomeFragment() as Fragment)
        navigateApp()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if ((grantResults.isNotEmpty() &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED)
        ) {
            // Permission is granted. Continue the action or workflow
            // in your app.
            Log.d("MainActivity", SongUtil.getAllSongFromDevice(this)[0])
        } else {
            requestPermissionLauncher.launch(
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
        }
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