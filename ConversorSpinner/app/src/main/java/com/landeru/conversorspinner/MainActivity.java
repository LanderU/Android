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
import android.widget.AdapterView;
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
    private int posicionOrigen;
    private int posicionDestino;

    // Función para controlar el tipo de conversión a realizar
    public void controlarAccion(String accion, Double dato){

        Intent i = new Intent(getApplicationContext(), Main2Activity.class);
        i.putExtra(accion,dato);
        startActivity(i);

    }// controlarAccion


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

        // Creación de la clase para mostrar en los spinners

        List<TipoDato> listaDatos = new ArrayList<>();
        // Añadimos al ArrayList los items
        listaDatos.add(new TipoDato("Bytes"));
        listaDatos.add(new TipoDato("KiloBytes"));
        listaDatos.add(new TipoDato("MegaBytes"));

        // Creación del adaptador para carga lenta

        LazyAdapter adaptador = new LazyAdapter(this, listaDatos);

        spinnerOrigen = (Spinner) findViewById(R.id.spinner);
        spinnerOrigen.setAdapter(adaptador);

        // Controlamos el tipo de dato de origen que hemos seleccionado
        spinnerOrigen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Nos quedamos con el número seleccionado.

                posicionOrigen = position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerDestino = (Spinner) findViewById(R.id.spinner2);
        spinnerDestino.setAdapter(adaptador);

        // Tipo de dato de destino que hemos seleccionado

        spinnerDestino.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Nos quedamos con el número seleccionado
                posicionDestino = position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        introducirDato = (EditText) findViewById(R.id.editText);

        // Acción de pulsar el botón
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {

            // Nos quedamos con lo que haya dentro de EditText


            public void onClick(View v) {

                if (introducirDato.getText().length() == 0){

                    controlarAccion("VACIO",0.0);

                }else if (posicionOrigen == 0 && posicionDestino == 0){

                    String datoRecogido = introducirDato.getText().toString();
                    Double datoDoble = new Double(datoRecogido);

                    controlarAccion("bytes-bytes", datoDoble);

                }else if (posicionOrigen == 0 && posicionDestino == 1){

                    String datoRecogido = introducirDato.getText().toString();
                    Double datoDoble = new Double(datoRecogido);

                    controlarAccion("bytes-kilobytes",datoDoble);

                }else if (posicionOrigen == 0 && posicionDestino == 2){

                    String datoRecogido = introducirDato.getText().toString();
                    Double datoDoble = new Double(datoRecogido);

                    controlarAccion("bytes-megabytes",datoDoble);

                }else if (posicionOrigen == 1 && posicionDestino == 0){

                    String datoRecogido = introducirDato.getText().toString();
                    Double datoDoble = new Double(datoRecogido);

                    controlarAccion("kilobytes-bytes",datoDoble);

                }else if(posicionOrigen == 1 && posicionDestino ==1){

                    String datoRecogido = introducirDato.getText().toString();
                    Double datoDoble = new Double(datoRecogido);

                    controlarAccion("kilobytes-kilobytes", datoDoble);

                }else if (posicionOrigen == 1 && posicionDestino == 2){

                    String datoRecogido = introducirDato.getText().toString();
                    Double datoDoble = new Double(datoRecogido);

                    controlarAccion("kilobytes-megabytes",datoDoble);

                } else if (posicionOrigen == 2 && posicionDestino == 0){

                    String datoRecogido = introducirDato.getText().toString();
                    Double datoDoble = new Double(datoRecogido);

                    controlarAccion("megabytes-bytes", datoDoble);

                } else if (posicionOrigen == 2 && posicionDestino == 1){

                    String datoRecogido = introducirDato.getText().toString();
                    Double datoDoble = new Double(datoRecogido);

                    controlarAccion("megabytes-kilobytes", datoDoble);

                }else if (posicionOrigen == 2 && posicionDestino == 2){

                    String datoRecogido = introducirDato.getText().toString();
                    Double datoDoble = new Double(datoRecogido);

                    controlarAccion("megabytes-megabytes", datoDoble);
                }

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
