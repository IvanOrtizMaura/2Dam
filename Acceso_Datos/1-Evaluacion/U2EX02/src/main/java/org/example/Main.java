package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection conexion = null;


        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/discografia","root", "1v4nG00n3r45");
            if (conexion != null) {
                System.out.println("Conectado");
            }

//            añadirTable(conexion);
//            consultaStatementAlbum(conexion);
//            consultaStatementCancion(conexion);
            //insertAlbum(conexion);
            insertCancion(conexion);
            conexion.close();
        }catch (Exception e){
            System.err.println("Error: Error al conectar con la base de datos");
        }

    }

    private static void insertCancion(Connection conexion) {
        try{
            conexion.setAutoCommit(false);
            Statement sentencia = conexion.createStatement();
            // Sentencias de consulta que guardaremos en un objeto ResultSet perteneciente a la libreria java.sql
            String sql = "INSERT INTO cancion VALUES(103, 'Sumit', 'Mittal', 1)";
            sentencia.executeUpdate(sql);
            conexion.commit();
        } catch (SQLException e) {

            System.err.println("Error: Error al crear la sentencia");
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                System.err.println("ERROR mp se ciamtp");
                System.exit(-1);
            }
            throw new RuntimeException(e);
        }
    }

    private static void insertAlbum(Connection conexion) {
        try{
             Statement sentencia = conexion.createStatement();
             sentencia.executeUpdate("INSERT INTO `discografia`.`album` (`id`, `titulo`, `ano_publicacion`) " +
                     "VALUES ('4', 'Naranja', '2020');");
            conexion.commit();
        } catch (SQLException e) {

            System.err.println("Error: Error al crear la sentencia");
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                System.err.println("ERROR mp se ciamtp");
                System.exit(-1);
            }
            throw new RuntimeException(e);
        }
    }

    private static void consultaStatementCancion(Connection conexion) throws SQLException {
        System.out.println("CANCIONES");
        Statement sentencia = conexion.createStatement();
        ResultSet rsCancion = sentencia.executeQuery("SELECT * FROM discografia.cancion;");
        while (rsCancion.next()){
            System.out.println("El titulo del cancion es: "+rsCancion.getString("titulo" ) +"\n" +
                    "El año de publicacion es: "+ rsCancion.getString("letra")
            );
            System.out.println("*********************************************\n");
        }
    }

    private static void consultaStatementAlbum(Connection conexion) {
    try{
        conexion.setAutoCommit(false);
        System.out.println("ALBUMES");
        Statement sentencia = conexion.createStatement();
        ResultSet rs = sentencia.executeQuery("SELECT * FROM discografia.album inner join discografia.cancion " +
                "on album.id = cancion.id_album;");

        while(rs.next()){
            System.out.println("El titulo del album es: "+rs.getString("titulo" ) +"\n" +
                    "El año de publicacion es: "+ rs.getString("ano_publicacion"));
            System.out.println("*********************************************\n");
        }
    conexion.commit();

    } catch (SQLException e) {
        try {
            conexion.rollback();
        } catch (SQLException ex) {
            System.err.println("ERROR mp se ciamtp");
            System.exit(-1);
        }
    }
    }

    private static void añadirTable(Connection conexion) {
        String tabla = "album";
        String columna = "imagen";


        try{

            Statement sentencia = conexion.createStatement();

            sentencia.executeUpdate("ALTER TABLE album ADD imagen Blob;");
            sentencia.close();

        } catch (SQLException e) {
            System.err.println("Error: Error al crear la sentencia");
            throw new RuntimeException(e);
        } ;

    }
}