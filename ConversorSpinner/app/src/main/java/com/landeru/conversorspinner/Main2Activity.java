package com.landeru.conversorspinner;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import static com.landeru.conversorspinner.R.id.textView4;

public class Main2Activity extends AppCompatActivity {

    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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

        resultado = (TextView) findViewById(textView4);

        Double dato = 0.0;

        Bundle extras = getIntent().getExtras();

        if (extras != null){

            if (extras.containsKey("VACIO")){

                dato = extras.getDouble("VACIO");

                resultado.setText("La conversión es: "+ String.format("%.2f",dato));

            }else if (extras.containsKey("bytes-bytes")){

                dato = extras.getDouble("bytes-bytes");

                resultado.setText("La conversión es de: "+ String.format("%.2f", dato));

            }else if (extras.containsKey("bytes-kilobytes")){

                dato = extras.getDouble("bytes-kilobytes");

                dato /= 1024;

                resultado.setText("La conversión es de: "+ String.format("%.8f", dato));

            } else if (extras.containsKey("bytes-megabytes")){

                dato = extras.getDouble("bytes-megabytes");

                dato /= 1048576;

                resultado.setText("La conversión es de: "+ String.format("%.8f", dato));

            } else if (extras.containsKey("kilobytes-bytes")){

                dato = extras.getDouble("kilobytes-bytes");

                dato *= 1024;

                resultado.setText("El resultado es: "+ String.format("%.2f",dato));

            }else if(extras.containsKey("kilobytes-kilobytes")){

                dato = extras.getDouble("kilobytes-kilobytes");

                resultado.setText("El resultado es: "+ String.format("%.2f", dato));


            } else if (extras.containsKey("kilobytes-megabytes")){

                dato = extras.getDouble("kilobytes-megabytes");

                dato /= 1024;

                resultado.setText("El resultado es: "+ String.format("%.8f", dato));

            }else if(extras.containsKey("megabytes-bytes")){

                dato = extras.getDouble("megabytes-bytes");

                dato *= 1048576;

                resultado.setText("El resultado es: "+ String.format("%.2f", dato));

            } else if (extras.containsKey("megabytes-kilobytes")){

                dato = extras.getDouble("megabytes-kilobytes");

                dato *= 1024;

                resultado.setText("El resultado es: "+ String.format("%.2f", dato));

            } else if (extras.containsKey("megabytes-megabytes")){

                dato = extras.getDouble("megabytes-megabytes");

                resultado.setText("El resultado es: "+ String.format("%.2f", dato));

            }



        }// end if

    }

}
