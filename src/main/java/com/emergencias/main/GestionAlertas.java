package com.emergencias.main;

import java.io.*;

public class GestionAlertas {

    public static void main(String[] args) {

        String ruta = System.getProperty("user.dir");
        ruta = ruta.substring(0, ruta.lastIndexOf("\\"));
        ruta += "\\";

        File fichero = new File(ruta + "alertas.txt");

        try {
            escribirAlerta(fichero, "Emergencia en Calle Mayor 10");
            mostrarArchivoPantalla(fichero);

            int total = contarAlertas(fichero);
            System.out.println("Total de alertas: " + total);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void escribirAlerta(File fichero, String alerta)
            throws IOException {

        FileWriter fw = new FileWriter(fichero, true);
        fw.write(alerta + "\n");
        fw.close();
    }

    public static void mostrarArchivoPantalla(File fichero)
            throws IOException {

        BufferedReader entrada = new BufferedReader(new FileReader(fichero));
        String linea = entrada.readLine();

        while (linea != null) {
            System.out.println(linea);
            linea = entrada.readLine();
        }

        entrada.close();
    }

    public static int contarAlertas(File fichero)
            throws IOException {

        int contador = 0;

        BufferedReader entrada = new BufferedReader(new FileReader(fichero));
        String linea = entrada.readLine();

        while (linea != null) {
            contador++;
            linea = entrada.readLine();
        }

        entrada.close();
        return contador;
    }
}