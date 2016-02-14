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

        if (extras != null){

            if (extras.containsKey("VACIO")){

                dato = extras.getDouble("VACIO");

                resultado.setText("La conversión es: " + String.format("%.2f", dato));

            } else if (extras.containsKey("kilobyte-kilobyte")){

                dato = extras.getDouble("kilobyte-kilobyte");

                resultado.setText("La conversión es: " + String.format("%.2f", dato));
            } else if (extras.containsKey("kilobyte-megabyte")){

                dato = extras.getDouble("kilobyte-megabyte");

                dato /= 1024;

                resultado.setText("La conversión es: " + String.format("%.8f", dato));
            } else if (extras.containsKey("kilobyte-gigabyte")){

                dato = extras.getDouble("kilobyte-gigabyte");

                dato /= 1048576;

                resultado.setText("La conversión es: " + String.format("%.8f", dato));

            } else if (extras.containsKey("megabyte-kilobyte")){

                dato = extras.getDouble("megabyte-kilobyte");

                dato *= 1024;

                resultado.setText("La conversión es: " + String.format("%.2f", dato));

            } else if (extras.containsKey("megabyte-megabyte")) {

                dato = extras.getDouble("megabyte-megabyte");

                resultado.setText("La conversión es: " + String.format("%.2f", dato));

            } else if (extras.containsKey("megabyte-gigabyte")){

                dato = extras.getDouble("megabyte-gigabyte");

                dato /= 1024;

                resultado.setText("La conversión es: " + String.format("%.8f", dato));

            } else if (extras.containsKey("gigabyte-kilobyte")) {

                dato = extras.getDouble("gigabyte-kilobyte");

                dato *= 1048576;

                resultado.setText("La conversión es: " + String.format("%.2f", dato));

            } else if (extras.containsKey("gigabyte-megabyte")) {

                dato = extras.getDouble("gigabyte-megabyte");

                dato *= 1024;

                resultado.setText("La conversión es: " + String.format("%.2f", dato));

            } else if (extras.containsKey("gigabyte-gigabyte")) {

                dato = extras.getDouble("gigabyte-gigabyte");

                resultado.setText("La conversión es: " + String.format("%.2f", dato));
            }




        } // end IF

    }

}
