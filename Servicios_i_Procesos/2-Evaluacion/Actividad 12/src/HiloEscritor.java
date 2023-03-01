import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class HiloEscritor extends Thread {
    Socket conexion;
    Cipher algoritmoCifrado;

    public HiloEscritor(Socket conexion, Cipher algoritmoCifrado) {
        this.conexion = conexion;
        this.algoritmoCifrado = algoritmoCifrado;
    }


    @Override
    public void run() {
        try {
            Scanner sc = new Scanner(System.in);
            PrintWriter escribir = new PrintWriter(new OutputStreamWriter(conexion.getOutputStream()), true);
            System.out.println("¿Que enviamos?");
            String linea = sc.nextLine();

            while (linea != null) {
                try {

                    String criptograma = Base64.getEncoder().encodeToString(algoritmoCifrado.doFinal(linea.getBytes("UTF-8")));
                    escribir.println(criptograma);
                    linea = sc.nextLine();

                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                }
                
                
            }
            sc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
