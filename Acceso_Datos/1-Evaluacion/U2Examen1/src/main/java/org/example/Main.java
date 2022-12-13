package org.example;

import Clases.Mundial;
import Clases.Pais;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;

public class Main {
    static String query="";
    static String select = "";
    static Connection conexion;

    static {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mundial","root", "1v4nG00n3r45");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static ResultSet rs = null;
    static Statement sentencia = null;
    public static void main(String[] args) {
        Mundial m = leerXML();
//        insertarEnBBDD(m);
        consultarInformacio(conexion);
    }

    private static void consultarInformacio(Connection conexion) {
        try{
            String sql = "select * from mundial inner join pais on mundial.id = pais.id_mundial";

            PreparedStatement ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("Id = " + rs.getInt("id")+"\n"
                        +"Titulo = " + rs.getString("titulo") +
                        "\nUbicacion = " + rs.getString("ubicacion")+
                        "\nEdicion = " + rs.getString("edicion")+
                        "\nSelecciones = " + rs.getString("total_selecciones")+
                        "\nEquipo = " + rs.getString("equipo")+
                        "\nRegion = " + rs.getString("region")+
                        "\nRanking = " + rs.getString("ranking")+
                        "\nEntrenador = " + rs.getString("entrenador"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static void insertarEnBBDD(Mundial m) {

        Connection conexion = null;
        try{
            conexion = DriverManager.getConnection ("jdbc:mysql://localhost:3306/mundial","root", "1v4nG00n3r45");
            if (conexion!= null){
                System.out.println("Conectado");
                Statement sentencia = conexion.createStatement();

                sentencia.execute("set foreign_key_checks = 0");
                insertarMundial(m,conexion,sentencia);
                ArrayList <Pais> paisLista = new ArrayList<>(m.getPais());


                for (int i = 0;i < paisLista.size() ; i++) {
                    Pais p = paisLista.get(i);
                    select = "select id from mundial where edicion = '" + m.getEdicion() + "'";
                    System.out.println(sentencia);
                    rs = sentencia.executeQuery(select);
                    if (rs.next()){
                        query = "insert into pais(id, equipo, region, ranking, entrenador, id_mundial) value('"
                                +p.getId()+"','"
                                +p.getEquipo()+"','"
                                +p.getRegion()+"','"
                                +p.getRanking()+"','"
                                +p.getEntrenador()+"','" +
                                rs.getString("id")+"')";
                        sentencia.executeUpdate(query);
                        System.out.println("Pais " + i + " insertado");

                    }

                }
                if (rs!= null) rs.close();
                sentencia.execute("set foreign_key_checks = 1 ");



//                sentencia.executeUpdate(query);
//                conexion.commit();
            }
        } catch (SQLException e) {
//            try{
//            conexion.rollback();
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
            throw new RuntimeException(e);

        }
    }

    private static void insertarMundial(Mundial m, Connection conexion, Statement sentencia) throws SQLException {
        String query;
        query = "insert into mundial (titulo, ubicacion, edicion, total_selecciones )values ('" + m.getTitulo()+"','" +m.getUbicacion() + "','" + m.getEdicion() + "','" + m.getTotalSelecciones() + "')";
        sentencia.executeUpdate(query);
        System.out.println("Mundial ha sido añadidia");

    }

    public static Mundial  leerXML(){
        try{
            JAXBContext context = JAXBContext.newInstance(Mundial.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Mundial mundial = (Mundial) unmarshaller.unmarshal(new File("datos.xml"));
            return mundial;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}