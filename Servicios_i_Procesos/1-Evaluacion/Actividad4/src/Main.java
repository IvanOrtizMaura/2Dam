import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // Creamos un if para comprobar que le pasamos los argumentos necesarios
        if (args.length == 0) {
            System.out.println("Se necesitan introducir argumentos");
            System.exit(-1);
        }
        try {
            // Creamos un scanner
            Scanner sc = new Scanner(System.in);

            // Creamos el proceso con los argumentos necesarios
            ProcessBuilder pb = new ProcessBuilder(args);

            String linea;
            String num;

            // Creamos un bucle que hasta que el usuarios no ecriba fin no terminará
            while (!(linea = sc.nextLine()).equalsIgnoreCase("fin")) {
                // Comprobamos que lo que pasa el usuario sea un entero
                if (!linea.equals("")) {
                    System.out.println("Error: No en un entero, recuerda que para salir del programa hay que escribir fin");
                } else {
                    // Inicia el proceso hijo
                    Process process = pb.start();

                    // Creamos un InputStream para coger la informacion del hijo
                    InputStream inputStream = process.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    num = bufferedReader.readLine();
                    System.out.print("Hijo dice: " + num );
                }
            }

            System.out.println("Fin del programa");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}