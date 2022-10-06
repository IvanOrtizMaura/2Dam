import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Process p = Runtime.getRuntime().exec("notepad.exe");
        try{
            int procesoHijo = p.waitFor();
            if (procesoHijo == 1 ){
                System.out.println("Error!!");
            }else{
                System.out.println("Correcto");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}