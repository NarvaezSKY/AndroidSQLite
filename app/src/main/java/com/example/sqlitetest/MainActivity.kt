package com.example.sqlitetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.sqlitetest.databinding.ActivityMainBinding
import com.example.sqlitetest.model.BdHelper
import com.example.sqlitetest.model.ManagerDb


class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        //DB INSTANCE
        val manager=ManagerDb(this)

        binding.button.setOnClickListener{

            val cod = binding.Cod.text.toString().toInt()
            val ciudad = binding.Ciudad.text.toString()
            val editTextValue = binding.codedep.text.toString().toInt()
            Toast.makeText(this, "Datos insertados", Toast.LENGTH_SHORT).show()
            manager.insertData(cod, ciudad, editTextValue)



        }

        binding.verData.setOnClickListener {
            val intent=Intent(this, Listar::class.java)
            startActivity(intent)
        }
        //Toast.makeText(this, cod, Toast.LENGTH_SHORT).show()
        //val db=dbHelper.writableDatabase //Abrir db en modo escritura
        //Toast.makeText(this, "BD creada UWUWUW", Toast.LENGTH_SHORT).show()
        //db.close()//cerrar uwu
    }
}