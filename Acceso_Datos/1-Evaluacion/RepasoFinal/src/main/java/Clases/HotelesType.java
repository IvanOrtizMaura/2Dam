
package Clases;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para hotelesType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="hotelesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="empresa" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fundacion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ciudad_sede" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="pais_sede" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="hotel" type="{}hotelType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hotelesType", propOrder = {
    "empresa",
    "fundacion",
    "ciudadSede",
    "paisSede",
    "hotel"
})
public class HotelesType {

    @XmlElement(required = true)
    protected String empresa;
    @XmlElement(required = true)
    protected String fundacion;
    @XmlElement(name = "ciudad_sede", required = true)
    protected String ciudadSede;
    @XmlElement(name = "pais_sede", required = true)
    protected String paisSede;
    protected List<HotelType> hotel;

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
     * returned list will be present inside the Jakarta XML Binding object.
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
     * {@link HotelType }
     * 
     * 
     */
    public List<HotelType> getHotel() {
        if (hotel == null) {
            hotel = new ArrayList<HotelType>();
        }
        return this.hotel;
    }

}
