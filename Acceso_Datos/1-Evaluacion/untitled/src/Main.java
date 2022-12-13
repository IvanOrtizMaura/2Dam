import clases.LibroType;

import javax.xml.bind.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        //escribir();
        //
        leer();
    }

    public static void escribir() {
        try {
            LibroType libro= new LibroType (400 ,"Odisea 2001");
            JAXBContext contexto = JAXBContext.newInstance(
                    libro.getClass() );
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            marshaller.marshal(libro, System.out);
            // escribir en un archivo
            marshaller.marshal(libro, new File("libros.xml"));
        } catch (PropertyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void leer() {

        try {
            JAXBContext context = JAXBContext.newInstance( LibroType.class );
            Unmarshaller unmarshaller = context.createUnmarshaller();
            LibroType libro = (LibroType) unmarshaller.unmarshal(
                    new File("libros.xml") );

            System.out.println(libro.getTitulo());
            System.out.println(libro.getNumeroPaginas());

        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}