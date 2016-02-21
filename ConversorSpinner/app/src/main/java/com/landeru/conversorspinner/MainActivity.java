package com.landeru.conversorspinner;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
// Java imports
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText introducirDato;
    private Spinner spinnerOrigen;
    private Spinner spinnerDestino;
    private Button convertir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

*/
       //

        // Creación de la clase para mostrar el los spinners

        List<TipoDato> listaDatos = new ArrayList<>();
        // Añadimos al ArrayList los items
        listaDatos.add(new TipoDato("Bytes"));
        listaDatos.add(new TipoDato("KiloBytes"));
        listaDatos.add(new TipoDato("MegaBytes"));

        // Creación del adaptador para carga lenta

        LazyAdapter adaptador = new LazyAdapter(this, listaDatos);

        spinnerOrigen = (Spinner) findViewById(R.id.spinner);
        spinnerOrigen.setAdapter(adaptador);

        spinnerDestino = (Spinner) findViewById(R.id.spinner2);
        spinnerDestino.setAdapter(adaptador);



        // Acción de pulsar el botón
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });

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
