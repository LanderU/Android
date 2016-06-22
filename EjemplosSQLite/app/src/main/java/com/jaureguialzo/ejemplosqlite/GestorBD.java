package com.jaureguialzo.ejemplosqlite;

/**
 * Created by widemos on 25/2/16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class GestorBD {

    private SQLiteDatabase bd = null;
    private BDHelper helper = null;

    public GestorBD(Context context) {

        helper = new BDHelper(context, "Personas.sqlite", null, 1);
    }

    public void abrirBD() {
        if (bd == null)
            bd = helper.getWritableDatabase();
    }

    public void cerrarBD() {
        if (bd != null)
            bd.close();
    }

    public void guardarPersona(Persona p) {
        if (bd.isOpen() && p != null) {

            ContentValues values = new ContentValues();

            values.put("nombre", p.getNombre());
            values.put("apellidos", p.getApellidos());

            bd.insert("personas", null, values);
        }
    }

    public void borrarPersona(Persona p) {
        if (bd.isOpen() && p != null) {

            String tabla = "personas";
            String where = "nombre = ?";
            String[] argumentoswhere = new String[]{p.getNombre()};
            bd.delete(tabla, where, argumentoswhere);
        }
    }

    public Persona leerPersona(String nombre) {

        Persona p = null;

        if (bd.isOpen()) {

            String tabla = "ruta";
            String[] columnas = new String[]{"id", "nombre", "apellidos"};
            String where = "nombre = ?";
            String[] argumentoswhere = new String[]{nombre};
            String groupby = null;
            String having = null;
            String orderby = null;
            String limit = null;

            Cursor c1 = bd.query(tabla, columnas, where, argumentoswhere,
                    groupby, having, orderby, limit);

            if (c1.moveToFirst()) {
                p = new Persona();
                p.setNombre(c1.getString(1));
                p.setApellidos(c1.getString(2));
            }
        }

        return p;
    }

    public List<Persona> leerPersonas() {

        List<Persona> l = new ArrayList<>();

        if (bd.isOpen()) {

            String tabla = "personas";
            String[] columnas = new String[]{"id", "nombre", "apellidos"};
            String where = null; // "id = ?"
            String[] argumentoswhere = null; // = new String[] {"35"};
            String groupby = null;
            String having = null;
            String orderby = null;
            String limit = null;

            Cursor c1 = bd.query(tabla, columnas, where, argumentoswhere,
                    groupby, having, orderby, limit);

            if (c1.moveToFirst()) {

                // Recorremos el cursor hasta que no haya más registros
                do {
                    Persona p = new Persona(c1.getString(1), c1.getString(2));   // El campo 0 es el ID
                    l.add(p);
                } while (c1.moveToNext());
            }
        }

        return l;
    }

    private class BDHelper extends SQLiteOpenHelper {

        private String tablaPersonas = "CREATE TABLE personas ( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nombre TEXT, apellidos TEXT );";

        public BDHelper(Context context, String name, CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            if (!db.isReadOnly()) {
                // Enable foreign key constraints
                db.execSQL("PRAGMA foreign_keys=ON;");
                db.execSQL(tablaPersonas);
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            if (!db.isReadOnly()) {
                db.execSQL("DROP TABLE IF EXISTS personas");

                // Enable foreign key constraints
                db.execSQL("PRAGMA foreign_keys=ON;");
                db.execSQL(tablaPersonas);
            }

        }

    }

}