import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author decodigo
 * https://decodigo.com/java-leer-xml-con-sax-parser
 */
public class Main2 {
    public static void main(String argv[]) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            // Se crea un objeto SAXParser para interpretar interpretar el documento documento XML.
            SAXParser saxParser = factory.newSAXParser();

            // handler que se encarga de leer y registrar partes específicas de nuestro XML
            // Es necesario aclarar que debemos conocer la estructura del archivo XML que estamos leyendo
            DefaultHandler handler = new DefaultHandler() {

                // elementos de interes en nuestro XML que registramos con la ayuda de variables booleanas
                ArrayList<Food> lista = new ArrayList<>();
                Food food;
                String auxiliarName;
                String auxiliarDescription;
                double auxiliarPrice;
                int auxiliarCalories;
                boolean bNombre = false;
                boolean bPrice = false;
                boolean bDescription = false;
                boolean bCalories = false;

                // Con la ayuda del método startElement registramos cada encuentro y cambiamos el valor de nuestras variables booleanas
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("name")) {
                        bNombre = true;
                    }
                    if (qName.equalsIgnoreCase("price")) {
                        bPrice = true;
                    }
                    if (qName.equalsIgnoreCase("description")) {
                        bDescription = true;
                    }
                    if (qName.equalsIgnoreCase("calories")){
                        bCalories = true;
                    }
                }
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("food")){
                        food = new Food(auxiliarName,auxiliarDescription, auxiliarPrice, auxiliarCalories);
                        lista.add(food);
                    }
                    if (qName.equalsIgnoreCase("breakfast_menu")){
                        for (Food i:lista) {
                            System.out.println("Nombre: " + i.getName());
                            System.out.println("Descripcion: " + i.getDescription());
                            System.out.println("Precio: " + i.getPrice());
                            System.out.println("Calories: " + i.getCalories());
                        }
                    }
                }

                // El método characters nos permitirá obtener la infromación contenida en la etiqueta de XML encontrada.
                // Después de hacer «algo» con la información encontrada (en nuestro caso sólo la imprimos en consola),
                // devolvemos al estado anterior al booleano que corresponde a la etiqueta del XML.
                public void characters(char ch[], int start, int length) throws SAXException {
                    if (bNombre) {
                        auxiliarName = new String(ch,start,length);
                        bNombre = false;
                    }
                    if (bPrice) {
                        auxiliarPrice = Double.parseDouble(new String(ch,start,length));
                        bPrice = false;
                    }
                    if (bDescription) {
                        auxiliarDescription = new String(ch,start,length);
                        bDescription = false;
                    }
                    if(bCalories){
                        auxiliarCalories = Integer.parseInt(new String(ch,start,length));
                        bCalories = false;
                    }
                }
            };
            File file = new File("breakfast_menu.xml");
            saxParser.parse(file, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}