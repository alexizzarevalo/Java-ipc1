package com.adopciones;

import java.io.Serializable;

// Mascota: edad, color, nombre, estaAdoptada, albergue, tipo
public class Mascota implements Serializable {
    int id;
    int edad;
    String color;
    String nombre;
    boolean estaAdoptada;
    String albergue;
    String tipo;

    public Mascota(int id, String tipo, String nombre, String color, int edad, String nombreAlbergue, String estaAdoptado) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.color = color;
        this.edad = edad;
        this.albergue = nombreAlbergue;

        this.estaAdoptada = estaAdoptado.toLowerCase() != "no";
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "edad=" + edad +
                ", color='" + color + '\'' +
                ", nombre='" + nombre + '\'' +
                ", estaAdoptada=" + estaAdoptada +
                ", albergue='" + albergue + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}

