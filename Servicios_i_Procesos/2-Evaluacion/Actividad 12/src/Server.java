import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando servidor ...");
        ServerSocket servidor = null;

        // Crear Clave AES
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        SecretKey key = keygen.generateKey();

        // Guardamos la clave
        FileOutputStream ficeheroSecreto = new FileOutputStream("clave");
        ficeheroSecreto.write(key.getEncoded());
        ficeheroSecreto.close();

        // Generamos el algoritmo de cifrado
        Cipher algoritmoCifrado = Cipher.getInstance("AES");
        algoritmoCifrado.init(Cipher.ENCRYPT_MODE, key);
        Cipher algoritmoDescifrado = Cipher.getInstance("AES");
        algoritmoDescifrado.init(Cipher.DECRYPT_MODE, key);
        try {
            servidor = new ServerSocket(8888);
            while (servidor != null) {

                Socket conexion = servidor.accept();

                new HiloLector(conexion, algoritmoDescifrado).start();
                new HiloEscritor(conexion, algoritmoCifrado).start();
            }

        } catch (IOException e) {
            // TODO: handle exception
            System.err.println("Error al establecer conexion");
            System.exit(-1);
        } finally {
            try {
                servidor.close();

            } catch (IOException e) {
                // TODO: handle exception
                System.err.println("Error al cerrar el servidor");
                System.exit(-1);
            }
        }
    }

}

class Cliente {
    public static void main(String[] args) throws Exception {
        try {
            Socket conexion = new Socket("localhost", 8888);
            // Creamos una lista de byte que será la key
            byte[] lista = leerArchivo("clave");
            // 
            SecretKeySpec key = new SecretKeySpec(lista, "AES"); 
            // Generamos el algoritmo de cifrado
            Cipher algoritmoCifrado = Cipher.getInstance("AES");
            algoritmoCifrado.init(Cipher.ENCRYPT_MODE, key);
            // Generamos el algoritmo de descifrado
            Cipher algoritmoDescifrado = Cipher.getInstance("AES");
            algoritmoDescifrado.init(Cipher.DECRYPT_MODE, key);

            new HiloLector(conexion, algoritmoDescifrado).start();
            new HiloEscritor(conexion, algoritmoCifrado).start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println("Error al establecer conexion");
            System.exit(-1);
        }

    }

    public static byte[] leerArchivo(String archivo) {
        try {
            File file = new File(archivo);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            byte[] key = null;
            String linea;
            // Creamos un bucle donde leeremos liena por linea del archivo
            while ((linea = br.readLine()) != null) {
                key = linea.getBytes();
            }
            br.close();
            return key;

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al leer el archivo");
        }
        return null;

    }
}
