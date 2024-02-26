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
    fun getData():ArrayList<Ciudad>{
        openDbRd()

        val ciudadLista= ArrayList<Ciudad>()
        val cursor=  bd.rawQuery(Constantes.GETDATA, null )

        if (cursor.moveToFirst()){
        //verifica si hay datos en la primera posicion del cursor
            do{
                val ciudadCod = cursor.getColumnIndex("cod")
                val ciudadNombre = cursor.getColumnIndex("nombre")
                val codDep = cursor.getColumnIndex("codedep")

                val cod=cursor.getInt(ciudadCod)?:""
                val nombre=cursor.getString(ciudadNombre)?:""
                val dep=cursor.getInt(codDep)?:""

                //almacenando en variables
                val ciudad = Ciudad(cod, nombre, dep)
                //valores del cursos a la clase ciudad

                ciudadLista.add(ciudad)
                //agrego ciudad al array

            }while(cursor.moveToNext())
            //ciclo hasta el cursos moviendose a la siguiente posicion
        }
    return ciudadLista
    }


}