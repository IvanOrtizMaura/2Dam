package org.example;

public class Persona {
    String nombre, apellidos, direccion,telefono;
    int edad;
    public Persona(){}

    public Persona(String nombre, String apellidos, String direccion, String telefono, int edad){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", edad=" + edad +
                '}';
    }
}
class Pelicula {
    String titulo, director, productora;
    int numEjemplares, duracion, año;

    public Pelicula() {
    }

    public Pelicula(String titulo, String director, String productora, int numEjemplares, int duracion, int año) {
        this.titulo = titulo;
        this.director = director;
        this.productora = productora;
        this.numEjemplares = numEjemplares;
        this.duracion = duracion;
        this.año = año;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProductora() {
        return productora;
    }

    public void setProductora(String productora) {
        this.productora = productora;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public void setNumEjemplares(int numEjemplares) {
        this.numEjemplares = numEjemplares;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", director='" + director + '\'' +
                ", productora='" + productora + '\'' +
                ", numEjemplares=" + numEjemplares +
                ", duracion=" + duracion +
                ", año=" + año +
                '}';
    }
}
class Prestamos{
    Pelicula pelicula;
    Persona persona;
    String devolucion,fechaInicio, fechaFin;

    public Prestamos(Pelicula pelicula, Persona persona, String devolucion, String fechaInicio, String fechaFin) {
        this.pelicula = pelicula;
        this.persona = persona;
        this.devolucion = devolucion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Prestamos() {

    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(String devolucion) {
        this.devolucion = devolucion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Prestamos{" +
                "pelicula=" + pelicula +
                ", persona=" + persona +
                ", devolucion='" + devolucion + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                '}';
    }
}
