import java.io.*;

public class Padre {
    public static void main(String[] args) throws IOException, InterruptedException {
        String buscar ="el_quijote.txt";
        String [] letras = {"a","o","e","i","u"};
        for (String letra : letras){
            String guardar  = letra + ".txt";
            String comando = "java Hijo.java " + letra +" "+ buscar + " " + guardar;
            ProcessBuilder pb = new ProcessBuilder("java", "Hijo.java");
            Process p = pb.start();
            p.waitFor();
        }
        for (String letra : letras){
            String resultado = letra + ",txt";
            String contenidoDelFichero = "";
            System.out.println("De la letra " + letra+ " Hijo dice: hay " + contenidoDelFichero);
            File fichero = new File(contenidoDelFichero);
            FileInputStream fis = new FileInputStream(fichero);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
        }
        System.out.println("De todas las letras que ");
    }
}
