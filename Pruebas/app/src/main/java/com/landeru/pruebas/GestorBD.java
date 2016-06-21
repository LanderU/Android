package com.landeru.pruebas;

/**
 * Created by lander on 1/5/16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;



public class GestorBD {

    private SQLiteDatabase bd = null;
    private BDHelper helper = null;

    public GestorBD(Context context){

        helper = new BDHelper(context, "Pruebas.sqlite", null, 1);

    }// end Gestor

    public void abrirBD() {

        if (bd == null){

            bd = helper.getWritableDatabase();

        }//end if

    }//end abrir

    public void cerrarBD() {

        if(bd != null){

            bd.close();

        }//end if

    } //end cerrar

    public void insertaDato(){
        if(bd.isOpen()){

            String sql = "INSERT into prueba values (null, 'hola');";

            bd.execSQL(sql);

        }// end if

    }// end insertarDato

    // mostrar último insertado

    public int ultimoInsertado(){

        int lastID = Integer.MAX_VALUE;

        if(bd.isOpen()){

            Cursor cursorPrueba = bd.rawQuery("SELECT last_insert_rowid();",null);
            cursorPrueba.moveToFirst();
            lastID = cursorPrueba.getInt(0);
            cursorPrueba.close();

        } //end if

        System.out.println("Último id: "+ lastID);
        return lastID;
    }// end ultimoInsertado

    private class BDHelper extends SQLiteOpenHelper {

        private String tablaPrueba = "CREATE TABLE prueba (id INTEGER PRIMARY KEY, timestamp TEXT);";

        public BDHelper(Context context, String name, CursorFactory factory, int version){

            super(context,name,factory,version);

        }// end BDHelper

        @Override
        public void onCreate(SQLiteDatabase bd){
            bd.execSQL("PRAGMA foreig_keys=ON;");
            bd.execSQL(tablaPrueba);

        }// end onCreate

        public void onUpgrade (SQLiteDatabase bd,int oldVersion, int newVersion){

            if(!bd.isReadOnly()){
                bd.execSQL("DROP TABLE IF EXISTS prueba;");

                //Volvemos a crearla

                bd.execSQL("PRAGMA foreign_keys=ON;");
                bd.execSQL(tablaPrueba);

            }// end if

        }//end onUpgrade

    }// end BDHelper


}// end class
