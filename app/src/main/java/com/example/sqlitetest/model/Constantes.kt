package com.example.sqlitetest.model

class Constantes {
    companion object{
        //constantes globales:
        const val NOM_DB="BdTest"
        const val VERSION_BD=2
        //tabla
        const val TABLE="Create table ciudad (cod int, nombre text, codedep int)"
        const val DATOS="Create table datos (cod int, nombre text, apellido text, telefono integer, direccion text, ciudad text)"
        const val GETDATA="select * from ciudad"
    }

}