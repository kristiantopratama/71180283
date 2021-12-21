package com.example.firebase_71180283

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    var firestore: FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firestore = FirebaseFirestore.getInstance()

        val edtNama = findViewById<EditText>(R.id.edtNama)
        val edtNIM = findViewById<EditText>(R.id.edtNIM)
        val edtIPK = findViewById<EditText>(R.id.edtIPK)
        val btnSave = findViewById<Button>(R.id.btnSimpan)
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        val btnSearchNIM = findViewById<Button>(R.id.btnSearchNIM)
        val btnSearchIPK = findViewById<Button>(R.id.btnSearchIPK)
        val btnDelete = findViewById<Button>(R.id.btnDelete)
        val btnList = findViewById<Button>(R.id.btnList)
        val txtOutput = findViewById<TextView>(R.id.txtOuput)

        btnSave.setOnClickListener{
            val mahasiswa = Mahasiswa(edtNama.text.toString(), edtNIM.text.toString(), edtIPK.text.toString())
            firestore?.collection("Mahasiswa")?.document(mahasiswa.Nama)?.set(mahasiswa)
            Toast.makeText(getApplicationContext(), "Saved",Toast.LENGTH_SHORT).show()
        }

        btnList.setOnClickListener{
            firestore?.collection("Mahasiswa")?.get()!!
                .addOnSuccessListener { docs ->
                    var output = "Data "
                    for(doc in docs){
                        output += "\n${doc.data}"
                    }
                    txtOutput.setText(output)
                }
        }

        btnSearch.setOnClickListener{
            firestore?.collection("Mahasiswa")?.document(edtNama.text.toString())?.get()!!
                .addOnSuccessListener { doc ->
                    txtOutput.setText(doc.data.toString())
                }
        }


        btnSearchNIM.setOnClickListener{
            firestore?.collection("Mahasiswa")?.whereEqualTo("nim", edtNIM.text.toString())?.get()!!
                .addOnSuccessListener { documents ->
                    var output = "Data "
                    for(document in documents){
                        output += "\n${document.data}"
                    }
                    txtOutput.setText(output)
                }
        }

        btnSearchIPK.setOnClickListener{
            firestore?.collection("Mahasiswa")?.whereEqualTo("ipk", edtIPK.text.toString())?.get()!!
                .addOnSuccessListener { documents ->
                    var output = "Data "
                    for(document in documents){
                        output += "\n${document.data}"
                    }
                    txtOutput.setText(output)
                }
        }

        btnDelete.setOnClickListener{
            firestore?.collection("Mahasiswa")?.document(edtNama.text.toString())?.delete()!!
                .addOnSuccessListener { Toast.makeText(getApplicationContext(), "Deleted",Toast.LENGTH_SHORT).show() }
        }

    }
}