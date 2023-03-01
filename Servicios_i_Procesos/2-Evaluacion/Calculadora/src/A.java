import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class A {
    public static void main(String[] args) {
        try {
            System.out.println("Iniciando servidor");
            ServerSocket servidor = new ServerSocket(8888);
            Socket conexion = new Socket();
            System.out.println("Conexion establecida");

            servidor.accept();
            BufferedReader leer = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            PrintWriter escribirCliente = new PrintWriter(conexion.getOutputStream(), true);
            escribirCliente.println("Introduce primer numero");

            
            servidor.close();
            conexion.close();
        } catch (SocketException e) {
            System.err.print("Error al establecer conexión");
        } catch (IOException f) {
            System.err.println("Error a la entrada y salida de datos");
        }

    }

}
