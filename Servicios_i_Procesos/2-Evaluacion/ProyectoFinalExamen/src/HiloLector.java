import java.io.*;
import java.net.*;
import java.util.Base64;
import javax.crypto.*;

public class HiloLector extends Thread {

    Socket conexion;
    Cipher algoritmoDescifrado;

    public HiloLector(Socket conexion, Cipher algoritmoDescifrado) {
        this.conexion = conexion;
        this.algoritmoDescifrado = algoritmoDescifrado;
    }

    @Override
    public void run() {
        // Creamos un Buffer para poder leer lo que mandamos
        BufferedReader leer;
        String[] lista;
        try {
            leer = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

            // Creamos una varable para guardar la linea que lee el buffer
            String linea = leer.readLine();

            while ((linea) != null) {

                if (linea.startsWith("Servidor:") || linea.startsWith("Error:")) {
                    System.out.println(linea);
                } else if (linea.startsWith("Mensaje privado:")) {
                    lista = linea.split(":");
                    String lineaDescifrado = new String(
                            algoritmoDescifrado.doFinal(Base64.getDecoder().decode(lista[2])));
                            // Imprimimos la linea ya descodificada
                    System.out.println(lista[0] + " de "+ lista[1] + ": " + lineaDescifrado);
                    

                } else {
                    lista = linea.split(":");
                    // Imprimimos la linea sin descodificar para la prueba
                    System.out.println(linea);

                    // Guardamos la linea descodificada en una variable
                    String lineaDescifrado = new String(
                            algoritmoDescifrado.doFinal(Base64.getDecoder().decode(lista[1])));

                    // Imprimimos la linea ya descodificada
                    System.out.println(lista[0] + ": " + lineaDescifrado);
                }

                // Leemos la siguiente linea codificada que envian
                linea = leer.readLine();
            }
            leer.close();
        } catch (IOException e) {
            System.err.println("Error: Error al leer lo que nos han enviado");
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            System.err.println("Error Hilo Lector: Cipher és incorrecto");
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

    }
}
