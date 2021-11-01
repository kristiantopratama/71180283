package com.example.toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(Toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuName -> Toast.makeText(this, "Menu Utama", Toast.LENGTH_SHORT)
            R.id.menuSetting -> Toast.makeText(this, "Konfigurasi", Toast.LENGTH_SHORT)
        }

        return super.onOptionsItemSelected(item)
    }


}