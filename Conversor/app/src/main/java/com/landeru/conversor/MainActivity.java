package com.landeru.conversor;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Tratado para las etiquetas

        TextView etiqueta1 = (TextView) findViewById(R.id.textView);
        TextView etiqueta2 = (TextView) findViewById(R.id.textView2);
        TextView etiqueta3 = (TextView) findViewById(R.id.textView3);

        // Les damos nombre a las etiquetas

        etiqueta1.setText("Origen");
        etiqueta2.setText(("Cantidad a convertir"));
        etiqueta3.setText("Destino");


        // Tratamiento de RadioButton Grupo1

        final RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
        final  RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);

        // Nombres a los RadioButton del primer grupo

        rb1.setText("KiloBytes");
        rb2.setText("MegaBytes");
        rb3.setText("GigaByte");


        // Dejamos uno de los RadioButton chequeados

        rb1.setChecked(true);
        rb2.setChecked(false);
        rb3.setChecked(false);


        // Tratamiento RadioButton Grupo2

        final RadioButton rbg1 = (RadioButton) findViewById(R.id.radioButton4);
        final RadioButton rbg2 = (RadioButton) findViewById(R.id.radioButton5);
        final RadioButton rbg3 = (RadioButton) findViewById(R.id.radioButton6);


        // Nombres para los RadioButton del segundo grupo

        rbg1.setText("KiloBytes");
        rbg2.setText("MegaBytes");
        rbg3.setText("GigaByte");

        // Dejamos uno de los RadioButton chequeados

        rbg1.setChecked(true);
        rbg2.setChecked(false);
        rbg3.setChecked(false);


        // EditText

        final EditText entradaDatos = (EditText) findViewById(R.id.editText);


        // Tratamiento del Button

        Button convertir = (Button) findViewById(R.id.button);

        // Darle nombre al botón

        convertir.setText("Convertir");

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(entradaDatos.getText().length() == 0){

                    // No hay dato

                    Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                    i.putExtra("VACIO", 0);
                    startActivity(i);


                }else if (rb1.isChecked() && rbg1.isChecked()){

                    //kilobyte-->kilobyte
                    String recogida = entradaDatos.getText().toString();
                    Double pasoDato = new Double(recogida);
                    Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                    i.putExtra("kilobyte-kilobyte", pasoDato);
                    startActivity(i);

                } else if (rb1.isChecked() && rbg2.isChecked()){

                    //kilobyte->MegaByte
                    String recogida = entradaDatos.getText().toString();
                    Double pasoDato = new Double(recogida);
                    Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                    i.putExtra("kilobyte-megabyte", pasoDato);
                    startActivity(i);

                } else if (rb1.isChecked() && rbg3.isChecked()){

                    //kilobyte->GigaByte
                    String recogida = entradaDatos.getText().toString();
                    Double pasoDato = new Double(recogida);
                    Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                    i.putExtra("kilobyte-gigabyte", pasoDato);
                    startActivity(i);

                } else if (rb2.isChecked() && rbg1.isChecked()){

                    //MegaByte--> KiloByte
                    String recogida = entradaDatos.getText().toString();
                    Double pasoDato = new Double(recogida);
                    Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                    i.putExtra("megabyte-kilobyte", pasoDato);
                    startActivity(i);

                } else if (rb2.isChecked() && rbg2.isChecked()){

                    //MegaByte--> MegaByte
                    String recogida = entradaDatos.getText().toString();
                    Double pasoDato = new Double(recogida);
                    Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                    i.putExtra("megabyte-megabyte", pasoDato);
                    startActivity(i);

                } else if (rb2.isChecked() && rbg3.isChecked()){

                    //MegaByte--> GigaByte
                    String recogida = entradaDatos.getText().toString();
                    Double pasoDato = new Double(recogida);
                    Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                    i.putExtra("megabyte-gigabyte", pasoDato);
                    startActivity(i);

                } else if (rb3.isChecked() && rbg1.isChecked()) {

                    //GigaBytes-->Kilobytes
                    String recogida = entradaDatos.getText().toString();
                    Double pasoDato = new Double(recogida);
                    Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                    i.putExtra("gigabyte-kilobyte", pasoDato);
                    startActivity(i);


                } else if (rb3.isChecked() && rbg2.isChecked()) {

                    //GigaByte--> MegaByte
                    String recogida = entradaDatos.getText().toString();
                    Double pasoDato = new Double(recogida);
                    Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                    i.putExtra("gigabyte-megabyte", pasoDato);
                    startActivity(i);

                } else if (rb3.isChecked() && rbg3.isChecked()){

                    //GigaByte--> GigaByte
                    String recogida = entradaDatos.getText().toString();
                    Double pasoDato = new Double(recogida);
                    Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                    i.putExtra("gigabyte-gigabyte", pasoDato);
                    startActivity(i);

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