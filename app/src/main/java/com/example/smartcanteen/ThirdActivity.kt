package com.example.smartcanteen

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val tvNama = findViewById<TextView>(R.id.tvNama)
        val tvNim = findViewById<TextView>(R.id.tvNim)
        val tvMenu = findViewById<TextView>(R.id.tvMenu)
        val tvHarga = findViewById<TextView>(R.id.tvHarga)
        val edtJumlah = findViewById<EditText>(R.id.edtJumlah)
        val btnHitung = findViewById<Button>(R.id.btnHitung)
        val tvTotal = findViewById<TextView>(R.id.tvTotal)


        val nama = intent.getStringExtra("EXTRA_NAMA").orEmpty()
        val nim = intent.getStringExtra("EXTRA_NIM").orEmpty()
        val menu = intent.getStringExtra("EXTRA_MENU").orEmpty()
        val harga = intent.getIntExtra("EXTRA_HARGA", 0)

        tvNama.text = "Nama: $nama"
        tvNim.text = "NIM: $nim"
        tvMenu.text = "Menu Dipilih: $menu"
        tvHarga.text = "Harga: Rp $harga"

        btnHitung.setOnClickListener {
            val jumlahStr = edtJumlah.text.toString().trim()
            if (jumlahStr.isEmpty()) {
                edtJumlah.error = "Jumlah tidak boleh kosong"
                edtJumlah.requestFocus()
                return@setOnClickListener
            }

            val jumlah = jumlahStr.toIntOrNull() ?: 0
            if (jumlah <= 0) {
                Toast.makeText(this, "Jumlah harus > 0", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val total = harga * jumlah
            tvTotal.text = "Total: Rp $total"
        }
    }
}