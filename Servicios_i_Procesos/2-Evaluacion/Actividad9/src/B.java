import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        int puertoServidor = 5000;
        // Creamo un array de bytes
        byte[] buffer = new byte[1024];
        Scanner sc = new Scanner(System.in);

        try {
            // Creamos la conexoin con el servidor
            DatagramSocket conexion = new DatagramSocket();
            InetAddress direccionServidor = InetAddress.getByName("localhost");

            String mensaje = "";
            // Comprobamos que el mensaje que enviamos no sea fin, si es asi pues cerramos
            // la conexion
            while (!mensaje.toLowerCase().equals("fin")) {
                System.out.println("Introduce una palabra");
                // Guradamos lo que escribe el cliente en una variable
                mensaje = sc.nextLine();
                // Lo guardamos en la lista de bytes
                buffer = mensaje.getBytes();
                // Preparamos el paquete donde esta dentro el mensaje del usuario, para ser
                // enviado

                DatagramPacket paquete = new DatagramPacket(buffer, 0, buffer.length, direccionServidor,
                        puertoServidor);
                // Le confirmo al usuario que se ha enviado al servidor
                System.out.println("Envio el datagrama");
                // Envio el paquete preparado enterior mente
                conexion.send(paquete);
                // Comprobamos que el mensaje sea fin y salga
                if (mensaje.equalsIgnoreCase("fin")) {
                    break;
                }
                // Reiniciamos la lista
                buffer = new byte[1024];
                // Estamso pendientes a que el servidor nos mande un paquete
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
                conexion.receive(peticion);
                //Guardamos el paquete en la variable mensaje
                mensaje = new String(peticion.getData(), peticion.getOffset(), peticion.getLength());
                //Enseñamos por pantalla el mensaje invertido que ha mandado el servidor
                System.out.println("El servidor dice: " + mensaje);

            }

            sc.close();
            conexion.close();

        } catch (SocketException e) {
            System.out.println(e);
        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
