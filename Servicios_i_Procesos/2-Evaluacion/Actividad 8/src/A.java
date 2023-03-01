import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//claseServidro
public class A {
    public static void main(String[] args) {
        try{
            System.out.println("Servidor iniciado");
            ServerSocket servidor = new ServerSocket( 8888);
            while (servidor != null ){
                Socket conexion = servidor.accept();
                HiloServidor hs = new HiloServidor(conexion);
                hs.start();
            }
        } catch (IOException e) {
            System.err.println("Error al establecer conexion");
            throw new RuntimeException(e);
        }
    }

}
class HiloServidor extends Thread{
    Socket conexion;
    public HiloServidor(Socket conexion) {
        this.conexion = conexion;
    }
    public void run(){
        try {
            BufferedReader leerCliente = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea = leerCliente.readLine();
            PrintWriter escribirCliente = new PrintWriter(conexion.getOutputStream(),true);



            Scanner sc = new Scanner(System.in);
            String lineaServidor = sc.nextLine();

            while (linea != null){
                System.out.println("El cliente dice, " + linea);

                escribirCliente.println("Binevenido Cliente");

                lineaServidor += escribirCliente.toString();

                linea = leerCliente.readLine();
            }
            
        } catch (IOException e) {
            System.err.println("Error al leer al cliente");
            throw new RuntimeException(e);
        }
    }
}
