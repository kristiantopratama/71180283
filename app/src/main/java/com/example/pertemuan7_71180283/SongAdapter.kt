package com.example.pertemuan7_71180283

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class SongAdapter(var listSong: ArrayList<Song>, var context: Context): RecyclerView.Adapter<SongAdapter.SongHolder>() {
    class SongHolder(val view: View): RecyclerView.ViewHolder(view){
        fun bind(song: Song, context: Context){
            view.findViewById<ImageView>(R.id.Cover).setImageResource(song.Cover)
            view.findViewById<TextView>(R.id.Judul).setText("#${song.rank} ${song.Judul}")
            view.findViewById<TextView>(R.id.Penyanyi).setText(song.Penyanyi)
            view.setOnClickListener(){
                Toast.makeText(context, "${song.Penyanyi}: ${song.Judul}", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun getItemCount(): Int {
        return listSong.size

    }

    override fun onBindViewHolder(holder: SongHolder, position: Int) {
        holder.bind(listSong[position], context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongHolder {
       val a = LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
        return SongHolder(a)
    }
}