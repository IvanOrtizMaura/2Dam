import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Iniciando servidor ...");
        ServerSocket servidor = null;
        try {
            servidor = new ServerSocket(8888);
            while (servidor != null) {
                Socket conexion = servidor.accept();

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
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
