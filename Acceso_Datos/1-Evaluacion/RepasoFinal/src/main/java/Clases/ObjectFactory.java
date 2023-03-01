
package Clases;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


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

    private final static QName _Hoteles_QNAME = new QName("", "hoteles");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Clases
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HotelesType }
     * 
     */
    public HotelesType createHotelesType() {
        return new HotelesType();
    }

    /**
     * Create an instance of {@link DireccionType }
     * 
     */
    public DireccionType createDireccionType() {
        return new DireccionType();
    }

    /**
     * Create an instance of {@link HotelType }
     * 
     */
    public HotelType createHotelType() {
        return new HotelType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HotelesType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HotelesType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "hoteles")
    public JAXBElement<HotelesType> createHoteles(HotelesType value) {
        return new JAXBElement<HotelesType>(_Hoteles_QNAME, HotelesType.class, null, value);
    }

}
