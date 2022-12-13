
package Clases;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Clases package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Marca_QNAME = new QName("", "marca");
    private final static QName _Precio_QNAME = new QName("", "precio");
    private final static QName _Color_QNAME = new QName("", "color");
    private final static QName _Matricula_QNAME = new QName("", "matricula");
    private final static QName _Direccion_QNAME = new QName("", "direccion");
    private final static QName _Telefono_QNAME = new QName("", "telefono");
    private final static QName _Nombre_QNAME = new QName("", "nombre");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Clases
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Coche }
     * 
     */
    public Coche createCoche() {
        return new Coche();
    }

    /**
     * Create an instance of {@link Concesionario }
     * 
     */
    public Concesionario createConcesionario() {
        return new Concesionario();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "marca")
    public JAXBElement<String> createMarca(String value) {
        return new JAXBElement<String>(_Marca_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "precio")
    public JAXBElement<Integer> createPrecio(Integer value) {
        return new JAXBElement<Integer>(_Precio_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "color")
    public JAXBElement<String> createColor(String value) {
        return new JAXBElement<String>(_Color_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "matricula")
    public JAXBElement<String> createMatricula(String value) {
        return new JAXBElement<String>(_Matricula_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "direccion")
    public JAXBElement<String> createDireccion(String value) {
        return new JAXBElement<String>(_Direccion_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "telefono")
    public JAXBElement<Integer> createTelefono(Integer value) {
        return new JAXBElement<Integer>(_Telefono_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "nombre")
    public JAXBElement<String> createNombre(String value) {
        return new JAXBElement<String>(_Nombre_QNAME, String.class, null, value);
    }

}
