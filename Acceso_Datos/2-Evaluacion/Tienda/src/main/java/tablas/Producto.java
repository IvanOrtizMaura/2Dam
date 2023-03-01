package tablas;

import jakarta.persistence.*;

@Entity
public class Producto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Object id;
    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Basic
    @Column(name = "precio", nullable = false, precision = 0)
    private double precio;
    @Basic
    @Column(name = "id_fabricante", nullable = false)
    private Object idFabricante;
    @ManyToOne
    @JoinColumn(name = "id_fabricante", referencedColumnName = "id", nullable = false)
    private Fabricante fabricanteByIdFabricante;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Object getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Object idFabricante) {
        this.idFabricante = idFabricante;
    }

    public Fabricante getFabricanteByIdFabricante() {
        return fabricanteByIdFabricante;
    }

    public void setFabricanteByIdFabricante(Fabricante fabricanteByIdFabricante) {
        this.fabricanteByIdFabricante = fabricanteByIdFabricante;
    }
}
