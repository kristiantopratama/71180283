package com.example.firebase

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    var dbHelper: SQLiteOpenHelper? = null
    var db: SQLiteDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DatabaseHelper(this)
        db = dbHelper?.writableDatabase

        val edtNama = findViewById<EditText>(R.id.edtNama)
        val edtUsia = findViewById<EditText>(R.id.edtUsia)
        val btnSimpan = findViewById<Button>(R.id.btnSimpan)

        btnSimpan.setOnClickListener{
            val values = ContentValues().apply {
                put(DatabaseContract.Penduduk.COLUMN_NAME_NAMA, edtNama.text.toString())
                put(DatabaseContract.Penduduk.COLUMN_NAME_USIA, edtUsia.text.toString())
            }
            db?.insert(DatabaseContract.Penduduk.TABLE_NAME, null, values)
        }
    }
}