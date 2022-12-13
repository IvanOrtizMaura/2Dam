
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
 *         &lt;element ref="{}empresa"/>
 *         &lt;element ref="{}fundacion"/>
 *         &lt;element ref="{}ciudad_sede"/>
 *         &lt;element ref="{}pais_sede"/>
 *         &lt;element ref="{}hotel" maxOccurs="unbounded" minOccurs="0"/>
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
    "empresa",
    "fundacion",
    "ciudadSede",
    "paisSede",
    "hotel"
})
@XmlRootElement(name = "hoteles")
public class Hoteles {

    @XmlElement(required = true)
    protected String empresa;
    @XmlElement(required = true)
    protected String fundacion;
    @XmlElement(name = "ciudad_sede", required = true)
    protected String ciudadSede;
    @XmlElement(name = "pais_sede", required = true)
    protected String paisSede;
    protected List<Hotel> hotel;

    /**
     * Obtiene el valor de la propiedad empresa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Define el valor de la propiedad empresa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpresa(String value) {
        this.empresa = value;
    }

    /**
     * Obtiene el valor de la propiedad fundacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFundacion() {
        return fundacion;
    }

    /**
     * Define el valor de la propiedad fundacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFundacion(String value) {
        this.fundacion = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudadSede.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiudadSede() {
        return ciudadSede;
    }

    /**
     * Define el valor de la propiedad ciudadSede.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiudadSede(String value) {
        this.ciudadSede = value;
    }

    /**
     * Obtiene el valor de la propiedad paisSede.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaisSede() {
        return paisSede;
    }

    /**
     * Define el valor de la propiedad paisSede.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaisSede(String value) {
        this.paisSede = value;
    }

    /**
     * Gets the value of the hotel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hotel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHotel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Hotel }
     * 
     * 
     */
    public List<Hotel> getHotel() {
        if (hotel == null) {
            hotel = new ArrayList<Hotel>();
        }
        return this.hotel;
    }

}
