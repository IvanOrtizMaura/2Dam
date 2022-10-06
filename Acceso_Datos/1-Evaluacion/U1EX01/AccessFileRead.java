import java.io.IOException;
import java.io.RandomAccessFile;

public class AccessFileRead {
    public static void main(String[] args) {
        try {
        RandomAccessFile raf = new RandomAccessFile("archivo1.txt", "r");
        raf.seek(2);
        byte[] bytes = new byte[4];
        raf.read(bytes);
        raf.close();
            System.out.println(new String (bytes));
        } catch (IOException e){
            System.out.println("Error!!");
        }
    }
}
