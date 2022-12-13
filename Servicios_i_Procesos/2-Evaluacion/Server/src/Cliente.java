import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws Exception {
        Socket conexion = new Socket("localhost", 5555);
        PrintWriter servidor = new PrintWriter(conexion.getOutputStream(), true);

        Scanner teclado = new Scanner(System.in);

        System.out.println("¿Que envio al servidor?");
        String linea = teclado.nextLine();
        BufferedReader br = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String lineaServidro = br.readLine();


        while (linea != null){
            servidor.println(linea);
            System.out.println(lineaServidro);

            lineaServidro = br.readLine();
            linea = teclado.nextLine();

        }
        teclado.close();
        servidor.close();
        conexion.close();

    }
}

