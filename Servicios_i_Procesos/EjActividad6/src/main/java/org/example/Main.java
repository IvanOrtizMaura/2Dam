package org.example;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Creamos un semaforo
        Semaphore s = new Semaphore(1);
        //Creamos un array de clientes
        Cliente [] cs = new Cliente[20];
        //Creamos clientes segun el array
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new Cliente("Cliente" + (i+1), s);
            //Iniciamos los clientes
            cs[i].start();
        }
        for (int i = 0; i < cs.length; i++) {
            cs[i].join();
        }

    }

}
class Cliente extends Thread{
    String nombre;
    Semaphore s;
    public Cliente(String nombre, Semaphore s){
        this.nombre = nombre;
        this.s = s;
    }
    public void run(){
        System.out.println("Hola soy " + this.nombre +" estoy comprando");
        try {
            s.acquire();
            System.out.println("Hola soy " + this.nombre +" estoy en la cola");
            Thread.sleep(200);
        }catch (InterruptedException e){
            System.err.println(this.nombre + "Ha sido interrumpido");
            return;
        }

        s.release();
        System.out.println("Hola soy " + this.nombre + " ya he terminador");
    }

}