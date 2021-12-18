package com.jovanovic.stefan.testapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
        val btnDelete = findViewById<Button>(R.id.btnDelete)
        val btnEdit = findViewById<Button>(R.id.btnEdit)
        val btnList = findViewById<Button>(R.id.btnList)
        val txtOutput = findViewById<TextView>(R.id.txtOuput)

        btnSave.setOnClickListener{
            val penduduk = Penduduk(edtNama.text.toString(), edtUsia.text.toString(), edtAlamat.text.toString())
            firestore?.collection("Penduduk")?.document(penduduk.Nama)?.set(penduduk)
            Toast.makeText(getApplicationContext(), "Saved",Toast.LENGTH_SHORT).show()
        }

        btnList.setOnClickListener{
            firestore?.collection("Penduduk")?.get()!!
                .addOnSuccessListener { docs ->
                    var output = "Data "
                    for(doc in docs){
                        output += "\n${doc.data}"
                    }
                    txtOutput.setText(output)
                }
        }

        btnSearch.setOnClickListener{
            firestore?.collection("Penduduk")?.document(edtNama.text.toString())?.get()!!
                .addOnSuccessListener { doc ->
                    txtOutput.setText(doc.data.toString())
                }
        }

        btnDelete.setOnClickListener{
            firestore?.collection("Penduduk")?.document(edtNama.text.toString())?.delete()!!
                .addOnSuccessListener { Toast.makeText(getApplicationContext(), "Deleted",Toast.LENGTH_SHORT).show() }
        }

        btnEdit.setOnClickListener{
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }

    }
}