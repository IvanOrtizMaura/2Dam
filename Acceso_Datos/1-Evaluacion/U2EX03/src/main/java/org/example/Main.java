package org.example;

import javax.xml.transform.Transformer;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/videoclub","root", "1v4nG00n3r45");

            if (conexion != null){
                System.out.println("Conectado");
            }
//            insertPelicula(conexion);
//            insertSocio(conexion);
//            modificarPelicula(conexion,"Transformer 3","Miguel", 7, "Universal",150, 2022, 4);
//            modificarSocio(conexion,"Marcos", "Lijó", 20, "Calle aragon", 698574123, 3);
//            eliminarPelicula(conexion, 2);
//            eliminarSocio(conexion, 1);
//            consultaPelicula(conexion, "Transformer",null,null);
//            consultaSocio(conexion, "Carlos", null);
//            crearPrestamos(conexion);
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Error: Error al intentar conectarme a la base de datos");
            throw new RuntimeException(e);
        }

    }

    private static void consultaSocio(Connection conexion, String nombre, String apellidos) {
        try {
             String sql = "select * from socios where 1 = 1";
             if (nombre != null){
                 sql += " and nombre = '" + nombre +"'";
             }
             if (apellidos != null){
                 sql += " and apellidos = '" + apellidos +"'";
             }
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("Id = " + rs.getInt("idSocio")+"\n"
                        +"Nombre = " + rs.getString("nombre") +
                        "\nApellidos = " + rs.getString("apellidos"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static void crearPrestamos(Connection conexion) {
    try{
        Statement sentencia = conexion.createStatement();
        String sql = "INSERT INTO prestamos(fechaInicio, fecharFin, idPelicula, idSocio) VALUES ('2022-05-25', '2022-05-30',1 ,2 )";
        sentencia.executeUpdate(sql);
        System.out.println("El prestamoy se ha añadido correctamente en la base de datos");
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }

    private static void consultaPelicula(Connection conexion, String nombrePelicula, String director, String productora) {
        try{
            String sql = "select * from peliculas where 1=1";

            if (nombrePelicula != null){
                sql += " and titulo = '" + nombrePelicula+"'";
            }
            if (director != null ){
                sql += " and director = '" + director+"'";
            }
            if(productora != null){
                sql +=" and prductora = '" + productora+"'";
            }
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("Id = " + rs.getInt("idPelicula")+"\n"
                        +"Titulo = " + rs.getString("titulo") +
                        "\nDirector = " + rs.getString("director")+
                        "\nProductora = " + rs.getString("prductora"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void eliminarSocio(Connection conexion, int i) {
        try {
            Statement sentencia = conexion.createStatement();
            String sql = "delete from socios where idSocio = " + i;
            sentencia.executeUpdate(sql);
            System.out.println("El socio ha sido eliminado");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static  void eliminarPelicula(Connection conexion, int i) {
        try {
            Statement sentencia = conexion.createStatement();
            String sql = "delete from peliculas where idPelicula = " + i;
            sentencia.executeUpdate(sql);
            System.out.println("La pelicula ha sido eliminada");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void modificarSocio(Connection conexion, String nombre, String apellidos, int edad, String direccion, int telefono, int idSocio) {
        try{
            Statement sentencia = conexion.createStatement();
            String sql = "update socios set nombre = '"+nombre+"', apellidos = '"+ apellidos + "', edad = '" +
                    edad+"', direccion = '" + direccion + "', telefono = '" + telefono +"' where idSocio = "+idSocio+";";
            sentencia.executeUpdate(sql);
            System.out.println("El socio ha sido modificado");
        } catch (SQLException e) {
            System.err.println("Error: Error al crear la sentencia para insertar una pelicula");
            throw new RuntimeException(e);
        }
    }

    private static void modificarPelicula(Connection conexion, String titulo, String director, int numEjemplares, String productora, int duracion, int año, int idPelicula) {
        try{
            Statement sentencia = conexion.createStatement();
            String sql ="UPDATE peliculas SET titulo = '"+ titulo +"' , director = '"+director+
                    "' , numEjemplares = '"
                    + numEjemplares +"' , prductora = '"
                    + productora + "' , duracion = '" + duracion+"' , ano = '" +año+
                    "'WHERE idPelicula = " + idPelicula+";";
            sentencia.executeUpdate(sql);
            System.out.println("La pelicula ha sido modificada");
        } catch (SQLException e) {
            System.err.println("Error: Error al crear la sentencia para insertar una pelicula");
            throw new RuntimeException(e);
        }
    }

    private static void insertSocio(Connection conexion) {
        try{
            Statement sentencia = conexion.createStatement();
            String sql = "INSERT INTO socios(nombre, apellidos, edad, direccion, telefono) " +
                    "VALUES ('Carlos', 'Navarro', 27, 'Cami vell de Bunyola, 80', 634611386)";
            sentencia.executeUpdate(sql);
            System.out.println("El socio ha sido añadido en el videoclub");
        } catch (SQLException e) {
            System.err.println("Error: Error al crear la sentencia para insertar un socio");
            throw new RuntimeException(e);
        }
    }

    private static void insertPelicula(Connection conexion) {
        try{
            Statement sentencia = conexion.createStatement();
            String sql = "INSERT INTO peliculas(titulo, director, numEjemplares, prductora, duracion, ano) VALUES ('Transformer3', 'Miguel', 7, 'Universal', 150, 2010)";
            sentencia.executeUpdate(sql);
            System.out.println("La pelicula se ha añadido correctamente en la base de datos");
        } catch (SQLException e) {
            System.err.println("Error: Error al crear la sentencia para insertar una pelicula");
            throw new RuntimeException(e);

        }
    }
}