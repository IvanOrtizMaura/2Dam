package org.example;

import java.sql.*;


public class Main {

    public static void main(String[] args) {
        // objeto Connection con el que estableceremos la conexión a BBDD
        Connection conexion;

        try {
            conexion = DriverManager.getConnection ("jdbc:mysql://localhost:3306/demo","root", "1v4nG00n3r45");
            //modificar(conexion,10,"Ivan");
            //modificarPreparada(20, "Carlos", conexion);
            modificarTransacciones(conexion, 30, "Santi");

            if (conexion != null) {
                System.out.println("Conectado");

                // Creación de sentencia SQL mediante la clase Statement
                Statement sentencia = conexion.createStatement();

                // Sentencias de consulta que guardaremos en un objeto ResultSet perteneciente a la libreria java.sql

                ResultSet rs = sentencia.executeQuery("SELECT * FROM DEMO.DEPT");

                while(rs.next()){
                    System.out.println(("El numero del departamento " + rs.getString("DEPTNO") + " y el nombre es " + rs.getString("DNAME")));
                }
                rs.close();
                sentencia.close();
            }

            conexion.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void modificarTransacciones(Connection conexion, int num, String nombre) {
        try{
            String query = "UPDATE  demo.dept SET DNAME = ? WHERE DEPTNO = ? ;";
            conexion.setAutoCommit(false);
            Statement statement = conexion.createStatement();
            statement.executeUpdate(query);
            conexion.commit();
        } catch (SQLException e){
            System.err.println("Error: al hacer insert ");
            try {
                if (conexion!=null){
                    conexion.rollback();
                }
            }catch (SQLException se2){
                se2.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    private static void modificarPreparada(int numero, String nombre, Connection conexion) {
        try{
            String query;
            PreparedStatement pst = conexion.prepareStatement(query);
            pst.setString(1,nombre);
            pst.setInt(2,numero);
            pst.executeUpdate();
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                System.out.println( "El nombre del departamento es " + rs.getString("DNAME"));
            }
            rs.close();
            pst.close();
        }catch (Exception e ){
            System.err.println("Error");
        }
    }

    private static void modificar(Connection conexion, int numero, String nombre) throws SQLException {
        if(conexion!=null){
            System.out.println("Conectado");
            Statement setencia = conexion.createStatement();
            setencia.executeUpdate("UPDATE  demo.dept SET DNAME = '" + nombre + "'WHERE DEPTNO = '" + numero  + "';");
            ResultSet rs = setencia.executeQuery("SELECT * FROM demo.dept");

            while (rs.next()){
                System.out.println("El nombre es " + rs.getString("DNAME"));
            }
            rs.close();
            setencia.close();

        }
    }

}