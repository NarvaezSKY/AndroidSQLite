package com.example.sqlitetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.sqlitetest.databinding.ActivityListarBinding
import com.example.sqlitetest.model.Ciudad
import com.example.sqlitetest.model.ManagerDb

class Listar : AppCompatActivity() {
    private lateinit var binding: ActivityListarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityListarBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


        val manager=ManagerDb(this)
        val arrayciudad=manager.getData()

        val listCiudad=binding.listCiudad
        val arrayAdapter=ArrayAdapter<Ciudad>(this, android.R.layout.simple_list_item_1, arrayciudad)

        listCiudad.adapter=arrayAdapter
        Toast.makeText(this, "Datos listados", Toast.LENGTH_SHORT).show()
    }
}