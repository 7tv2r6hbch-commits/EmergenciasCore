package com.emergencias.detector;

import com.emergencias.model.EmergencyEvent;
import com.emergencias.model.UserData;

import java.util.Scanner;

public class EmergencyDetector {

    private final Scanner scanner = new Scanner(System.in);

    public EmergencyEvent detectEvent() {
        System.out.println("¿Emergencia? (Yes/No)");
        String input = scanner.nextLine();

        if (!input.equalsIgnoreCase("Yes")) {
            return null;
        }

        System.out.println("Introduce la ubicación:");
        String ubicacion = scanner.nextLine();

        int gravedad = validateSeverity();
        if (gravedad < 5) {
            System.out.println("Emergencia descartada (gravedad insuficiente).");
            return null;
        }

        UserData user = new UserData("ShuTing Wu", "123456789");
        return new EmergencyEvent("Emergencia General", ubicacion, user);
    }

    private int validateSeverity() {
        System.out.println("Confirmar gravedad (1-10): ");
        return Integer.parseInt(scanner.nextLine());
    }
}