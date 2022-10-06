import java.io.FileWriter;
import java.io.IOException;

public class Write {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("archivo5.txt");
            fw.write("Hola-Mundo!");
            fw.close();
            System.out.println("Se ha escrito correctamente");
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}