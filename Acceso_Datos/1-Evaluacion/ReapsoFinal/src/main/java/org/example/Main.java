package org.example;

import Clases.Direccion;
import Clases.Hotel;
import Clases.Hoteles;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        Connection conexion = null;
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteles","root", "1v4nG00n3r45");
            if (conexion!= null){
                System.out.println("conectado ");
                Statement s = conexion.createStatement();
                JAXBContext context = JAXBContext.newInstance(Hoteles.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();

                File file = new File("hoteles.xml");
                Hoteles hoteles = (Hoteles) unmarshaller.unmarshal(file);

//                insertarDirecciones(hoteles, s);
//                insertarEmpresa(hoteles, s);
                insertarHoteles(hoteles, s);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void insertarHoteles(Hoteles hoteles, Statement s) throws Exception {
        s.execute("set foreign_key_checks = 0 ");

        ArrayList <Hotel> listaHotel = new ArrayList<>(hoteles.getHotel());

        String query, select;
        ResultSet rs = null;
        for (int i = 0; i < listaHotel.size(); i++) {
            Hotel hotel = listaHotel.get(i);
            select = "select id from direccion where id_hotel = " + hotel.getId();
            rs = s.executeQuery(select);
            if (rs.next()){
                query = "insert into hotel (id, nombre, estrellas, telefono, id_direccion, id_empresa) values ('"+hotel.getId() + "','"+ hotel.getNombre()+"','"+hotel.getEstrellas()+"','"+hotel.getTelefono()+"','"+rs.getString(1)+"',1)";
                s.executeUpdate(query);

            }
            System.out.println("Hote " + i + " insertado");

        }

        s.execute("set foreign_key_checks = 1 ");

    }

    private static void insertarEmpresa(Hoteles hoteles, Statement s) throws Exception {
        String query;
        query = "insert into empresa (nombre, fundacion, ciudad_sede, pais_sede )values ('" + hoteles.getEmpresa()+"','" +hoteles.getFundacion() + "','" + hoteles.getCiudadSede() + "','" + hoteles.getPaisSede() + "')";
        s.executeUpdate(query);
        System.out.println("Empresa ha sido añadidia");
        s.close();


    }


    private static void insertarDirecciones(Hoteles hoteles, Statement s ) throws Exception {
        s.execute("set foreign_key_checks = 0 ");

        ArrayList <Direccion> direccions = new ArrayList<>();
        for (Hotel h: hoteles.getHotel()) {
            direccions.add(h.getDireccion());
        }

        String query;
        for (int i = 0; i < direccions.size(); i++) {
            Direccion d = hoteles.getHotel().get(i).getDireccion();
            query = "insert into direccion (calle, numero, ciudad, codigo_postal, pais, id_hotel) values ('" + d.getCalle() +"','" +d.getNumero() + "','" + d.getCiudad() + "','" + d.getCodigoPostal() + "','" + d.getPais() +"','" + hoteles.getHotel().get(i).getId() +"')";
            s.executeUpdate(query);
            System.out.println("Direccion " + i +  " direccion");
        }
        s.execute("set foreign_key_checks = 1 ");
        s.close();
    }

}