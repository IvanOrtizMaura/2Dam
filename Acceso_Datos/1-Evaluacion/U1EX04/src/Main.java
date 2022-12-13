import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class Main {
    public static void main(String[] args)  {
//        crearFichero();
        leerFichero();
    }
    public static void crearFichero()  {
        try {
            FileOutputStream ficheroCliente = new FileOutputStream("Clientes.dat");
            Cliente uno = new Cliente("Marcos", 2);
            Cliente dos = new Cliente ("Erick", 4);
            Cliente tres = new Cliente("Dani", 50);
            Cliente cuatro = new Cliente("Ivan", 20);
            Cliente cinco = new Cliente("Asier", 34);

            ObjectOutputStream objeto = new ObjectOutputStream(ficheroCliente);
            objeto.writeObject(uno);
            objeto.writeObject(dos);
            objeto.writeObject(tres);
            objeto.writeObject(cuatro);
            objeto.writeObject(cinco);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void leerFichero(){
        try {
            FileInputStream leer = new FileInputStream("Clientes.dat");
            ObjectInputStream objInput = new ObjectInputStream(leer);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element eRaiz = doc.createElement("Clientes");
            doc.appendChild(eRaiz);


            //while(true)
            int contador = 1;
            while(contador<6){
                Element eCliente = doc.createElement("Cliente");
                eRaiz.appendChild(eCliente);



                Cliente auxiliar = (Cliente) objInput.readObject();
                Element eNombre = doc.createElement("nombre");
                eCliente.appendChild(eNombre);
                eNombre.setTextContent(auxiliar.getNombre());

                Element eEdad = doc.createElement("edad");
                eCliente.appendChild(eEdad);
                eEdad.setTextContent(String.valueOf(auxiliar.getEdad()));


                contador++;
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("Clientes.xml"));
            transformer.transform(source,result);
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}