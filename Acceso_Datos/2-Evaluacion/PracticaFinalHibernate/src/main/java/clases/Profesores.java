package clases;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Profesores {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_profesor", nullable = false)
    private int idProfesor;
    @Basic
    @Column(name = "id_persona", nullable = true)
    private Integer idPersona;
    @Basic
    @Column(name = "id_departamento", nullable = true)
    private Integer idDepartamento;
    @ManyToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona",insertable = false,updatable = false)
    private Personas personasByIdPersona;
    @ManyToOne
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento", insertable = false,updatable = false)
    private Departamentos departamentosByIdDepartamento;

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesores that = (Profesores) o;
        return idProfesor == that.idProfesor && Objects.equals(idPersona, that.idPersona) && Objects.equals(idDepartamento, that.idDepartamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProfesor, idPersona, idDepartamento);
    }

    public Personas getPersonasByIdPersona() {
        return personasByIdPersona;
    }

    public void setPersonasByIdPersona(Personas personasByIdPersona) {
        this.personasByIdPersona = personasByIdPersona;
    }

    public Departamentos getDepartamentosByIdDepartamento() {
        return departamentosByIdDepartamento;
    }

    public void setDepartamentosByIdDepartamento(Departamentos departamentosByIdDepartamento) {
        this.departamentosByIdDepartamento = departamentosByIdDepartamento;
    }
}
