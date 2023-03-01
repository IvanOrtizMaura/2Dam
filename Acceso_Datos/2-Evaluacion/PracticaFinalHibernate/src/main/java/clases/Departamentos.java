package clases;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Departamentos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_departamento", nullable = false)
    private int idDepartamento;
    @Basic
    @Column(name = "nombre_departamento", nullable = true, length = 50)
    private String nombreDepartamento;
    @OneToMany(mappedBy = "departamentosByIdDepartamento")
    private Collection<Profesores> profesoresByIdDepartamento;

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamentos that = (Departamentos) o;
        return idDepartamento == that.idDepartamento && Objects.equals(nombreDepartamento, that.nombreDepartamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDepartamento, nombreDepartamento);
    }

    public Collection<Profesores> getProfesoresByIdDepartamento() {
        return profesoresByIdDepartamento;
    }

    public void setProfesoresByIdDepartamento(Collection<Profesores> profesoresByIdDepartamento) {
        this.profesoresByIdDepartamento = profesoresByIdDepartamento;
    }
}
