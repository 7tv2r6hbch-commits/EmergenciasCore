package com.emergencias.bd;

import java.sql.*;

public class EmergenciasBD {

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/", "root", "WstOracle05123.")) {

            Statement s = con.createStatement();

            s.executeUpdate("CREATE DATABASE IF NOT EXISTS emergencias");
            s.executeUpdate("USE emergencias");

            s.executeUpdate("CREATE TABLE IF NOT EXISTS Alertas (" +
                    "id INT AUTO_INCREMENT, PRIMARY KEY(id), " +
                    "tipo VARCHAR(50), " +
                    "ubicacion VARCHAR(100), " +
                    "nombre VARCHAR(50), " +
                    "telefono VARCHAR(20), " +
                    "gravedad INT)");

            System.out.println("BD emergencias preparada");

            s.executeUpdate("INSERT INTO Alertas " +
                    "(tipo, ubicacion, nombre, telefono, gravedad) VALUES " +
                    "('Emergencia general', 'Calle Mayor 10', 'Juan', '600111111', 7), " +
                    "('Accidente vehicular', 'Avenida Sol 20', 'María', '600222222', 8), " +
                    "('Problema médico', 'Plaza Norte 3', 'Antonio', '600333333', 6)");

            ResultSet rs = s.executeQuery("SELECT * FROM Alertas");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("tipo") + " " +
                                rs.getString("ubicacion") + " " +
                                rs.getString("nombre") + " " +
                                rs.getString("telefono") + " " +
                                rs.getInt("gravedad")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}