package com.emergencias.model;

public class EmergencyEvent {

    private String tipoEmergencia;
    private String ubicacion;
    private UserData usuario;

    public EmergencyEvent(String tipoEmergencia, String ubicacion, UserData usuario) {
        this.tipoEmergencia = tipoEmergencia;
        this.ubicacion = ubicacion;
        this.usuario = usuario;
    }

    public String getTipoEmergencia() { return tipoEmergencia; }
    public String getUbicacion() { return ubicacion; }
    public UserData getUsuario() { return usuario; }

    @Override
    public String toString() {
        return "Tipo: " + tipoEmergencia + ", Ubicación: " + ubicacion +
                ", Usuario: " + (usuario != null ? usuario.toString() : "N/A");
    }
}
