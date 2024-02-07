package com.example.sqlitetest.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

data class ManagerDb (val context: Context) {
    lateinit var bd: SQLiteDatabase

    val dbHelper=BdHelper(context) //calling connection
    //Modo escritura
    fun openDbWr(){
        bd=dbHelper.writableDatabase
    }

    //Modo lectura
    fun openDbRd(){
        bd=dbHelper.readableDatabase
    }

    fun insertData(cod: Int, nombre: String, codedep: Int): Long {
        openDbWr()
        val contenedor = ContentValues()
        contenedor.put("cod", cod)
        contenedor.put("nombre", nombre)
        contenedor.put("codedep", codedep)
        //inserting data
        return bd.insert("ciudad", null, contenedor)
    }
    fun insertData2(cod: Int, nombre: String, apellido: String, telefono: Int, direccion: String, ciudad: String): Long {
        openDbWr()
        val contenedor2 = ContentValues()
        contenedor2.put("cod", cod)
        contenedor2.put("nombre", nombre)
        contenedor2.put("apellido", apellido)
        contenedor2.put("telefono", telefono)
        contenedor2.put("direccion", direccion)
        contenedor2.put("ciudad", ciudad)
        //inserting data
        return bd.insert("datos", null, contenedor2)
    }


}