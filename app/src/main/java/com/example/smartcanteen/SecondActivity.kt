package com.example.smartcanteen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Ambil data mahasiswa dari MainActivity
        val nama = intent.getStringExtra("EXTRA_NAMA").orEmpty()
        val nim = intent.getStringExtra("EXTRA_NIM").orEmpty()
        val kelas = intent.getStringExtra("EXTRA_KELAS").orEmpty()

        val tvInfoMhs = findViewById<TextView>(R.id.tvInfoMhs)
        tvInfoMhs.text = "Mahasiswa: $nama | NIM: $nim | Kelas: $kelas"

        val btnRawon = findViewById<Button>(R.id.btnPesanRawon)
        val btnGudeg = findViewById<Button>(R.id.btnPesanGudeg)
        val btnSate = findViewById<Button>(R.id.btnPesanSate)

        btnRawon.setOnClickListener { goToDetail(nama, nim, kelas, "Rawon", 17000) }
        btnGudeg.setOnClickListener { goToDetail(nama, nim, kelas, "Gudeg", 16000) }
        btnSate.setOnClickListener { goToDetail(nama, nim, kelas, "Sate Kletek", 22000) }
    }

    private fun goToDetail(nama: String, nim: String, kelas: String, menu: String, harga: Int) {
        val i = Intent(this, ThirdActivity::class.java).apply {
            putExtra("EXTRA_NAMA", nama)
            putExtra("EXTRA_NIM", nim)
            putExtra("EXTRA_KELAS", kelas)
            putExtra("EXTRA_MENU", menu)
            putExtra("EXTRA_HARGA", harga)
        }
        startActivity(i)
    }
}