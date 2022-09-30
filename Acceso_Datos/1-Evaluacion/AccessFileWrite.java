import java.io.IOException;
import java.io.RandomAccessFile;

public class AccessFileWrite {
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("archivo3.txt", "re");
            raf.seek(2);
            raf.write("Patata".getBytes());
            raf.close();
        } catch (IOException e){
            System.out.println("Error");
        }

    }
}
