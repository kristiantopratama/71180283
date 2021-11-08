package com.example.pertemuan9_sharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var sp: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(sp?.getBoolean("Status", true) == false){
            setContentView(R.layout.activity_dashboard)
        }
        else{
            setContentView(R.layout.activity_main)
        }

        val password = "1234"

        //akses di semua activity
        sp = getSharedPreferences("myDB", MODE_PRIVATE)

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
                var status = sp?.edit()?.putBoolean("Status", true)?.commit()
                startActivity(intent)
            }
            else{
                txtContoh.text = "Password anda salah. Default password adalah 1234"
            }


            //

        }




    }
}