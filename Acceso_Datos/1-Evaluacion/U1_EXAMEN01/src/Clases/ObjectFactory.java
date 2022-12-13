
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

    private final static QName _CodigoPostal_QNAME = new QName("", "codigo_postal");
    private final static QName _Numero_QNAME = new QName("", "numero");
    private final static QName _Fundacion_QNAME = new QName("", "fundacion");
    private final static QName _CiudadSede_QNAME = new QName("", "ciudad_sede");
    private final static QName _Ciudad_QNAME = new QName("", "ciudad");
    private final static QName _Calle_QNAME = new QName("", "calle");
    private final static QName _PaisSede_QNAME = new QName("", "pais_sede");
    private final static QName _Empresa_QNAME = new QName("", "empresa");
    private final static QName _Telefono_QNAME = new QName("", "telefono");
    private final static QName _Nombre_QNAME = new QName("", "nombre");
    private final static QName _Estrellas_QNAME = new QName("", "estrellas");
    private final static QName _Pais_QNAME = new QName("", "pais");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Clases
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Hoteles }
     * 
     */
    public Hoteles createHoteles() {
        return new Hoteles();
    }

    /**
     * Create an instance of {@link Hotel }
     * 
     */
    public Hotel createHotel() {
        return new Hotel();
    }

    /**
     * Create an instance of {@link Direccion }
     * 
     */
    public Direccion createDireccion() {
        return new Direccion();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codigo_postal")
    public JAXBElement<String> createCodigoPostal(String value) {
        return new JAXBElement<String>(_CodigoPostal_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "numero")
    public JAXBElement<String> createNumero(String value) {
        return new JAXBElement<String>(_Numero_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "fundacion")
    public JAXBElement<String> createFundacion(String value) {
        return new JAXBElement<String>(_Fundacion_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ciudad_sede")
    public JAXBElement<String> createCiudadSede(String value) {
        return new JAXBElement<String>(_CiudadSede_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ciudad")
    public JAXBElement<String> createCiudad(String value) {
        return new JAXBElement<String>(_Ciudad_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "calle")
    public JAXBElement<String> createCalle(String value) {
        return new JAXBElement<String>(_Calle_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pais_sede")
    public JAXBElement<String> createPaisSede(String value) {
        return new JAXBElement<String>(_PaisSede_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "empresa")
    public JAXBElement<String> createEmpresa(String value) {
        return new JAXBElement<String>(_Empresa_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "telefono")
    public JAXBElement<String> createTelefono(String value) {
        return new JAXBElement<String>(_Telefono_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "nombre")
    public JAXBElement<String> createNombre(String value) {
        return new JAXBElement<String>(_Nombre_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "estrellas")
    public JAXBElement<String> createEstrellas(String value) {
        return new JAXBElement<String>(_Estrellas_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pais")
    public JAXBElement<String> createPais(String value) {
        return new JAXBElement<String>(_Pais_QNAME, String.class, null, value);
    }

}
