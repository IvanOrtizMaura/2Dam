import java.util.Sacnner;
import java.io.*;
public class U1EX02 {
    private static final Scanner sc = new Scaner(System.in)
    private static String ruta;
    public String texto

    publiv static void main(String[] args) throws IOException {
        pedirTexto();
        writeFile();
        readFile();
    }
    public static void pedirTexto(){
        
    }
    private static void readFile(){
        int a;
        try {
            FileReader fr = new FileReader(ruta);
            BufferReader entrada = new BufferReader(fr);
            while((a = entrada.read())!= -1){
                if(a > 64 && a < 91){
                    a += 32;
                }else if (a >96&& a<123 ){
                    a -=32;
                }
                System.out.print((char)a);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    private static void writeFile() throws IOException{
        String cadena;
        System.out.println("Escribe la ruta del fichero ")
        ruta = sc..nextLine();
        try{
            PrintWrite salida = new
        }
    }

}