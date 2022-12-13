import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Iniciando servidor...");
        ServerSocket servidor = new ServerSocket(8888);
        while (servidor != null  ){
            Socket conexion = servidor.accept();

            HiloServidor hs = new HiloServidor(conexion);
            hs.start();
        }
        servidor.close();
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
            PrintWriter escribirCliente = new PrintWriter(conexion.getOutputStream());
            Scanner teclado = new Scanner(System.in);
            while (linea != null){
                escribirCliente.println("Bienvenido, introduce tu nombre ");
                teclado.nextLine();
                System.out.println("Soy el servidor, " + teclado + " " + linea );
                linea = leerCliente.readLine();
            }
            leerCliente.close();
            conexion.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}