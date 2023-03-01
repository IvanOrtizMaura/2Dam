import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Base64;

import javax.crypto.Cipher;

public class HiloLector extends Thread {
    Socket conexion;
    Cipher algoritmoDescifrado;

    public HiloLector(Socket conexion, Cipher algoritmoDescifrado ) {
        this.conexion = conexion;
        this.algoritmoDescifrado = algoritmoDescifrado;
    }

    @Override
    public void run() {
        try {
            BufferedReader leerCliente = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea = leerCliente.readLine();
            while((linea) != null){
                System.out.println(linea);

                String lineaDescifrada = new String(algoritmoDescifrado.doFinal(Base64.getDecoder().decode(linea)));
                System.out.println(lineaDescifrada);
                linea = leerCliente.readLine();
            }
            leerCliente.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
