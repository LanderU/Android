package com.landeru.conversorspinner;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lander on 20/2/16.
 */
public class LazyAdapter extends BaseAdapter{

    private LayoutInflater inflater = null;
    private List<TipoDato> listaDatos = null;

    public LazyAdapter(Activity activity, List<TipoDato> listaDatos){
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listaDatos = listaDatos;

    }


    @Override
    public int getCount() {

        return listaDatos.size();

    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Creación de la fila

        View vista = inflater.inflate(R.layout.estilofila, null);

        // Referencia al control

        TextView nombreDato = (TextView) vista.findViewById(R.id.textView3);

        // Rellenamos los datos

        TipoDato lista = listaDatos.get(position);

        nombreDato.setText(lista.getUnidad());

        // Devolvemos la fila
        return vista;
    }
}
