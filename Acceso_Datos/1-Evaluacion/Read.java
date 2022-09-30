import java.io.FileReader;
import java.io.IOException;

public class Read {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("archivo3.txt");
            int valor = fr.read();
            while(valor != -1){
                System.out.println((char)valor);
                valor = fr.read();
            }
            fr.close();
        } catch (IOException e){
            System.out.println("Error");
        }
    }
}
