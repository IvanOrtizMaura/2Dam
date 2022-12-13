import java.io.*;
import java.util.Scanner;

import java.io.*;
import java.util.Scanner;

public class Padre {
    static  Process p = null;
    static Scanner sc = new Scanner(System.in);



    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "hijo.ja"
            );

            p = pb.start();

            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String linea;
            int numeroEscaladores = 0;
            int numeroHelicopteros = 0;
            int numeroSitio = 0;
            int numeroCapacidadHelicoptero =0;



            while ((linea = br.readLine()) != null) {
                System.out.println("Hijo: " + linea);

                if (linea.contains("escaladores")){
                    numeroEscaladores = Integer.parseInt(sc.nextLine());
                    escribirHijo(numeroEscaladores);

                }else if (linea.contains("enviar")){
                    numeroHelicopteros = Integer.parseInt(sc.nextLine());
                    escribirHijo(numeroHelicopteros);
                }else if (linea.contains("montaña")){
                    numeroSitio = Integer.parseInt(sc.nextLine());
                    escribirHijo(numeroSitio);
                }else if (linea.contains("caben")){
                    escribirHijo(numeroCapacidadHelicoptero);
                    numeroCapacidadHelicoptero = Integer.parseInt(sc.nextLine());
                }
            }
            sc.close();
            isr.close();
            is.close();
            br.close();
        } catch (IOException e) {
            System.err.println("Error en la entrada y salida");
        }
    }
    public static void escribirHijo(int i) throws IOException {
         OutputStream os = p.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write(i + "\n");
        bw.flush();

    }


}
