package com.example.login_layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val password = "1234"

        val edtUsername = findViewById<EditText>(R.id.edtUsername)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegister  = findViewById<Button>(R.id.btnRegister)
        val txtContoh = findViewById<TextView>(R.id.txtContoh)


        btnLogin.setOnClickListener {

            val tempPassword = edtPassword.text.toString()
            if (tempPassword == password ){
                val intent = Intent(this, DashboardActivity::class.java)
                intent.putExtra("User", edtUsername.text.toString())
                startActivity(intent)
            }
            else{
                txtContoh.text = "Password anda salah"
            }



        }




    }
}