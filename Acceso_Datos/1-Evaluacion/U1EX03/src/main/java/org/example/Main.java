package org.example;

import javafx.scene.control.SelectionMode;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        Videojuego v1 = new Videojuego("Monopoly", "Marcos", "Juego de mesa objetivo ser el mas rico del juego","US");

        //creaDocumento(v1);
        eliminarNodo();
        leerDocumento();
    }

    private static void eliminarNodo() {}


    private static void leerDocumento() {
        try {
            File file = new File("videojuegos.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();
            System.out.println("Elemento raíz : " +document.getDocumentElement().getNodeName());
            NodeList nList = document.getElementsByTagName("videojuego");
            System.out.println("--------------------------------------");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                System.out.println("Elemento : " + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element) nNode;
                    System.out.println("Creado en : " +eElement.getAttribute("creado_en"));
                    System.out.println("Título : " +eElement.getElementsByTagName("titulo").item(0).getTextContent());
                    System.out.println("Creador : " +eElement.getElementsByTagName("creador").item(0).getTextContent());
                    System.out.println("Sinoposis : " +eElement.getElementsByTagName("sinopsis").item(0).getTextContent());
                    System.out.println("--------------------------------------------------------------------------------------");
                }
            }
        }catch (Exception e){
            System.err.println("El archivo no ha sido encontrado");
        }
    }

    private static void creaDocumento(Videojuego v1) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            //Elemento raíz
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("videojuegos");
            doc.appendChild(rootElement);
            //Primer elemento
            Element elemento1 = doc.createElement("videojuego");
            rootElement.appendChild(elemento1);
            //Se agrega un atributo al nodo elemento y su valor
            Attr attr = doc.createAttribute("creado_en");
            attr.setValue(v1.getCreado_en());
            elemento1.setAttributeNode(attr);

            Element titulo = doc.createElement("titulo");
            titulo.setTextContent(v1.getNombre());
            elemento1.appendChild(titulo);

            Element creador = doc.createElement("creador");
            creador.setTextContent(v1.getCreador());
            elemento1.appendChild(creador);

            Element sinopsis = doc.createElement("sinopsis");
            sinopsis.setTextContent(v1.getSinopsis());
            elemento1.appendChild(sinopsis);
            //Se escribe el contenido del XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("videojuegos.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
