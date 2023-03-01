package tablas;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Fabricante {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Object id;
    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @OneToMany(mappedBy = "fabricanteByIdFabricante")
    private Collection<Producto> productosById;

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

    public Collection<Producto> getProductosById() {
        return productosById;
    }

    public void setProductosById(Collection<Producto> productosById) {
        this.productosById = productosById;
    }
}
