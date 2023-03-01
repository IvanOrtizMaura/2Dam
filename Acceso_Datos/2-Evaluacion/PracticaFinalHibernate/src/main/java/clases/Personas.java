package clases;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Personas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_persona", nullable = false)
    private int idPersona;
    @Basic
    @Column(name = "nif", nullable = true, length = 10)
    private String nif;
    @Basic
    @Column(name = "nombre", nullable = true, length = 50)
    private String nombre;
    @Basic
    @Column(name = "primer_apellido", nullable = true, length = 50)
    private String primerApellido;
    @Basic
    @Column(name = "segundo_apellido", nullable = true, length = 50)
    private String segundoApellido;
    @Basic
    @Column(name = "fecha_nacimiento", nullable = true)
    private Date fechaNacimiento;
    @Basic
    @Column(name = "direccion", nullable = true, length = 100)
    private String direccion;
    @Basic
    @Column(name = "sexo", nullable = true, length = 1)
    private String sexo;
    @Basic
    @Column(name = "numero_telefono", nullable = true, length = 15)
    private String numeroTelefono;
    @OneToMany(mappedBy = "personasByIdPersona")
    private Collection<Profesores> profesoresByIdPersona;

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
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

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personas personas = (Personas) o;
        return idPersona == personas.idPersona && Objects.equals(nif, personas.nif) && Objects.equals(nombre, personas.nombre) && Objects.equals(primerApellido, personas.primerApellido) && Objects.equals(segundoApellido, personas.segundoApellido) && Objects.equals(fechaNacimiento, personas.fechaNacimiento) && Objects.equals(direccion, personas.direccion) && Objects.equals(sexo, personas.sexo) && Objects.equals(numeroTelefono, personas.numeroTelefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersona, nif, nombre, primerApellido, segundoApellido, fechaNacimiento, direccion, sexo, numeroTelefono);
    }

    public Collection<Profesores> getProfesoresByIdPersona() {
        return profesoresByIdPersona;
    }

    public void setProfesoresByIdPersona(Collection<Profesores> profesoresByIdPersona) {
        this.profesoresByIdPersona = profesoresByIdPersona;
    }
}
