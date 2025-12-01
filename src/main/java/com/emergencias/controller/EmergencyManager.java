package com.emergencias.controller;

import com.emergencias.alert.AlertSender;
import com.emergencias.detector.EmergencyDetector;
import com.emergencias.model.EmergencyEvent;

public class EmergencyManager {

    private EmergencyDetector detector = new EmergencyDetector();
    private AlertSender sender = new AlertSender();

    public void startSystem() {
        EmergencyEvent event = detector.detectEvent();

        if (event != null) {
            sender.sendAlert(event);
        } else {
            System.out.println("Sistema finalizado sin emergencias.");
        }
    }
}
