package org.example;

import java.io.*;
import java.util.Scanner;

public class Padre {
    static  Process p = null;
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        try {

            String comando = "java ParkingSacanner.java";
            ProcessBuilder pb = new ProcessBuilder(comando.split(" "));

            p = pb.start();

            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String linea;
            int numeroPlazas = 0;
            int numeroCoches = 0;

            OutputStream os = null;
            OutputStreamWriter osw = null;
            BufferedWriter bw = null;

            while ((linea = br.readLine()) != null) {
                System.out.println("Hijo: " + linea);
                if (linea.contains("plazas")) {
                    os = p.getOutputStream();
                    osw = new OutputStreamWriter(os);
                    bw = new BufferedWriter(osw);
                    numeroPlazas = Integer.parseInt(sc.nextLine());
                    bw.write(numeroPlazas + "\n");
                    bw.flush();
                }
                if (linea.contains("coches")) {
                    os = p.getOutputStream();
                    osw = new OutputStreamWriter(os);
                    bw = new BufferedWriter(osw);
                    numeroCoches = Integer.parseInt(sc.nextLine());
                    bw.write(numeroCoches + "\n");
                    bw.flush();
                }
            }
            sc.close();
            os.close();
            osw.close();
            bw.close();
            isr.close();
            is.close();
            br.close();
        } catch (IOException e) {
            System.err.println("Error a la entrada y salida");
        }
    }


}
