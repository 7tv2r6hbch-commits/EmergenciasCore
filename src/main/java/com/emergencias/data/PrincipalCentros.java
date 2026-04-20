package com.emergencias.data;

import java.util.List;
import java.util.Scanner;

public class PrincipalCentros {

    static CentroSaludRepository repo = new CentroSaludRepository();
    static Scanner sc = new Scanner(System.in);

    static void mostrarCentro(CentroSalud c) {
        System.out.println("--------------------------------");
        System.out.println("Código: " + c.codigo);
        System.out.println("Nombre: " + c.nombre);
        System.out.println("Municipio: " + c.municipio);
        System.out.println("Dirección: " + c.direccion);
        System.out.println("Teléfono: " + c.telefono);
        if (c.foto1 != null && !c.foto1.isBlank()) System.out.println("Foto1: " + c.foto1);
    }

    static void mostrarTodos() {
        List<CentroSalud> lista = repo.getAll();
        if (lista.isEmpty()) {
            System.out.println("No hay centros cargados.");
            return;
        }
        for (CentroSalud c : lista) {
            mostrarCentro(c);
        }
    }

    static void buscarPorMunicipio() {
        System.out.print("Introduce municipio: ");
        String muni = sc.nextLine();

        List<CentroSalud> encontrados = repo.searchByMunicipio(muni);
        System.out.println("Centros encontrados: " + encontrados.size());
        for (CentroSalud c : encontrados) {
            mostrarCentro(c);
        }
    }

    static void buscarPorCodigo() {
        System.out.print("Introduce código: ");
        String codigo = sc.nextLine();

        repo.getByCodigo(codigo).ifPresentOrElse(
                PrincipalCentros::mostrarCentro,
                () -> System.out.println("No existe un centro con código " + codigo)
        );
    }

    public static void main(String[] args) {
        // Cargar datos desde fichero (Unidad 8)
        repo.cargarDesdeFichero();

        int opcion;
        do {
            System.out.println("\n\t--- MENÚ CENTROS DE SALUD ---");
            System.out.println(" 1. Mostrar todos los centros");
            System.out.println(" 2. Buscar por municipio");
            System.out.println(" 3. Buscar por código");
            System.out.println(" 4. Finalizar");
            System.out.printf(" Nº de centros cargados: %d\n", repo.size());
            System.out.print("Escoge una opción: ");

            while (!sc.hasNextInt()) {
                System.out.print("Introduce un número válido: ");
                sc.nextLine();
            }
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar intro

            System.out.println("------------------------------------------");

            switch (opcion) {
                case 1 -> mostrarTodos();
                case 2 -> buscarPorMunicipio();
                case 3 -> buscarPorCodigo();
                case 4 -> System.out.println("Has salido.");
                default -> System.out.println("Opción incorrecta.");
            }

        } while (opcion != 4);
    }
}
