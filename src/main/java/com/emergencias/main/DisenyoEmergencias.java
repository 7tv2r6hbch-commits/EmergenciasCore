package com.emergencias.main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.*;

public class DisenyoEmergencias extends Application {

    private TextField txtUbicacion;
    private TextField txtNombre;
    private TextField txtTelefono;
    private ComboBox<String> cbTipo;
    private Slider sliderGravedad;
    private TextArea areaResultado;

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Sistema de Emergencias");

        BorderPane pmain = new BorderPane();

        pmain.setStyle("-fx-background-color: pink;" +
                "-fx-border-width: 1px;" +
                "-fx-border-color: grey;" +
                "-fx-padding: 10px;");

        Label titulo = new Label("Sistema de Emergencias");
        titulo.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        BorderPane.setAlignment(titulo, Pos.CENTER);
        pmain.setTop(titulo);

        GridPane pFormulario = new GridPane();

        pFormulario.setStyle("-fx-background-color: white;" +
                "-fx-border-width: 1px;" +
                "-fx-border-color: grey;" +
                "-fx-padding: 10px;");

        pFormulario.setHgap(10);
        pFormulario.setVgap(10);

        Label lblTipo = new Label("Tipo:");
        cbTipo = new ComboBox<>();
        cbTipo.getItems().addAll(
                "Emergencia general",
                "Accidente vehicular",
                "Problema médico",
                "Incendio"
        );
        cbTipo.getSelectionModel().selectFirst();

        Label lblUbicacion = new Label("Ubicación:");
        txtUbicacion = new TextField();

        Label lblNombre = new Label("Nombre:");
        txtNombre = new TextField();

        Label lblTelefono = new Label("Teléfono:");
        txtTelefono = new TextField();

        Label lblGravedad = new Label("Gravedad:");
        sliderGravedad = new Slider(1, 10, 5);
        sliderGravedad.setShowTickLabels(true);
        sliderGravedad.setShowTickMarks(true);
        sliderGravedad.setMajorTickUnit(1);
        sliderGravedad.setSnapToTicks(true);

        pFormulario.add(lblTipo, 0, 0);
        pFormulario.add(cbTipo, 1, 0);

        pFormulario.add(lblUbicacion, 0, 1);
        pFormulario.add(txtUbicacion, 1, 1);

        pFormulario.add(lblNombre, 0, 2);
        pFormulario.add(txtNombre, 1, 2);

        pFormulario.add(lblTelefono, 0, 3);
        pFormulario.add(txtTelefono, 1, 3);

        pFormulario.add(lblGravedad, 0, 4);
        pFormulario.add(sliderGravedad, 1, 4);

        FlowPane pBotones = new FlowPane();

        pBotones.setStyle("-fx-background-color: aqua;" +
                "-fx-border-width: 1px;" +
                "-fx-border-color: grey;" +
                "-fx-padding: 10px;");

        pBotones.setHgap(10);
        pBotones.setVgap(10);
        pBotones.setAlignment(Pos.CENTER);

        Button btnEnviar = new Button("Enviar alerta");
        Button btnHistorial = new Button("Historial");
        Button btnGuia = new Button("Guía");
        Button btnLimpiar = new Button("Limpiar");

        pBotones.getChildren().addAll(
                btnEnviar,
                btnHistorial,
                btnGuia,
                btnLimpiar
        );

        GridPane pCentro = new GridPane();
        pCentro.setHgap(20);
        pCentro.setVgap(10);
        pCentro.setPadding(new Insets(15));

        areaResultado = new TextArea();
        areaResultado.setPrefWidth(350);
        areaResultado.setPrefHeight(250);

        pCentro.add(pFormulario, 0, 0);
        pCentro.add(areaResultado, 1, 0);
        pCentro.add(pBotones, 0, 1, 2, 1);

        pmain.setCenter(pCentro);

        btnEnviar.setOnAction(e -> enviarAlerta());
        btnHistorial.setOnAction(e -> mostrarHistorial());
        btnGuia.setOnAction(e -> mostrarGuia());
        btnLimpiar.setOnAction(e -> limpiarCampos());

        Scene scene = new Scene(pmain, 800, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void enviarAlerta() {

        String tipo = cbTipo.getValue();
        String ubicacion = txtUbicacion.getText();
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        int gravedad = (int) sliderGravedad.getValue();

        if (ubicacion.isBlank() || nombre.isBlank() || telefono.isBlank()) {
            areaResultado.setText("Error: debes completar todos los datos.");
            return;
        }

        if (gravedad < 5) {
            areaResultado.setText("Alerta no enviada. La gravedad es menor que el umbral.");
            return;
        }

        String alerta = "Tipo: " + tipo +
                " | Ubicación: " + ubicacion +
                " | Usuario: " + nombre +
                " | Teléfono: " + telefono +
                " | Gravedad: " + gravedad;

        try {
            escribirAlerta(alerta);
            areaResultado.setText("Alerta enviada a 112:\n\n" + alerta);
        } catch (IOException ex) {
            areaResultado.setText("Error al guardar la alerta: " + ex.getMessage());
        }
    }

    private void mostrarHistorial() {

        try {
            areaResultado.setText(leerArchivo());
        } catch (IOException ex) {
            areaResultado.setText("Error al leer el archivo: " + ex.getMessage());
        }
    }

    private void mostrarGuia() {

        areaResultado.setText(
                "Guía básica de primeros auxilios:\n\n" +
                        "1. Mantener la calma.\n" +
                        "2. Llamar al 112.\n" +
                        "3. No mover a la persona si hay lesión grave.\n" +
                        "4. Comprobar si respira.\n" +
                        "5. Esperar a los servicios de emergencia."
        );
    }

    private void limpiarCampos() {

        cbTipo.getSelectionModel().selectFirst();
        txtUbicacion.clear();
        txtNombre.clear();
        txtTelefono.clear();
        sliderGravedad.setValue(5);
        areaResultado.clear();
    }

    private void escribirAlerta(String alerta) throws IOException {

        FileWriter fw = new FileWriter("alertas.txt", true);
        fw.write(alerta + "\n");
        fw.close();
    }

    private String leerArchivo() throws IOException {

        File fichero = new File("alertas.txt");

        if (!fichero.exists()) {
            return "No hay alertas guardadas.";
        }

        BufferedReader entrada = new BufferedReader(new FileReader(fichero));
        String linea = entrada.readLine();
        StringBuilder contenido = new StringBuilder();

        while (linea != null) {
            contenido.append(linea).append("\n");
            linea = entrada.readLine();
        }

        entrada.close();
        return contenido.toString();
    }

    public static void main(String[] args) {
        launch();
    }
}