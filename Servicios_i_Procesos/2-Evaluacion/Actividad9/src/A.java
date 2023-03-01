import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class A {
    public static void main(String[] args) {
        int puerto = 5000;
        byte[] buffer = new byte[1024];

        try {
            System.out.println("Iniciado el servidor");
            DatagramSocket conexion = new DatagramSocket(puerto);

            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
            while (true) {
                // Cogemos el paquete que ha enviado el client
                conexion.receive(peticion);
                // El paquete convertimos a un String
                String mensaje = new String(peticion.getData(), peticion.getOffset(), peticion.getLength());
                // Comprobamos el mensaje que no sea fin
                if (mensaje.equalsIgnoreCase("fin")) {
                    break;
                }
                // Mostramos por pantalla el mensaje que ha enviado el cliente
                System.out.println("El cliente dice: " + mensaje);

                int puertoCliente = peticion.getPort();

                // Cogemos la direccion dentro del paquete
                InetAddress direccion = peticion.getAddress();

                // Mensaje que le enviamos al cliente
                // Reiniciamos la lista
                buffer = new byte[1024];
                // Creamos na variable donde almacenaremos el mensaje invertido para luego
                // enviarlo
                String msgInvertido = invertirMensaje(mensaje);

                // El mensaje invertido lo guardamos dentro de la lista de byte
                buffer = msgInvertido.getBytes();
                // Preparamos el paquete para que sea enviado a la direccion
                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
                // Enviamos la el paquete preparado anteriormente
                conexion.send(respuesta);
            }

            conexion.close();

        } catch (SocketException e) {
            System.out.println(e);
        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // Método para invertir un String
    public static String invertirMensaje(String mensaje) {
        String mensajeInvertido = "";
        for (int x = mensaje.length() - 1; x >= 0; x--)
            mensajeInvertido = mensajeInvertido + mensaje.charAt(x);
        return mensajeInvertido;
    }
}
