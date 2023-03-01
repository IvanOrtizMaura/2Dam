import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        try {

            Socket conexion = new Socket("localhost", 8888);
            BufferedReader leerServidor = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

            String numero1 = leerServidor.readLine();
            System.out.println(numero1);

            conexion.close();

        } catch (IOException e) {
            System.out.println(e);
        }

    }


}
