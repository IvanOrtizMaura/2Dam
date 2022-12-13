import Clases.Coche;
import Clases.Concesionario;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        leer();
    }
    public static void leer() {

        try {
            JAXBContext context = JAXBContext.newInstance( Concesionario.class );
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Concesionario concesionario = (Concesionario) unmarshaller.unmarshal(
                    new File("concesionario.xml") );

            System.out.println(concesionario.getNombre());
            for (int i = 0; i<concesionario.getCoche().size(); i ++){
                System.out.println(concesionario.getCoche().get(i).getMarca());
                System.out.println(concesionario.getCoche().get(i).getPrecio());
                System.out.println(concesionario.getCoche().get(i).getMatricula());
                System.out.println("*******************************************");
            }



        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public  static void añadirCoche(){
        Scanner sc = new Scanner(System.in);
        String añadir = "";
        String marca = "";
        String color = "";
        String matricula = "";
        int precio = 0;

        System.out.println("Deseas añadir un coche");
        añadir = sc.nextLine();
        if (añadir.equalsIgnoreCase("si")){
            System.out.println("Teclee la marca del coche → ");
            marca = sc.nextLine();
            System.out.println("Teclee el color del coche → ");
            color = sc.nextLine();
            System.out.println("Teclee la matricula del coche");
            matricula = sc.nextLine();
//            validarMatricula(matricula);
            System.out.println("Teclee el precio del coche → ");
            precio = sc.nextInt();
            Coche coche = new Coche(marca,color,matricula,precio);

        }
    }
//    public static void validarMatricula(String matricula){
//        matricula.toUpperCase();
//        if (matricula.contains('A', 'B') {
//
//        }
//    }
}