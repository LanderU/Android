package com.landeru.pruebassql;

/**
 * Created by lander on 27/3/16.
 */
public class Coordenada {

    private float longitud;
    private float latitud;
    private String tiempo;

    public float getLongitud() {
        return longitud;
    }

    public float getLatitud() {
        return latitud;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
}// end class
