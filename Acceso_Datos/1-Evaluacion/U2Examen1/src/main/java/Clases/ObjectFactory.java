
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

    private final static QName _TotalSelecciones_QNAME = new QName("", "total_selecciones");
    private final static QName _Ubicacion_QNAME = new QName("", "ubicacion");
    private final static QName _Entrenador_QNAME = new QName("", "entrenador");
    private final static QName _Equipo_QNAME = new QName("", "equipo");
    private final static QName _Titulo_QNAME = new QName("", "titulo");
    private final static QName _Ranking_QNAME = new QName("", "ranking");
    private final static QName _Region_QNAME = new QName("", "region");
    private final static QName _Edicion_QNAME = new QName("", "edicion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Clases
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Mundial }
     * 
     */
    public Mundial createMundial() {
        return new Mundial();
    }

    /**
     * Create an instance of {@link Pais }
     * 
     */
    public Pais createPais() {
        return new Pais();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "total_selecciones")
    public JAXBElement<String> createTotalSelecciones(String value) {
        return new JAXBElement<String>(_TotalSelecciones_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ubicacion")
    public JAXBElement<String> createUbicacion(String value) {
        return new JAXBElement<String>(_Ubicacion_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "entrenador")
    public JAXBElement<String> createEntrenador(String value) {
        return new JAXBElement<String>(_Entrenador_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "equipo")
    public JAXBElement<String> createEquipo(String value) {
        return new JAXBElement<String>(_Equipo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "titulo")
    public JAXBElement<String> createTitulo(String value) {
        return new JAXBElement<String>(_Titulo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ranking")
    public JAXBElement<String> createRanking(String value) {
        return new JAXBElement<String>(_Ranking_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "region")
    public JAXBElement<String> createRegion(String value) {
        return new JAXBElement<String>(_Region_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "edicion")
    public JAXBElement<String> createEdicion(String value) {
        return new JAXBElement<String>(_Edicion_QNAME, String.class, null, value);
    }

}
