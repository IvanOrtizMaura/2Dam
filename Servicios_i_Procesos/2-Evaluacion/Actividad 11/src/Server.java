import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("Iniciando servidor...");
            // Creamos el servidor, e indicamos el puerto del servidor
            ServerSocket servidor = new ServerSocket(8888);

            while (servidor != null) {
                // Creamos una conexion y el servidor lo acepta
                Socket conexion = servidor.accept();
                // Creamos un hilo para que cada conexion desde telnet se ejecute un hilo y haga
                // cosas
                new HiloServidor(conexion).start();

            }
            
        } catch (IOException e) {
            System.err.println("Error a crear el servidor");
            System.exit(-1);
        }

    }
}