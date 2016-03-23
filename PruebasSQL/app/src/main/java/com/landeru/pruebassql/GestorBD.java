package com.landeru.pruebassql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lander on 23/3/16.
 */
public class GestorBD {

    public class DatabaseHelper extends SQLiteOpenHelper {

        private static final String LOG = "DatabaseHelper";
        // Parametrizamos las tablas
        private static final String NOMBRE_BD = "pruebassqlite";
        private static final int VERSION = 1;

        // tabla fecha
        private static final String TABLA_FECHA = "fecha";
        // Campos para la tabla fecha
        private static final String COLUMNA_FECHA_ID = "id_fecha";
        private static final String COLUMNA_FECHA_TIEMPO = "tiempo";
        // Tabla ruta
        private static final String TABLA_RUTA = "ruta";
        private static final String COLUMNA_RUTA_ID = "id_ruta";
        private static final String COLUMNA_RUTA_LONGITUD = "longitud";
        private static final String COLUMNA_RUTA_LATITUD = "latitud";
        private static final String COLUMNA_RUTA_TIEMPO = "timestap";
        // clave ajena que apunta a la tabla fecha
        private static final String COLUMNA_RUTA_ID_FECHA = "id_fecha";

        // String que genera la tabla fecha

        public static final String CREAR_TABLA_FECHA = "CREATE TABLE "+TABLA_FECHA
                +"("+COLUMNA_FECHA_ID+"INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + COLUMNA_FECHA_TIEMPO+" TEXT NOT NULL"
                + ")";

        // String que genera la tabla RUTA

        public static final String CREAR_TABLA_RUTA = "CREATE TABLE "
                + "("+ COLUMNA_RUTA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + COLUMNA_RUTA_LONGITUD+" REAL NOT NULL,"
                + COLUMNA_RUTA_LATITUD+ "REAL NOT NULL,"
                + COLUMNA_RUTA_TIEMPO+ "TEXT NOT NULL,"
                + COLUMNA_RUTA_ID_FECHA +" INTEGER NOT NULL, "
                +"FOREIGN KEY ("+COLUMNA_RUTA_ID_FECHA+") REFERENCES"+TABLA_FECHA+"("+COLUMNA_FECHA_ID+")";


        // Constructor

        public DatabaseHelper(Context context){

            super(context,NOMBRE_BD,null,VERSION);


        }// end DATABaeHelper

        @Override
        public void onCreate(SQLiteDatabase db){
            // Ejecutamos las sentencias de crear las BD
            db.execSQL(CREAR_TABLA_FECHA);
            db.execSQL(CREAR_TABLA_RUTA);
        }// end onCreate

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            // Si modificamos la versión de la BD la volvemos a crear

            db.execSQL("DROP TABLE IF EXISTS" + TABLA_FECHA);
            db.execSQL("DROP TABLE IF EXISTS" + TABLA_RUTA);

            // Llamamos al método para volver a crearlas

            onCreate(db);


        } // end onUpgrade

    }// end class

}// end class
