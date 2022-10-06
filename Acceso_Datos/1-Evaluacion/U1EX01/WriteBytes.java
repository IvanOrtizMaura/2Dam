import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBytes {
    public static void main(String[] args) {
        int i;
        try {
            FileOutputStream fout = new FileOutputStream("archivo3.txt");
            String st = "Hola-Mundo!";

            char ch[] = st.toCharArray();
            for (i = 0; i < st.length(); i++) {
                fout.write(ch[i]);
            }
            fout.close();
        } catch (IOException e){
            System.out.println("Error");
        }
    }
}
