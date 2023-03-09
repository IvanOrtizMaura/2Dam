import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    private static final int port = 8888;

    public static void main(String[] args) {
        ListaCompartida lista = new ListaCompartida();
        ServerSocket servidor = null;
        int maxConexiones = 10; // máximo número de conexiones aceptadas simultáneamente

        try {
            servidor = new ServerSocket(port);
            System.out.println("Servidor abierto en el puerto " + port);

            int numConexiones = 0;
            while (numConexiones < maxConexiones) {
                Socket conexion = servidor.accept();
                numConexiones++;
                new HiloServidor(conexion, lista).start();
            }
        } catch (IOException e) {
            System.err.println("Error al abrir el servidor: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        } finally {
            try {
                if (servidor != null) {
                    servidor.close();
                }
            } catch (IOException e) {
                System.err.println("Error al cerrar el servidor: " + e.getMessage());
            }
        }
    }

}

class ListaCompartida {
    HashMap<String, Socket> clientes = new HashMap<String, Socket>();

    public ListaCompartida() {
    }

    public synchronized void nueva(Socket conexion, String nombre, PrintWriter escribir) {
        if (clientes.containsKey(nombre)) {
            escribir.println("Error: El nombre de usuario ya existe.");
            return;
        }
        clientes.put(nombre, conexion);
        System.out.println("Se ha conectado " + nombre);
    }

    public synchronized void comandos(String linea, Socket conexion, PrintWriter escribir) {
        if (linea.toLowerCase().startsWith("/private")) {
            privado(linea, escribir);
            return;
        }
        switch (linea.toLowerCase()) {
            case "/list":
                if (!clientes.isEmpty()) {
                    escribir.println("CLientes conectados: " + clientes.keySet());
                } else {
                    escribir.println("No hay clientes conectados.");
                }
                break;
            case "/whoami":
                String nombre = null;
                for (HashMap.Entry<String, Socket> entry : clientes.entrySet()) {
                    if (entry.getValue() == conexion) {
                        nombre = entry.getKey();
                        break;
                    }
                }
                if (nombre != null) {
                    escribir.println("Su nombre es " + nombre);
                } else {
                    escribir.println("Error: No se pudo encontrar el nombre del cliente.");
                }
                break;
            default:
                escribir.println("No es un comando valido");
        }
    }

    public synchronized void broadcast(String nombre, String linea) {
        if (clientes.isEmpty()) {
            return;
        }
        clientes.forEach((hilo, socket) -> {
            PrintWriter escribir = null;
            try {
                escribir = new PrintWriter(socket.getOutputStream(), true);
                if (!hilo.equals(nombre)) {
                    escribir.println(nombre + ": " + linea);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } 
        });
    }

    public synchronized void privado(String linea, PrintWriter escribir) {
        String[] lineaComando = linea.split(" ");
        if (lineaComando.length < 3) {
            escribir.println("Error: /private [destinatario] [mensaje]");
            return;
        }
        String destinatario = lineaComando[1];
        if (!clientes.containsKey(destinatario)) {
            escribir.println("Error: Cliente no está conectado o no existe");
            return;
        }
        String mensaje = String.join(" ", Arrays.copyOfRange(lineaComando, 2, lineaComando.length));
        try {
            PrintWriter privado = new PrintWriter(clientes.get(destinatario).getOutputStream(), true);
            privado.println(mensaje);
        } catch (IOException e) {
            escribir.println("Error: No se pudo enviar el mensaje privado.");
        }
    }
    
    public synchronized void cerrar(String nombre) {
        if (!clientes.containsKey(nombre)) {
            return;
        }
        clientes.remove(nombre);
        String mensaje = nombre + " se ha desconectado";
        broadcast(nombre, mensaje);
        System.out.println(mensaje);
    }
    
}

class HiloServidor extends Thread {
    // Variables miembro
    private Socket conexion;
    private ListaCompartida lista;

    // Constructor
    public HiloServidor(Socket conexion, ListaCompartida lista) {
        this.conexion = conexion;
        this.lista = lista;
    }

    @Override
    public void run() {
        try {
            // Crear objetos para lectura y escritura en el socket
            BufferedReader leerCliente = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            PrintWriter escribir = new PrintWriter(new OutputStreamWriter(conexion.getOutputStream()), true);

            // Registrar la conexión en la lista compartida
            lista.nueva(conexion, getName(), escribir);

            // Leer el primer mensaje del cliente
            String linea = leerCliente.readLine();

            // Enviar mensaje de bienvenida al cliente
            escribir.println("Bienvenido");
            escribir.println(" ");

            // Leer mensajes del cliente hasta recibir "/EXIT"
            while (linea != null) {
                if (linea.equalsIgnoreCase("/EXIT")) {
                    // Salir del bucle si se recibe "/EXIT"
                    break;
                } else if (linea.startsWith("/")) {
                    // Ejecutar comandos si se reciben mensajes que comienzan con "/"
                    lista.comandos(linea, conexion, escribir);
                } else {
                    // Enviar mensaje a todos los clientes si no es un comando
                    lista.broadcast(getName(), linea);
                }
                linea = leerCliente.readLine();
            }

            // Eliminar la conexión de la lista compartida y cerrar los objetos de lectura y
            // escritura
            lista.cerrar(getName());
            leerCliente.close();
            escribir.close();
            conexion.close();

        } catch (Exception e) {
            // Manejar excepciones si ocurren
            System.err.println("Error en HiloServidor: " + e.getMessage());
        }
    }
}