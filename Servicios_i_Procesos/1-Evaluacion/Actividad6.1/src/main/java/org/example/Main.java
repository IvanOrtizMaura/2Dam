package org.example;

import java.io.*;

/*
Índice
1. Leer el documento El quijote.
2. Crear un hilo que lo usaremos para cada vocal
3. Crear un contador, donde en la clase iremos guardando toda la suma de las vocales
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Aplicacion.Contador contador = new Aplicacion.Contador();
        Aplicacion h1, h2, h3, h4, h5;
        h1 = new Aplicacion('a',contador);
        h2 = new Aplicacion('e',contador);
        h3 = new Aplicacion('i',contador);
        h4 = new Aplicacion('o',contador);
        h5 = new Aplicacion('u',contador);
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
        h1.join();
        h2.join();
        h3.join();
        h4.join();
        h5.join();
        System.out.println("Las vocales de este texto es: " + contador.suma);

    }
}

class Aplicacion extends Thread{
    Contador contador;
    char vocales;
    //Creamos un constructor con el contador y con una variable para
    // asignar la vocal que queremos que cuente
    public Aplicacion(char vocales, Contador contador){
        this.contador = contador;
        this.vocales = vocales;
    }

    public void run(){
        try {
            //Preparamos la lectura del archivo que queremos contar las vocales
            File archivo = new File("el_quijote.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            //Creamos la variable texto para guardar todo el documento en una variable
            String texto ;
            //Un bucle que no para hasta que no termine de leer todo el documento.
            while ( (texto = br.readLine()) != null ){
                //Bucle para que vaya por todas las posiciones del texto, es decir, por cada carácter
                for (int i = 0; i < texto.length(); i++) {
                    //Validar que el carácter que estamos es la vocal que le hemos asignado.
                    if (texto.charAt(i) == vocales){
                        //Llamamos al método del sumar del contador
                        contador.sumar();
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error: Error a la lectura del archivo");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.err.println("Error: Error al leer la linea del texto");
            throw new RuntimeException(e);
        }

    }
    static class Contador{
        int suma;
        public Contador(){this.suma = 0;}
        public synchronized void sumar(){this.suma++;}

    }
}

