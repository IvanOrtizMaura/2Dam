import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Hijo {
    public static void main(String[] args) {
        try{
            // Lee el texto del padre
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            String cadena  = null;
            //Lee la cadena que se inserta en el padre
            cadena = br.readLine();
            //Muestra la cadena que recibirá el padre
            System.out.println(cadena.toUpperCase());

        } catch (IOException e) {
            System.err.println("Error: Error al leer el archivo");
        }
    }
}
