package com.example.login_layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val print = intent.getStringExtra("User")
        val hasil = findViewById<TextView>(R.id.txtUser)

        hasil.text = "Selamat datang $print"
    }
}