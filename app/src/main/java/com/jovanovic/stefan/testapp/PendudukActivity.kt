package com.jovanovic.stefan.testapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class PendudukActivity: AppCompatActivity()  {

    var firestore: FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penduduk)

        firestore = FirebaseFirestore.getInstance()

        val edtNama = findViewById<EditText>(R.id.edtNama)
        val edtUsia = findViewById<EditText>(R.id.edtUsia)
        val edtAlamat = findViewById<EditText>(R.id.edtAlamat)
        val btnSave = findViewById<Button>(R.id.btnSimpan)
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        val txtOutput = findViewById<TextView>(R.id.txtOuput)

        btnSave.setOnClickListener{
            val penduduk = Penduduk(edtNama.text.toString(), edtUsia.text.toString(), edtAlamat.text.toString())
            firestore?.collection("Penduduk")?.document(penduduk.Nama)?.set(penduduk)
            Toast.makeText(getApplicationContext(), "Saved",Toast.LENGTH_SHORT).show()
        }

        btnSearch.setOnClickListener{
            firestore?.collection("Penduduk")?.get()!!
                .addOnSuccessListener { docs ->
                    var output = "Data "
                    for(doc in docs){
                        output += "\n${doc.data}"
                    }
                    txtOutput.setText(output)
                }
        }

    }
}