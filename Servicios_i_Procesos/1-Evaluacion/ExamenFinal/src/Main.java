import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantos escaladores han quedado atrapados? ");
        int numeroEscaladores = sc.nextInt();
        System.out.println("¿Cuantos helicopteros debería de enviar? ");
        int numerosHelicopteros = sc.nextInt();
        System.out.println("¿Cuantos helicopteros caben en la montana?");
        int sitioMontana = sc.nextInt();
        System.out.println("¿Cuantos escaladores caben en los Helicopteros?");
        int capacidadHelicoptero = sc.nextInt();
//      Creamos un array de escaladores para guardar el numero de escaladores que hay en la montana
        String [] escaladores = new String[numeroEscaladores];
//      Creamos un arrat de la capacidad de helicopteros que puede haber en la montana
        String[] sitio = new String[sitioMontana];
        Arrays.fill(sitio, " ");



        Montana montana = new Montana(sitio,escaladores,numeroEscaladores,sitioMontana, capacidadHelicoptero);
//        Creamos una lista de helicopteros para luego crearlos e iniciar el hilo
        Helicopteros [] listaHelicopteros = new Helicopteros[numerosHelicopteros];
        for (int i = 0; i <listaHelicopteros.length ; i++) {
            listaHelicopteros [i] = new Helicopteros("Helicoptero " + i,montana,capacidadHelicoptero );
            listaHelicopteros[i].start();
        }

    }
}
class Montana{
    int numeroEscaladores;
    int sitio;
    int numeroCapacidadHelicoptero;
    String [] sitioMontana;
    String [] escaladores;

    public Montana(String [] sitioMontana, String[] escaladores, int numeroEscaladores, int sitio, int numeroCapacidadHelicoptero){
        this.sitioMontana = sitioMontana;
        this.escaladores = escaladores;
        this.numeroEscaladores = numeroEscaladores;
        this.sitio = sitio;
        this.numeroCapacidadHelicoptero = numeroCapacidadHelicoptero;
    }

    public synchronized void entraHelicoptero(String nombre) throws InterruptedException {

            System.out.println("Soy " + nombre);
//          Le decimos que si no hay sitio que no entre que espere
            while(sitio == 0){
                wait();
            }
        System.out.println("Soy el "  + nombre + " Estoy dentro de la montana");
            sitio--;
//      Bucle para rescatar a los escaladores
        for (int i = 0; i < numeroCapacidadHelicoptero; i++) {
            System.out.println("He rescatado a escalador " + i);
            numeroEscaladores --;
        }
//      Bucle para actualizar el array
        for (int i = 0; i < sitioMontana.length; i++) {
            if (Objects.equals(sitioMontana[i], "")){
                sitioMontana[i] = nombre;
//                break;
            }
        }

        System.out.println(Arrays.toString(sitioMontana));

    }
    public synchronized void salHelicoptero(String nombre){
        sitio++;
        //Actualizaremos la array
        for (int i = 0; i < sitioMontana.length; i++) {
            if (Objects.equals(sitioMontana[i], nombre)){
                sitioMontana[i] = " ";
                break;
            }
        }
//        Crearemos un notifyAll() para levantar a los hilos
//        para decirles que hay una plaza libre;
        notifyAll();
        System.out.println("Estoy saliendo " + nombre);
    }

}

class Helicopteros extends Thread{
    String nombre;
    Montana montana;

    String [] capacidad;

    public Helicopteros(String nombre, Montana montana, int capacidadHelicoptero){
        this.nombre = nombre;
        this.montana = montana;
        this.capacidad = new String[capacidadHelicoptero];
    }
    public void run(){
        try {
            while(montana.numeroEscaladores != 0 ){
                montana.entraHelicoptero(nombre);
                Thread.sleep((long) (Math.random() * 1000));
                montana.salHelicoptero(nombre);
                Thread.sleep((long) (Math.random() * 1000));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}