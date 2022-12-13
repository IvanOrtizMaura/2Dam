package org.example;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ParkingSacanner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el numero de plazas = ");
        int numeroPlazas = sc.nextInt();
        System.out.println("Introduce el numero de coches = ");
        int numeroCoches = sc.nextInt();

//        Creamos un array de plazas del parking y le metemos la variable
//        número plazas para indicarles cuantas plazas tienen el parking
        String [] plazas = new String[numeroPlazas];
        Arrays.fill(plazas, " ");

//        Ahora creamos el parking que le metemos por parámetros
//        el número de plazas y la array que hemos creado anteriormente
        ParkingScanner p = new ParkingScanner(plazas, numeroPlazas);

//        Creamos otra array de diez coches, donde meteremos
//        el nombre de cada coche para que pueda entrar en el parking
        CocheScanner [] listaCoches = new CocheScanner[numeroCoches];

//        Un bucle para asignar a cada coche su nombre
        for (int i = 0; i < listaCoches.length; i++) {
            listaCoches[i] = new CocheScanner("Coche " + i, p );
            listaCoches[i].start();
        }
    }
}
//Creamos una clase Parking
class ParkingScanner {
    String[] plazas;
    int numeroPlazas;
    //    Creamos un constructor con el array de plazas y
//    con el número de plazas que va a tener el parking
    public ParkingScanner(String[] plazas, int numeroPlazas) {
        this.plazas = plazas;
        this.numeroPlazas = numeroPlazas;
    }
    //  Creamos el método entrar coche para que entre un coche en el parking
    public synchronized void entraCoche(String nombre ) {
        try {
            System.out.println("Soy " + nombre);
//            Creamos un bucle para decirle al coche que si
//            el número de plazas es cero se tiene que esperar
            while (numeroPlazas == 0) {
                wait();
            }
            System.out.println("Soy el " + nombre + " Estoy dentro del parking");

//            Una vez que haya un espacio en la array entrara el coche y
//            restaremos un número de plazas para que no entre más coches
            numeroPlazas--;
//            Actualizaremos la array
            for (int i = 0; i < plazas.length; i++) {
                if (Objects.equals(plazas[i], " ")){
                    plazas [i] = nombre;
                    break;
                }
            }
            System.out.println(Arrays.toString(plazas));
        } catch (InterruptedException e) {
            System.err.println("Error: Error al entrar el coche");
            throw new RuntimeException(e);
        }

    }
    public synchronized void salirCoche(String nombre) {

        numeroPlazas++;
        //Actualizaremos la array
        for (int i = 0; i < plazas.length; i++) {
            if (Objects.equals(plazas[i], nombre)){
                plazas[i] = " ";
                break;
            }
        }
//        Crearemos un notifyAll() para levantar a los hilos
//        para decirles que hay una plaza libre;
        notifyAll();
        System.out.println("Estoy saliendo " + nombre);
    }



}

class CocheScanner extends Thread {
    String nombre;
    ParkingScanner parking;

    public CocheScanner(String nombre, ParkingScanner parking) {
        this.nombre = nombre;
        this.parking = parking;
    }
    @Override
    public void run() {
        try {
            while (true){
                parking.entraCoche(nombre);
                Thread.sleep((long) (Math.random() * 1000));
                parking.salirCoche(nombre);
                Thread.sleep((long) (Math.random() * 1000));
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

