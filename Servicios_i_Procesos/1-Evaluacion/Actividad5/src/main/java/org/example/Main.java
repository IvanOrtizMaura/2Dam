package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Creamos los corredores
        Corredor[] corredores = new Corredor[2];
        for (int i = 0; i < corredores.length; i++) {
            corredores[i] = new Corredor("Corredor " + i+1);
            //Iniciamos los corredores
            corredores[i].start();
        }
        for (int i = 0; i < corredores.length; i ++){
            corredores[i].join();
        }


    }
}
class Corredor extends Thread{
    String nombre;
    int meta = 100;
//Creamos el constructor
    public Corredor(String nombre){
        this.nombre = nombre;
    }

    public void run(){
        try {
                int m = (int) (Math.random()*9);
                int r = 0;
                //Hacemos un bucle teniendo en cuenta el recorrido y la meta
                while(r < meta){
                    r = r + m;
                    //Comprobamos que un corredor no haya corrido mas de lo que toca
                    if (r>=meta){
                        r = meta;
                    }
                    System.out.println(this.nombre + " ha corrido " + m + " metros y le falata " + (meta - r) + " metros para llegar a la meta");
                    //Hacemos que cada corredor descanse un numero aleatorio
                    Thread.sleep((long) (Math.random() * 1000));
                }
            System.out.println("***********************************");
            System.out.println(this.nombre + " ha llegado a la meta");
            System.out.println("***********************************");
            }catch (InterruptedException e){
                System.err.println("El hijo ha sido interrumpido");
                System.exit(-1);
            }
}
}