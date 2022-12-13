package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Hello Iván");
        System.exit(-1);
    }
}
class Persona{
    private String nombrePersona;
    private String apellidosPersona;
    private int edadPersona;
    private String direccionPersona;
    private String telefonoPersona;

    public Persona(){}

    public Persona (String nombrePersona, String apellidosPersona, int edadPersona, String direccionPersona, String telefonoPersona){
        this.nombrePersona = nombrePersona;
        this.apellidosPersona = apellidosPersona;
        this.edadPersona = edadPersona;
        this.direccionPersona = direccionPersona;
        this.telefonoPersona = telefonoPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidosPersona() {
        return apellidosPersona;
    }

    public void setApellidosPersona(String apellidosPersona) {
        this.apellidosPersona = apellidosPersona;
    }

    public int getEdadPersona() {
        return edadPersona;
    }

    public void setEdadPersona(int edadPersona) {
        this.edadPersona = edadPersona;
    }

    public String getDireccionPersona() {
        return direccionPersona;
    }

    public void setDireccionPersona(String direccionPersona) {
        this.direccionPersona = direccionPersona;
    }

    public String getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(String telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombrePersona='" + nombrePersona + '\'' +
                ", apellidosPersona='" + apellidosPersona + '\'' +
                ", edadPersona=" + edadPersona +
                ", direccionPersona='" + direccionPersona + '\'' +
                ", telefonoPersona='" + telefonoPersona + '\'' +
                '}';
    }
}

class Pelicula{
    private String tituloPelicula, nombreDirector, productora;
    private int numEjemplares, duracion,año;
    public Pelicula (){}
    public Pelicula(String tituloPelicula, String nombreDirector, int numEjemplares, String productora, int duracion, int año){
        this.tituloPelicula = tituloPelicula;
        this.nombreDirector = nombreDirector;
        this.numEjemplares = numEjemplares;
        this.productora = productora;
        this.duracion = duracion;
        this.año = año;
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
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
                "tituloPelicula='" + tituloPelicula + '\'' +
                ", nombreDirector='" + nombreDirector + '\'' +
                ", productora='" + productora + '\'' +
                ", numEjemplares=" + numEjemplares +
                ", duracion=" + duracion +
                ", año=" + año +
                '}';
    }
}

class Prestamo{
    private Pelicula pelicula;
    private Persona persona;
    private Boolean devuleto;
    private LocalDate fechaInicioPrestamo, fechaFinPrestamo;

}