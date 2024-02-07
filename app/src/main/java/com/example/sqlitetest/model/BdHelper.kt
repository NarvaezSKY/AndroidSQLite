package com.example.sqlitetest.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
//Cada vez que llame pide estos datos
class BdHelper(
    context: Context?,

) : SQLiteOpenHelper(context,
    Constantes.NOM_DB,
    null,
    Constantes.VERSION_BD) {

    override fun onCreate(db: SQLiteDatabase?) {
        //ejecutar sentencias de SQL
        db?.execSQL(Constantes.TABLE)
        db?.execSQL(Constantes.DATOS)
    }


    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS ciudad ")
        db?.execSQL("DROP TABLE IF EXISTS datos ")
        onCreate(db)
    }

}