import java.util.Random;
import java.util.Scanner;

public class Hijo {
    public static void main(String[] args) throws Exception {
        // Creamos un scanner para leer por teclado
        Scanner sn = new Scanner(System.in);
        // Instancia de la clase random
        Random aleatorio = new Random();
        // Definimos el límite para el random
        int limite = 10;
        // Generamos un entero aleatorio
        int necesito = aleatorio.nextInt(limite);

        // Informamos de cuantos números necesitamos
        System.out.println("Necesito " + necesito + " número(s).");
        // Instanciamos el número mayor con un 0 (para que cualquiera sea mayor)
        int mayor = 0;

        // Repetimos la siguiente operación para cada número que necesitamos
        for (int i = 0; i < necesito; i++) {
            // Pedimos un número...
            System.out.println("Dame un número entero: ");
            // Mientras lo que nos introduzca no sea un número, volvemos a pedir
            while (!sn.hasNextInt()) {
                sn.next();
                System.out.println("Eso no es un número entero. Por favor, introduce un número entero: ");
            }
            // Leemos el número...
            int num = sn.nextInt();
            // Guardamos en "mayor" el mayor entre el número existente y el actual
            mayor = Math.max(mayor, num);
        }

        // Informamos de cual ha sido el mayor
        System.out.println("El mayor es: " + mayor);

        // Cerramos el scanner
        sn.close();
    }
}
