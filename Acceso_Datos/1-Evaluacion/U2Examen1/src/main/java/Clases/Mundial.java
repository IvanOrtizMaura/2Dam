
package Clases;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}titulo"/>
 *         &lt;element ref="{}ubicacion"/>
 *         &lt;element ref="{}edicion"/>
 *         &lt;element ref="{}total_selecciones"/>
 *         &lt;element ref="{}pais" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "titulo",
    "ubicacion",
    "edicion",
    "totalSelecciones",
    "pais"
})
@XmlRootElement(name = "mundial")
public class Mundial {

    @XmlElement(required = true)
    protected String titulo;
    @XmlElement(required = true)
    protected String ubicacion;
    @XmlElement(required = true)
    protected String edicion;
    @XmlElement(name = "total_selecciones", required = true)
    protected String totalSelecciones;
    protected List<Pais> pais;

    /**
     * Obtiene el valor de la propiedad titulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define el valor de la propiedad titulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitulo(String value) {
        this.titulo = value;
    }

    /**
     * Obtiene el valor de la propiedad ubicacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Define el valor de la propiedad ubicacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUbicacion(String value) {
        this.ubicacion = value;
    }

    /**
     * Obtiene el valor de la propiedad edicion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEdicion() {
        return edicion;
    }

    /**
     * Define el valor de la propiedad edicion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEdicion(String value) {
        this.edicion = value;
    }

    /**
     * Obtiene el valor de la propiedad totalSelecciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalSelecciones() {
        return totalSelecciones;
    }

    /**
     * Define el valor de la propiedad totalSelecciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalSelecciones(String value) {
        this.totalSelecciones = value;
    }

    /**
     * Gets the value of the pais property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pais property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPais().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Pais }
     * 
     * 
     */
    public List<Pais> getPais() {
        if (pais == null) {
            pais = new ArrayList<Pais>();
        }
        return this.pais;
    }

}
