package com.emergencias.model;

public class UserData {

    private String nombre;
    private String telefono;

    public UserData(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre + " (" + telefono + ")";
    }
}