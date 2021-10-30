package com.example.pertemuan7_71180283

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listSong = arrayListOf<Song>()
        listSong.add(Song(1, "Sampai Kau Bicara", "Hijau Daun", R.mipmap.hijau_daun))
        listSong.add(Song(2, "Pujaan Hati", "Kangen Band", R.mipmap.kangen_band))

        val RcySong = findViewById<RecyclerView>(R.id.RcySong)
        RcySong.layoutManager = LinearLayoutManager(this)
        val adapter = SongAdapter(listSong, this)
        RcySong.adapter = adapter


    }
}