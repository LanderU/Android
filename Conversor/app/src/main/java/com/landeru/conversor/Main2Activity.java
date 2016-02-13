package com.landeru.conversor;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        // Tratamiento de la etiqueta


        TextView resultado = (TextView) findViewById(R.id.textView4);

        // Controlamos de donde venimos para hacer la coversión adecuada.


        Double dato = 0.0;

        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            dato = extras.getDouble("VACIO");

        }

        Bundle kiloKilo = getIntent().getExtras();

        if (kiloKilo != null) {

            dato = kiloKilo.getDouble("kkilobyte-kilobyte");
        }

        Bundle kiloMega = getIntent().getExtras();

        if(kiloMega != null){

            dato = kiloMega.getDouble("kilobyte-megabyte");
            dato /= 1024;
        }

        Bundle kiloGiga = getIntent().getExtras();

        if (kiloGiga != null){

            dato = kiloGiga.getDouble("kilobyte-gigabyte");
            dato /= 1048576;
        }

        Bundle megaKilo = getIntent().getExtras();

        if (megaKilo != null){

            dato = megaKilo.getDouble("megabyte-kilobyte");

            dato *= 1024;
        }

        Bundle megaMega = getIntent().getExtras();

        if(megaMega != null){

            dato = megaKilo.getDouble("megabyte-megabyte");

        }

        Bundle megaGiga = getIntent().getExtras();

        if(megaGiga != null){
            dato = megaGiga.getDouble("megabyte-gigabyte");

            dato /= 1024;

        }

        Bundle gigaKilo = getIntent().getExtras();

        if (gigaKilo != null){

            dato = gigaKilo.getDouble("gigabyte-kilobyte");

            dato *= 1048576;

        }

        Bundle gigaMega = getIntent().getExtras();

        if (gigaKilo != null){

            dato = gigaMega.getDouble("gigabyte-megabyte");

            dato *= 1024;

        }

        Bundle gigaGiga = getIntent().getExtras();

        if (gigaKilo != null){

            dato = gigaGiga.getDouble("gigabyte-gigabyte");

        }


        resultado.setText("La conversión es: "+ String.format("%.8f",dato));


    }

}
