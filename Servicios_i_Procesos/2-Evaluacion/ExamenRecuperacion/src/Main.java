import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        // Creamos un scaner para coger por teclado los trabajadores e impresoras
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce numero de trabajadores?");
        int numTrabajadores = sc.nextInt();
        System.out.println("Introduce numero impresoras?");
        int numImpresora = sc.nextInt();
        // Creamos la cola y una listaa de impresoras y trabajdores segun lo que el
        // usuario haya insertado la lista seria de esa capacidad
        Cola cola = new Cola();
        Trabajador[] trabajadores = new Trabajador[numTrabajadores];
        Impresora[] impresoras = new Impresora[numImpresora];
        try {
            // Cramos otro bucle para crear los trabajadores e iniciar el hilo
            for (int i = 0; i < trabajadores.length; i++) {
                Trabajador trabajador = new Trabajador(cola);
                trabajador.start();

            }
            // Creamos otro bucle para crear las impresoras e iniciar el hilo
            for (int i = 0; i < impresoras.length; i++) {
                Impresora impresora = new Impresora(cola);
                impresora.start();
            }

        } catch (Exception e) {
            System.err.println("Erros al iniciar el hilo");
            e.printStackTrace();

            // TODO: handle exception
        } finally {
            sc.close();
        }

    }
}

class Impresora extends Thread {

    public Cola cola;

    // Creamos el constructor de la clase, que lo juntamos con la cola
    public Impresora(Cola cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        // Creamos una variable random de segundos para el hilo duerma
        int randomSleep = ThreadLocalRandom.current().nextInt(5000, 10000);
        while (true) {
            // Siempre llamamos a imprimir
            cola.imprimir(getName());
            try {
                // Lo dormimos cuando ha impreso
                sleep(randomSleep);
            } catch (InterruptedException e) {
                System.err.println("No se ha podido parar la impresora");
                e.printStackTrace();
            }
        }
    }
}

class Trabajador extends Thread {
    public Cola cola;

    // Creamos el contructor de la clase que le pasamos la cola
    public Trabajador(Cola cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
       
        cola.mandarCola(getName());

    }
}

class Cola {
    LinkedList<String> cola;

    public Cola() {
        this.cola = new LinkedList<>();
    }

    public synchronized void mandarCola(String nombre) {
        try {
            System.out.println(cola);
            // Añadimos al trabajador a la cola
            cola.add(nombre);
            System.out.println(cola);
            // Si tu nombre no es el primero esperas
            while (!(cola.peek().equals(nombre))) {
                System.out.println("Soy trabajador " + nombre + ": ya he mandado mi documeto a imprimir");
                // Le decimos que espera al trabajador
                wait();
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public synchronized void imprimir(String nombre) {
        try {
            System.out.println(cola);
            // Si es mayor a cero la lista de nombres avisa a todos los trabajadores y lo eliminamos
            if (cola.size() > 0) {
                System.out.println("Soy Impresora " + nombre + ": He impreso " + cola.remove());
                notifyAll();
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}