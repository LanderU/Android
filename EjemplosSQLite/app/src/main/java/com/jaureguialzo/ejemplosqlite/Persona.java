package com.jaureguialzo.ejemplosqlite;

/**
 * Created by widemos on 25/2/16.
 */
public class Persona {
    private String nombre;
    private String apellidos;

    public Persona() {
        this.apellidos = "Doe";
        this.nombre = "John";
    }

    public Persona(String nombre, String apellidos) {
        this.apellidos = apellidos;
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
