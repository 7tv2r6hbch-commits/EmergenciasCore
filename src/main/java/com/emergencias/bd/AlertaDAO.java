package com.emergencias.bd;

import java.sql.*;

public class AlertaDAO {

    private static final String URL = "jdbc:mysql://localhost/emergencias";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void insertarAlerta(
            String tipo,
            String ubicacion,
            String nombre,
            String telefono,
            int gravedad
    ) {

        String sql = "INSERT INTO Alertas " +
                "(tipo, ubicacion, nombre, telefono, gravedad) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, tipo);
            ps.setString(2, ubicacion);
            ps.setString(3, nombre);
            ps.setString(4, telefono);
            ps.setInt(5, gravedad);

            ps.executeUpdate();

            System.out.println("Alerta insertada correctamente");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mostrarAlertas() {

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

            Statement s = con.createStatement();
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

    public static void actualizarGravedad(String nombre, int nuevaGravedad) {

        String sql = "UPDATE Alertas SET gravedad=? WHERE nombre=?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, nuevaGravedad);
            ps.setString(2, nombre);

            ps.executeUpdate();

            System.out.println("Alerta actualizada");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eliminarAlertaPorNombre(String nombre) {

        String sql = "DELETE FROM Alertas WHERE nombre=?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);

            ps.executeUpdate();

            System.out.println("Alerta eliminada");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}