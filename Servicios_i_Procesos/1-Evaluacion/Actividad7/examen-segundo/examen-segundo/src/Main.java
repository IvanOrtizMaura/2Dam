import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        String line;
        try {
            // Iniciamos proceso para llamar a la clase Hijo
            Process hijo = new ProcessBuilder( "java", "src/Hijo.java").start();

            // Buffer para capturar la salida de datos del proceso hijo y almacenarla
            BufferedReader outputDelHijo = new BufferedReader(new InputStreamReader(hijo.getInputStream()));

            // Stream para imprimir los datos que le pasamos a la clase Hijo
            PrintStream inputDelHijo = new PrintStream(hijo.getOutputStream());

            // Buffer que lee de consola para capturar la entrada de datos a la clase Hijo
            BufferedReader leerPorTeclado = new BufferedReader(new InputStreamReader (System. in));

            // Enviar mensaje al hijo
            line = outputDelHijo.readLine(); // Recibimos lo que nos dice la clase Hijo
            while (line!=null){ // Bucle para que siga leyendo a la clase Hijo hasta que ya no haya nada que leer
                System.out.println("Hijo dice: " + line);
                if (line.contains("Dame")){
                    // Preguntar al usuario que quieres que le diga al hijo
                    System.out.println("Que quieres introducir: ");
                    // Clase Hijo recibe la información del padre
                    line = leerPorTeclado.readLine(); // Guardamos en line lo que le pasamos por teclado
                    inputDelHijo.println(line); // Se lo pasamos a la clase Hijo
                    inputDelHijo.flush();
                }
                line = outputDelHijo.readLine(); // Seguimos leyendo a la clase Hijo
            }
            // Destruimos el proceso por si se quedara abierto (es una buena práctica)
            hijo.destroy();
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }
}