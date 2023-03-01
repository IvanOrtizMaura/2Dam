import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    private static final int port = 8888;

    private static ArrayList<Connection> conexiones = new ArrayList<>();

    public static void main(String[] args) {

        ServerSocket servidor = new ServerSocket(port);
        System.out.println("Servidor abierto en el puerto " + port);

        while (true) {
            // Esperar a que llegue una conexión entrante
            Socket socket = servidor.accept();

            // Crear una nueva conexión y agregarla a la lista de conexiones activas
            Connection connection = new Connection(socket);
            connections.add(connection);
        }

    }

class HiloServidor extends Thread {
    Socket conexion;

    public HiloServidor(Socket conexion) {
        this.conexion = conexion;
    }

    @Override
    public void run() {
        try {
            BufferedReader leerCliente = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea = leerCliente.readLine();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
