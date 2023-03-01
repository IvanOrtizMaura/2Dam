package modulos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Empleado {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codigo", nullable = false)
    private int codigo;
    @Basic
    @Column(name = "nif", nullable = false, length = 9)
    private String nif;
    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Basic
    @Column(name = "apellido1", nullable = false, length = 100)
    private String apellido1;
    @Basic
    @Column(name = "apellido2", nullable = true, length = 100)
    private String apellido2;
    @ManyToOne
    @JoinColumn(name = "codigo_departamento", referencedColumnName = "codigo")
    private Departamento departamentoByCodigoDepartamento;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return codigo == empleado.codigo && Objects.equals(nif, empleado.nif) && Objects.equals(nombre, empleado.nombre) && Objects.equals(apellido1, empleado.apellido1) && Objects.equals(apellido2, empleado.apellido2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nif, nombre, apellido1, apellido2);
    }

    public Departamento getDepartamentoByCodigoDepartamento() {
        return departamentoByCodigoDepartamento;
    }

    public void setDepartamentoByCodigoDepartamento(Departamento departamentoByCodigoDepartamento) {
        this.departamentoByCodigoDepartamento = departamentoByCodigoDepartamento;
    }
}
