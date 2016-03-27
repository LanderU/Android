package com.landeru.pruebassql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.sql.SQLException;

/**
 * Created by lander on 23/3/16.
 */
public class GestorBD {

    private SQLiteDatabase bd;
    private  DatabaseHelper helper;
    private final Context context;

    public GestorBD(Context ctx){
        this.context = ctx;
        this.helper = new DatabaseHelper(this.context);

    }//constructor





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
                + ");";

        // String que genera la tabla RUTA

        public static final String CREAR_TABLA_RUTA = "CREATE TABLE "
                + "("+ COLUMNA_RUTA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + COLUMNA_RUTA_LONGITUD+" REAL NOT NULL,"
                + COLUMNA_RUTA_LATITUD+ "REAL NOT NULL,"
                + COLUMNA_RUTA_TIEMPO+ "TEXT NOT NULL,"
                + COLUMNA_RUTA_ID_FECHA +" INTEGER NOT NULL, "
                +"FOREIGN KEY ("+COLUMNA_RUTA_ID_FECHA+") REFERENCES"+TABLA_FECHA+"("+COLUMNA_FECHA_ID+");";


        // Constructor

        public DatabaseHelper(Context context){

           super(context,NOMBRE_BD,null,VERSION);


        }// end DATABaeHelper

        @Override
        public void onCreate(SQLiteDatabase db){
            // Ejecutamos las sentencias de crear las BD

            if(!db.isReadOnly()){
                // Activamos las claves ajenas
                db.execSQL("PRAGMA foreign_keys=ON;");
                db.execSQL(CREAR_TABLA_FECHA);
                db.execSQL(CREAR_TABLA_RUTA);

            }// end if

        }// end onCreate

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            // Si modificamos la versión de la BD la volvemos a crear

            if(!db.isReadOnly()){


                db.execSQL("DROP TABLE IF EXISTS" + TABLA_FECHA);
                db.execSQL("DROP TABLE IF EXISTS" + TABLA_RUTA);

                // Llamamos al método para volver a crearlas

                onCreate(db);


            }// end if


        } // end onUpgrade

        public DatabaseHelper(Context context, String nombre, CursorFactory factory, int version){

            super(context,NOMBRE_BD,factory,VERSION);
        }

    }// end class

    // métodos abrir el gestod de BD

    public GestorBD abrir() throws SQLException {

        this.bd = this.helper.getWritableDatabase();

        return this;
    } // end abrir

    // Método para cerrar

    public void cerrar(){

        this.helper.close();

    }// end cerrar





}// end class
