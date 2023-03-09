import java.io.*;
import java.net.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class Server {

    private static final int port = 8888;

    public static void main(String[] args) {
        ListaCompartida lista = new ListaCompartida();
        ServerSocket servidor = null;

        try {
            // Creamos la Clave AES
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            SecretKey key = keygen.generateKey();

            // Guardamos la clave
            FileOutputStream ficheroSecreto = new FileOutputStream("clave");
            ficheroSecreto.write(key.getEncoded());
            ficheroSecreto.close();

            servidor = new ServerSocket(port);
            System.out.println("Servidor abierto en el puerto " + port);

            while (servidor != null) {
                // Esperar a que llegue una conexión entrante
                Socket conexion = servidor.accept();
                new HiloServidor(conexion, lista).start();

            }
        } catch (IOException | NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                servidor.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}

class ListaCompartida {
    HashMap<String, Socket> clientes = new HashMap<String, Socket>();

    public ListaCompartida() {

    }

    public synchronized void nueva(Socket conexion, String nombre, PrintWriter escribir) {

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
                escribir.println("CLientes conectados: " + clientes.keySet());
                break;
            case "/whoami":
                String nombre = null;

                for (HashMap.Entry<String, Socket> entry : clientes.entrySet()) {
                    if (entry.getValue() == conexion) {
                        nombre = entry.getKey();
                        break;
                    }
                }
                escribir.println("Su nombre es " + nombre);
                break;
            default:
                escribir.println("No es un comando valido");

        }

    }

    public synchronized void broadcast(String nombre, String linea) {
        clientes.forEach((hilo, socket) -> {
            PrintWriter escribir;
            try {
                escribir = new PrintWriter(socket.getOutputStream(), true);
                if (!hilo.equals(nombre)) {
                    escribir.println(nombre + ": " + linea);
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
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
        if (!clientes.containsKey(lineaComando[1])) {
            escribir.println("Error: Cliente no está conectado o no existe");
            return;
        }
        String mensaje = "";
        for (int i = 2; i < lineaComando.length; i++) {
            mensaje += lineaComando[i] + " ";
        }
        try {
            escribir = new PrintWriter(clientes.get(lineaComando[1]).getOutputStream(), true);
            escribir.println(mensaje);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public synchronized void cerrar(String nombre, Socket conexion) {
        clientes.remove(nombre, conexion);
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
            lista.cerrar(getName(), conexion);
            leerCliente.close();
            escribir.close();
            conexion.close();

        } catch (Exception e) {
            // Manejar excepciones si ocurren
            System.err.println("Error en HiloServidor: " + e.getMessage());
        }
    }
}
