import java.io.FileInputStream;
import java.io.IOException;

public class ReadBytes {
    public static void main(String[] args) {
        int i = 1;
        try {
            FileInputStream fout = new FileInputStream("archivo4.txt");

            while(i != -1) {
                System.out.println((char)i);
                i = fout.read();
            }
            fout.close();
        } catch (IOException e){
            System.out.println("Error");
        }
    }
}
