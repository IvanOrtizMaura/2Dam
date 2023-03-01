import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Server {
    public static void main(String[] args) {
        System.out.println("Iniciando servidor ...");
        ServerSocket servidor = null;

        try {
            // Creamos la Clave AES
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            SecretKey key = keygen.generateKey();

            // Guardamos la clave
            FileOutputStream ficheroSecreto = new FileOutputStream("clave");
            ficheroSecreto.write(key.getEncoded());
            ficheroSecreto.close();

            // Generamos el algoritmo cifrado
            Cipher algoritmoCifrado = Cipher.getInstance("AES");
            algoritmoCifrado.init(Cipher.ENCRYPT_MODE, key);

            // Generamos el algoritmo descifrado
            Cipher algoritmoDescifrado = Cipher.getInstance("AES");
            algoritmoDescifrado.init(Cipher.DECRYPT_MODE, key);

            // Asignamos el puerto al socket servidor
            servidor = new ServerSocket(8888);

            while (servidor != null) {

                // Creamos la conexion del servidor
                Socket conexion = servidor.accept();

                // Creamos los hilos escritores y lectores, lo iniciamos con el algoritmo
                // descifrado y algoritmo cifrado
                new HiloLector(conexion, algoritmoDescifrado).start();
                new HiloEscritor(conexion, algoritmoCifrado).start();
            }

        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error: Error al crear la clave");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error: Error al crear el fichero codificado");
        } catch (NoSuchPaddingException e) {
            System.err.println("Error: Error al crear el algoritmo de descifrado o cifrado");
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            System.err.println("Error: Clave invalida");
            e.printStackTrace();
        }

    }
}

class Cliente {
    public static void main(String[] args) {

        // Creamos un socket con la conexion del servidor
        Socket conexion;
        try {
            conexion = new Socket("localhost", 8888);
            // Creamos una array de bytes para guardar la clave
            byte[] lista = leerArchivo("clave");

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

    public static byte[] leerArchivo(String archivo) {
        File file = new File(archivo);
        FileReader fr;
        try {
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            byte[] key = null;
            String linea;
            // Creamos un bucle donde leeremos linea por linea del archivo
            while ((linea = br.readLine()) != null) {
                key = linea.getBytes();
            }
            br.close();
            return key;
        } catch (FileNotFoundException e) {
            System.err.println("Error: Error al leer el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error: Error al leer la linea");
            e.printStackTrace();
        }
        return null;

    }
}

class HiloLector extends Thread {

    Socket conexion;
    Cipher algoritmoDescifrado;

    public HiloLector(Socket conexion, Cipher algoritmoDescifrado) {
        this.conexion = conexion;
        this.algoritmoDescifrado = algoritmoDescifrado;
    }

    @Override
    public void run() {
        // Creamos un Buffer para poder leer lo que mandamos
        BufferedReader leer;
        try {
            leer = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

            // Creamos una varable para guardar la linea que lee el buffer
            String linea = leer.readLine();

            while ((linea) != null) {
                // Imprimimos la linea sin descodificar para la prueba
                System.out.println(linea);

                // Guardamos la linea descodificada en una variable
                String lineaDescifrado = new String(algoritmoDescifrado.doFinal(Base64.getDecoder().decode(linea)));

                // Imprimimos la linea ya descodificada
                System.out.println(lineaDescifrado);

                // Leemos la siguiente linea codificada que envian
                linea = leer.readLine();
            }
            leer.close();
        } catch (IOException e) {
            System.err.println("Error: Error al leer lo que nos han enviado");
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            System.err.println("Error: Cipher és incorrecto");
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

    }
}

class HiloEscritor extends Thread {
    Socket conexion;
    Cipher algoritmoCifrado;

    // Creamos los constructores con el socket y con el algoritmo
    public HiloEscritor(Socket conexion, Cipher algoritmoCifrado) {
        this.conexion = conexion;
        this.algoritmoCifrado = algoritmoCifrado;
    }

    @Override
    public void run() {

        // Creamos una variable para coger los datos metidos por teclado
        Scanner sc = new Scanner(System.in);

        try {
            // Implementamos el método necesario para escribir
            PrintWriter escribir = new PrintWriter(new OutputStreamWriter(conexion.getOutputStream()), true);

            System.out.println("¿Qué enviamos?");

            // Guardamos en una variable lo que ha insertado el cliente
            String linea = sc.nextLine();

            while (linea != null) {

                // Guardamos el mensaje codificado en una variable y la imprimimos al cliente
                // codificado
                String criptograma = Base64.getEncoder().encodeToString(algoritmoCifrado.doFinal(linea.getBytes()));
                escribir.println(criptograma);
                linea = sc.nextLine();
            }
            sc.close();

        } catch (IOException e) {
            System.err.println("Error: Error al escribir");
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            System.err.println("Error: Cipher és incorrecto");
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

    }
}