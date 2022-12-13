import java.io.*;

public class Main {
    public static void main(String[] args) {
        if (args.length !=3)  {
            System.out.println("Error: necesito 3 argumentos ");
            System.exit(-1);
        }
        String letra = args[0];
        if (letra.length() > 1){
            System.out.println("Error: solo puedo buscar una letra a la vez");
            System.exit(-1);
        }
        String buscar = args[1];
        String guardar = args[2];

        File fichero = new File(buscar);
        FileInputStream fis;
        try {
            fis = new FileInputStream(fichero);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String linea = br.readLine();
            while (linea != null){
                linea = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
            File res = new File(guardar);
            PrintWriter pw = new PrintWriter(res);
            pw.println(contador);
            pw.flush();
            System.out.println("Resultado guardado en ficher " + guardar);
           ;

        }catch (FileNotFoundException e){
            System.out.println("Error: No ha encontrado el fichero" + buscar );
            System.exit(-1);
        }catch (IOException e){
            System.err.println("Error: Error al cargar el fichero");
        }

    }
    public static int cuentaPalabras(String s){
        int conteoPalabras = 0;
        boolean palabra = false;
        int finDeLinea = s.length() -1;
        
        for (int i = 0; i<s.length(); i ++){
            if (Character.isLetter(s.charAt(i)) && i != finDeLinea){
                palabra = false;
            } else if (!Character.isLetter(s.charAt(i)) && i == finDeLinea) {
                conteoPalabras ++;
                palabra = false;
            } else if (Character.isLetter(s.charAt(i)) && i == finDeLinea) {
                conteoPalabras ++;
            }
        }
        return conteoPalabras;
    }
    public static  int cuentaLetras(String s){
        s = s.replaceAll("\\s","");
        char[] charArrays = s.toCharArray();
        int conteoLetras = charArrays.length;
        return conteoLetras;
    }
    public static int contarVocales(String s){
        int a = 0, e=0,i=0,o=0, u=0;
        int conteoLetras = (a+e+i+o+u);
        for (int z = 0; z < s.length(); z++){
            char actual = s.toLowerCase().charAt(i);
            switch (actual){
                case 'a':
                    a++;
                    break;
                case 'e':
                    e++;
                    break;
                case'i':
                    i++;
                    break;
                case 'o':
                    o++;
                    break;
                case'u':
                    u++;
                    break;
            }
        }
        return conteoLetras;
    }
}