package com.emergencias.alert;

import com.emergencias.model.EmergencyEvent;

import java.io.FileWriter;

public class AlertSender {

    public void sendAlert(EmergencyEvent event) {
        if (event == null) {
            System.out.println("No hay emergencia que enviar.");
            return;
        }

        System.out.println("Enviando alerta a 112...");
        System.out.println(">>> " + event);

        try (FileWriter writer = new FileWriter("alertas.txt", true)) {
            writer.write(event.toString() + "\n");
        } catch (Exception e) {
            System.err.println("Error guardando alerta: " + e.getMessage());
        }
    }
}
