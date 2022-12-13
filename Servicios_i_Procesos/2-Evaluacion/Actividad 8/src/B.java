import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
//claseCliente
public class B {
    public static void main(String[] args) {
        try {
            Socket conexion = new Socket("localhost", 8888);
            PrintWriter servidor = new PrintWriter(conexion.getOutputStream(), true);

            Scanner teclado = new Scanner(System.in);

            System.out.println("Que le envio al servidor");
            String linea = teclado.nextLine();

            while (linea != null){
                servidor.println(linea + "\n");
                linea = teclado.nextLine();
            }
        } catch (IOException e) {
            System.err.println("Error al establecer la conexion");
            System.exit(-1);
            throw new RuntimeException(e);

        }

    }
}
