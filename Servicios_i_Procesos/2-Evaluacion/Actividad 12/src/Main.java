import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main {
    public static void main(String[] args) throws Exception {
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

        BufferedReader lectura = new BufferedReader(new FileReader("el quijote.txt"));
        BufferedWriter ficheroCifrado = new BufferedWriter(new FileWriter("fichero_cifrado"));

        String linea = lectura.readLine();
        while (linea != null) {
            // Ciframos
            String criptograma = Base64.getEncoder().encodeToString(algoritmoCifrado.doFinal(linea.getBytes()));
            // Guradamos
            ficheroCifrado.write(criptograma + "\n");
            ficheroCifrado.flush();
            // Leemos la siguiente linea
            linea = lectura.readLine();

        }
        ficheroCifrado.close();
        lectura.close();

        BufferedReader lecturaCifado = new BufferedReader(new FileReader("fichero_cifrado"));
        BufferedWriter ficheroDescifrado = new BufferedWriter(new FileWriter("fichero_descifrado"));
        String lineaCifrada = lecturaCifado.readLine();
        while (lineaCifrada != null) {
            String textoPlano = new String(algoritmoDescifrado.doFinal(Base64.getDecoder().decode(lineaCifrada)));
            ficheroDescifrado.write(textoPlano);
            ficeheroSecreto.flush();
            lineaCifrada = lecturaCifado.readLine();
        }
        lecturaCifado.close();
        ficheroDescifrado.close();
    }
}