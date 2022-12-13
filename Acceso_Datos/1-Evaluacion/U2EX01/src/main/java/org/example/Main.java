package org.example;

import java.sql.*;


public class Main {

    public static void main(String[] args) {
        // objeto Connection con el que estableceremos la conexión a BBDD
        Connection conexion;
        try {
            conexion = DriverManager.getConnection ("jdbc:mysql://localhost:3306/demo","root", "1v4nG00n3r45");


            if (conexion != null) {
                System.out.println("Conectado");
            }

            conexion.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}