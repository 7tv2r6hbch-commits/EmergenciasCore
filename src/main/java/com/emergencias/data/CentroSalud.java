package com.emergencias.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CentroSalud {

    @JsonProperty("Código")
    private String codigo;

    @JsonProperty("Nombre")
    private String nombre;

    @JsonProperty("Dirección")
    private String direccion;

    @JsonProperty("C.P.")
    private String cp;

    @JsonProperty("Municipio")
    private String municipio;

    @JsonProperty("Pedanía")
    private String pedania;

    @JsonProperty("Teléfono")
    private String telefono;

    @JsonProperty("Fax")
    private String fax;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("URL Real")
    private String urlReal;

    @JsonProperty("URL Corta")
    private String urlCorta;

    @JsonProperty("Latitud")
    private String latitud;

    @JsonProperty("Longitud")
    private String longitud;

    @JsonProperty("Foto 1")
    private String foto1;

    @JsonProperty("Foto 2")
    private String foto2;

    public CentroSalud() {
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getMunicipio() { return municipio; }
    public String getTelefono() { return telefono; }
    public String getFoto1() { return foto1; }
    public void setFoto1(String foto1) { this.foto1 = foto1; }


    @Override
    public String toString() {
        return "CentroSalud{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", municipio='" + municipio + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
