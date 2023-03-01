import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.Socket;

public class HiloServidor extends Thread {
    Socket conexion;

    public HiloServidor(Socket conexion) {
        this.conexion = conexion;
    }

    public void run() {
        try {
            // Creamos los metodos para leer y escribir al cliente
            BufferedReader leerCliente = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            PrintWriter escribirCliente = new PrintWriter(conexion.getOutputStream(), true);
            // Creamos una variable para controlar el bucle
            Boolean estado = true;
            // Le escribimos al cliente que una bienvenida para que sepa que esta conectado
            // a nuestro servidor
            escribirCliente.println("Saludos desde el servidor");

            while (estado) {

                // Mando un saludo al cliente Telnet
                String linea = leerCliente.readLine();
                if (linea.equalsIgnoreCase("help")) {
                    escribirCliente.println("WHI (Cual es mi IP) & EXIT (Salir del programa)");
                }
                // Si el cliente escirbe exit saldra de la conexion
                if (linea.equalsIgnoreCase("exit")) {
                    escribirCliente.println("Adios");
                    estado = false;
                }
                // Si el cliente escribe wmi le enseñaremos su ip
                if (linea.equalsIgnoreCase("wmi")) {
                    escribirCliente.println(conexion.getInetAddress());
                }

            }
            // Cerramos los metodos de leer y escribir al cliente
            leerCliente.close();
            conexion.close();

        } catch (IOException e) {
            System.err.println("Error al establecer conexion con el cliente");
        }
    }
}
