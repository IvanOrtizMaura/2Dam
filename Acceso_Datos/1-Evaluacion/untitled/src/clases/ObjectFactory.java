
package clases;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the clases package. 
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

    private final static QName _Libro_QNAME = new QName("", "libro");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clases
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LibroType }
     * 
     */
    public LibroType createLibroType() {
        return new LibroType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LibroType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "libro")
    public JAXBElement<LibroType> createLibro(LibroType value) {
        return new JAXBElement<LibroType>(_Libro_QNAME, LibroType.class, null, value);
    }

}
