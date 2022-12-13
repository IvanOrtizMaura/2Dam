package org.example;

import java.io.Serializable;

public class Videojuego implements Serializable {
    private String nombre, creador, sinopsis, creado_en;
    public Videojuego(String nombre, String creador, String sinopsis, String creado_en){
        this.nombre = nombre;
        this.creador = creador;
        this.sinopsis = sinopsis;
        this.creado_en = creado_en;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getCreado_en() {
        return creado_en;
    }

    public void setCreado_en(String creado_en) {
        this.creado_en = creado_en;
    }
}
