import java.io.*;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static String ruta;
    public static void main(String[] args) {
        writeFile();
        readFile();
    }

    private static void readFile() {
        int a;
        try {
            FileReader fout = new FileReader(ruta);
            BufferedReader entrada = new BufferedReader(fout);
            while((a = entrada.read()) != -1){
                if (a > 64 && a < 91){
                    a += 32;
                }else if(a > 96 && a < 123 ){
                    a -= 32;
                }
                System.out.println((char) a);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void writeFile() {
        String cadena;
        System.out.println("Escribe la ruta del archivo");
        ruta =sc.nextLine();
        try(PrintWriter salida = new PrintWriter(new FileWriter(ruta))){
            System.out.println("Introduce texto. Para terminar escribe FIN ");
            cadena = sc.nextLine();
            while (!cadena.equalsIgnoreCase("FIN")){
                salida.append(cadena);
                cadena = sc.next();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}