import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)  {
        //Comprueba que se han introducido los argumentos necesarios
        if (args.length == 0) {
            System.out.println("Se necesitan introducir argumentos");
            System.exit(-1);
        }
        //Creamos el proceso con la consola de comandos (cmd)
        ProcessBuilder pb = new ProcessBuilder("cmd.exe" ,"/c", args[0]);
        try {
            //Encendemos el proceso
            Process p = pb.start();
            //Creamos el InputStream para coger la informacion del proceso hijo
            InputStream is = p.getInputStream();
            //Creamos el InputStreamReader para poder leer lo que nos ha pasado el proceso hijo
            InputStreamReader isr = new InputStreamReader(is);

            BufferedReader br = new BufferedReader(isr);
            String txt = "";
            String linea;
            //Hacemos un bucle para leer linea por liena hasta que no haya ninguna linea
            //Por cada linea imprimimos lo que cogemos
            while(!((linea = br.readLine()) == null)){
                txt += "\n" +"Hijo dice: "+ linea;
            }

            System.out.println(txt);
        } catch (IOException e) {
            System.err.println("Error: no se ha podido cargar el proceso");
            System.exit(-1);
        }

    }
}