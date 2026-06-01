package com.emergencias.bd;

public class PruebaAlertaDAO {

    public static void main(String[] args) {

        AlertaDAO.insertarAlerta(
                "Incendio",
                "Calle Luna 8",
                "Manuel",
                "600444444",
                9
        );

        System.out.println("TABLA ALERTAS");
        AlertaDAO.mostrarAlertas();

        AlertaDAO.actualizarGravedad("Manuel", 10);

        System.out.println("TABLA DESPUÉS DE ACTUALIZAR");
        AlertaDAO.mostrarAlertas();

        AlertaDAO.eliminarAlertaPorNombre("Manuel");

        System.out.println("TABLA DESPUÉS DE ELIMINAR");
        AlertaDAO.mostrarAlertas();
    }
}