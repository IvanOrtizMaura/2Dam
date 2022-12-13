import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("Se necesitan introducir argumentos");
            System.exit(-1);
        }
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce texto: ");
        String cadena = sc.nextLine();

        if (Objects.equals(cadena, "")){
            System.out.println("Error: Tienes que introducir texto");
            System.exit(-1);
        }
        try{
            Process p = new ProcessBuilder(args).start();

            OutputStream os = p.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            PrintWriter pw = new PrintWriter(osw);

            // Imprimes la cadena
            pw.print(cadena);
            // cierras el printwriter
            pw.close();

            // iniciar el imputstram para leer los datos de la salida del hijo
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String texto = br.readLine();
            System.out.println(texto);

            br.close();
            sc.close();
            // CONYROL DE ERRORES
        } catch (IOException e) {
            System.err.println("Error: Error al leer el proceso");
        }
    }
}