package com.emergencias.bd;

import java.sql.*;

public class EjercicioInstitutoConsultas {

    public static void main(String[] args) {

        ResultSet rs;

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/instituto", "root", "WstOracle05123.")) {

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM Alumnos WHERE curso LIKE ? AND media >= ?"
            );

            System.out.println("ALUMNOS DE 1A APROBADOS");

            ps.setString(1, "1A");
            ps.setDouble(2, 5);

            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("num") + " " +
                                rs.getString("nombre") + " " +
                                rs.getDouble("media") + " " +
                                rs.getString("curso")
                );
            }

            System.out.println("ALUMNOS CON MEDIA MAYOR O IGUAL A 7");

            ps.setString(1, "%");
            ps.setDouble(2, 7);

            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("num") + " " +
                                rs.getString("nombre") + " " +
                                rs.getDouble("media") + " " +
                                rs.getString("curso")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}