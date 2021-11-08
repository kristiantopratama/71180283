package com.example.pertemuan9_sharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class DashboardActivity : AppCompatActivity() {
    var sp: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        sp = getSharedPreferences("myDB", MODE_PRIVATE)

//        val print = intent.getStringExtra("User")
        val hasil = findViewById<TextView>(R.id.txtUser)

        hasil.text = "Selamat datang Wahai Kisanak"
    }
}