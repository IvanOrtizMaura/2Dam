package modulos;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Departamento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codigo", nullable = false)
    private int codigo;
    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Basic
    @Column(name = "presupuesto", nullable = false, precision = 0)
    private double presupuesto;
    @Basic
    @Column(name = "gastos", nullable = false, precision = 0)
    private double gastos;
    @OneToMany(mappedBy = "departamentoByCodigoDepartamento")
    private Collection<Empleado> empleadosByCodigo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return codigo == that.codigo && Double.compare(that.presupuesto, presupuesto) == 0 && Double.compare(that.gastos, gastos) == 0 && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, presupuesto, gastos);
    }

    public Collection<Empleado> getEmpleadosByCodigo() {
        return empleadosByCodigo;
    }

    public void setEmpleadosByCodigo(Collection<Empleado> empleadosByCodigo) {
        this.empleadosByCodigo = empleadosByCodigo;
    }
}
