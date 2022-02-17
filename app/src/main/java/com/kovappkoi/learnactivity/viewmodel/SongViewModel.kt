package com.kovappkoi.learnactivity.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.kovappkoi.learnactivity.model.Song
import com.kovappkoi.learnactivity.utils.Constants

class SongViewModel(application: Application) : AndroidViewModel(application) {
    val songs = MutableLiveData<List<Song>>()

    init {
        Firebase.firestore.collection(Constants.LIST_SONG).limit(10)
            .addSnapshotListener { value, _ ->
                if (value != null) {
                    songs.value = value.toObjects(Song::class.java)
                }
            }

    }

    fun searchSongViaTitle(textSearch: String) {
        Firebase.firestore.collection(Constants.LIST_SONG)
            .whereEqualTo(Constants.TITLE, textSearch).limit(50).get()
            .addOnSuccessListener {
                songs.value = it.toObjects(Song::class.java)
            }.addOnFailureListener {
                Toast.makeText(getApplication(), it.message, Toast.LENGTH_SHORT).show()
            }
    }

    fun upSong(song: Song) {
        Firebase.firestore.collection(Constants.LIST_SONG)
            .document().set(song)
            .addOnSuccessListener {
                Toast.makeText(getApplication(), "Upload done!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(getApplication(), it.message, Toast.LENGTH_SHORT).show()
            }
    }
}