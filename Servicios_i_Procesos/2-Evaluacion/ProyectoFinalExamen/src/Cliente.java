import java.io.*;
import java.net.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class Cliente {
    public static void main(String[] args) {

        FileInputStream fichero;
        // Creamos un socket con la conexion del servidor
        Socket conexion;
        try {
            fichero = new FileInputStream("clave");
            conexion = new Socket("localhost", 8888);
            // Creamos una array de bytes para guardar la clave
            byte[] lista = fichero.readAllBytes();

            // Creamos la clave seguna la clave que le mandamos
            SecretKeySpec key = new SecretKeySpec(lista, "AES");

            // Generamos el algoritmo de cifrado
            Cipher algoritmoCifrado = Cipher.getInstance("AES");
            algoritmoCifrado.init(Cipher.ENCRYPT_MODE, key);

            // Generamos el algoritmo de descifrado
            Cipher algoritmoDescifrado = Cipher.getInstance("AES");
            algoritmoDescifrado.init(Cipher.DECRYPT_MODE, key);

            new HiloLector(conexion, algoritmoDescifrado).start();
            new HiloEscritor(conexion, algoritmoCifrado).start();
        } catch (UnknownHostException e) {
            System.err.println("Error: Error al conectarse al host");
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error: Error en el cipher");
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            System.err.println("Error: La clave incorrecta");
            e.printStackTrace();
        }

    }

    
}
