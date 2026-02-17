package com.emergencias.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CentroSalud {
  @JsonProperty("Código") public String codigo;
  @JsonProperty("Nombre") public String nombre;
  @JsonProperty("Dirección") public String direccion;
  @JsonProperty("C.P.") public String cp;
  @JsonProperty("Municipio") public String municipio;
  @JsonProperty("Pedanía") public String pedania;
  @JsonProperty("Teléfono") public String telefono;
  @JsonProperty("Fax") public String fax;
  @JsonProperty("Email") public String email;
  @JsonProperty("URL Real") public String urlReal;
  @JsonProperty("URL Corta") public String urlCorta;
  @JsonProperty("Latitud") public String latitud;
  @JsonProperty("Longitud") public String longitud;
  @JsonProperty("Foto 1") public String foto1;
  @JsonProperty("Foto 2") public String foto2;
}
