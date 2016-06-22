package com.jaureguialzo.ejemplosqlite;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Referencia para el gestorbd que nos comunica con el SQLite
    private GestorBD gestorbd = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Arrancamos el gestor de BD
        gestorbd = new GestorBD(this);
        gestorbd.abrirBD();

        // Guardamos un objeto
        Persona p = new Persona("Elon","Musk");
        gestorbd.guardarPersona(p);

        // Recuperamos todos y mostramos el recuento en la consola de depuración
        List<Persona> todos = gestorbd.leerPersonas();
        Log.e("EjemploSQLite", "Recuento de personas en la BD: " + todos.size());

        gestorbd.cerrarBD();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
