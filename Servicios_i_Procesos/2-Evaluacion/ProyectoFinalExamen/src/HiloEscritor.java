import java.io.*;
import java.net.*;
import java.util.*;
import javax.crypto.*;

public class HiloEscritor extends Thread {
    Socket conexion;
    Cipher algoritmoCifrado;

    // Creamos los constructores con el socket y con el algoritmo
    public HiloEscritor(Socket conexion, Cipher algoritmoCifrado) {
        this.conexion = conexion;
        this.algoritmoCifrado = algoritmoCifrado;
    }

    @Override
    public void run() {

        // Creamos una variable para coger los datos metidos por teclado
        Scanner sc = new Scanner(System.in);

        try {
            // Implementamos el método necesario para escribir
            PrintWriter escribir = new PrintWriter(new OutputStreamWriter(conexion.getOutputStream()), true);

            System.out.println("Bienvenido");

            // Guardamos en una variable lo que ha insertado el cliente
            String linea = sc.nextLine();

            while (linea != null) {
                if (linea.startsWith("/private")) {
                    String[] lista = linea.split(" ", 3);
                    // Guardamos el mensaje codificado en una variable y la imprimimos al cliente
                    // codificado
                    String criptograma = Base64.getEncoder()
                            .encodeToString(algoritmoCifrado.doFinal(lista[2].getBytes()));
                    escribir.println(lista[0] + " " + lista[1] + " " + criptograma);
                } else

                if (linea.startsWith("/")) {
                    escribir.println(linea);
                } else {
                    String criptograma = Base64.getEncoder().encodeToString(algoritmoCifrado.doFinal(linea.getBytes()));
                    escribir.println(criptograma);
                }

                linea = sc.nextLine();
            }
            sc.close();

        } catch (IOException e) {
            System.err.println("Error: Error al escribir");
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            System.err.println("Error Hilo escritor: Cipher és incorrecto");
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

    }
}
