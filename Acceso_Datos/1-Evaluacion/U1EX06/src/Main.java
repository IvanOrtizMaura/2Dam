import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class Main {
    static XPathExpression exp;
   static Document XMLDoc;
    static XPath xpath;
    public static void main(String[] args) {
        abrirFileDom();
        //Sacar el nombre de un trabajador a partir de su ID.
        //ejecutarXPath("/Trabajadores/Trabajador[@id = '1']/nombre");

        //Sacar el listado de trabajadores mayores de 30 años.
        //ejecutarXPath("/Trabajadores/Trabajador[./edad>30]/nombre");

        //Sacar el listado de las trabajadoras que hay en la empresa.
        //ejecutarXPath("/Trabajadores/Trabajador[./genero='Mujer']/nombre");

        //Sacar el listado de los trabajadores que tienen como rol  “Java Developer;
        ejecutarXPath("/Trabajadores/Trabajador[./rol='Java Developer']/nombre");

    }

    private static void abrirFileDom() {
        try {
            xpath = XPathFactory.newInstance().newXPath();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            XMLDoc = db.parse(new InputSource(new FileInputStream("src/trabajadores.xml")));
        } catch (Exception e) {
            System.err.println("Error: Error al leer el documento");
            throw new RuntimeException(e);
        }
    }

    private static void ejecutarXPath(String ruta) {
        String salida = "";
        try {
            exp = xpath.compile(ruta);
            Object result = exp.evaluate(XMLDoc, XPathConstants.NODESET);
            NodeList nl = (NodeList) result;
            for (int i = 0; i < nl.getLength(); i ++){
                salida = salida + "\n"+ nl.item(i).getChildNodes().item(0).getNodeValue();
            }
            System.out.println(salida);

        } catch (XPathExpressionException e) {
            System.err.println("Error al compilar la consulta");
            throw new RuntimeException(e);
        }
    }
}