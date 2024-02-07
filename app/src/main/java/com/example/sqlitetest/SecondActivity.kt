package com.example.sqlitetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sqlitetest.databinding.ActivitySecondBinding
import com.example.sqlitetest.model.ManagerDb


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val manager= ManagerDb(this)

        binding.button2.setOnClickListener(){
            val cod = binding.cod.text.toString().toInt()
            val nombre = binding.nombre.text.toString()
            val apellido = binding.apellido.text.toString()
            val telefono = binding.telefono.text.toString().toInt()
            val direccion = binding.direccion.text.toString()
            val ciudad = binding.ciudad.text.toString()
            manager.insertData2(cod, nombre, apellido, telefono, direccion, ciudad)


        }
    }
}