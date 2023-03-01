import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Padre {
    public static void main(String[] args) {
        String linea;
        int rNum;

        try {
            // Creacion del objeto ProcessBuilder y ejecucion del proceso hijo
            ProcessBuilder pb = new ProcessBuilder(args);
            Process p = pb.start();
            // Creamo los objetos del BufferReader y PrintWrite que permiten la comunicacion
            // entre los procesos
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(p.getOutputStream()), true);
            // Creamos un bucle que lee linea a linea lo que sale del stdout del hijo y a su
            // vez introduce en su stdin numeros aleatorios cuando este lo requiera
            linea = br.readLine();
            while ((linea) != null) {
                System.out.println("Hijo dice: " + linea);
                if (linea.contains("?")) {
                    rNum = (int) ((Math.random()) * 5);
                    pw.println(rNum);
                }
                linea = br.readLine();

            }
            br.close();
            pw.close();
        } catch (IOException e) {
            System.err.println("El argumento introducido es incorrecto");
        }

    }
}
