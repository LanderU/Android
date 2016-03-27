package com.landeru.pruebassql;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {


    private Button iniciar,mostrar;
    private Context mCtx;
    public GestorBD accesoBD = null;

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
        // Etiquetamos los botones

        Button iniciar = (Button) findViewById(R.id.button);
        iniciar.setText("Iniciar");
        Button mostrar = (Button) findViewById(R.id.button2);
        mostrar.setText("Mostrar");

        // Controlamos el botón de iniciar las inserciones a la BD
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Registrando su ruta",Toast.LENGTH_SHORT).show();

                accesoBD = new GestorBD(mCtx);
                // Abrimos la bd
                try {
                    accesoBD.abrir();

                }catch (SQLException e) {
                    e.printStackTrace();
                }


            }

        }); // end button 1


        // Controlamos el botón para pasar a la otra pantalla y ver los datos en un LazyAdapter
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


            }

        }); // end button 2
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });

    } // end onCreate

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
