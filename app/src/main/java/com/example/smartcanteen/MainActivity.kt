package com.example.smartcanteen

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNama = findViewById<TextInputEditText>(R.id.Nama)
        val edtNim = findViewById<TextInputEditText>(R.id.NIM)
        val spKelas = findViewById<Spinner>(R.id.Kelas)
        val btnMasuk = findViewById<Button>(R.id.button)


        val kelasList = listOf( "Pilih Kelas", "2AEC1", "2AEC2", "2AEC3", "2AEC4")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, kelasList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spKelas.adapter = adapter

        btnMasuk.setOnClickListener {
            val nama = edtNama.text?.toString()?.trim().orEmpty()
            val nim = edtNim.text?.toString()?.trim().orEmpty()

            if (nama.isEmpty()) {
                edtNama.error = "Nama tidak boleh kosong"
                edtNama.requestFocus()
                return@setOnClickListener
            }

            if (nim.isEmpty()) {
                edtNim.error = "NIM tidak boleh kosong"
                edtNim.requestFocus()
                return@setOnClickListener
            }

            if (spKelas.selectedItemPosition == 0) {
                Toast.makeText(this, "Silakan pilih kelas", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val kelas = spKelas.selectedItem.toString()

            val i = Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA_NAMA", nama)
                putExtra("EXTRA_NIM", nim)
                putExtra("EXTRA_KELAS", kelas)
            }
            startActivity(i)
        }
    }
}