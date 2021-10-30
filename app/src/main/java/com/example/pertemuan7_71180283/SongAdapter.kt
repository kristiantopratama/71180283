package com.example.pertemuan7_71180283

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SongAdapter(var listSong: ArrayList<Song>): RecyclerView.Adapter<SongAdapter.SongHolder>() {
    class SongHolder(val view: View): RecyclerView.ViewHolder(view){
        fun bind(song: Song){
            view.findViewById<ImageView>(R.id.Cover).setImageResource(song.Cover)
            view.findViewById<TextView>(R.id.Judul).setText(song.Judul)
            view.findViewById<TextView>(R.id.Penyanyi).setText(song.Penyanyi)

        }
    }
}