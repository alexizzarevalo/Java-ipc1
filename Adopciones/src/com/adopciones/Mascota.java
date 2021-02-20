package com.adopciones;

// Mascota: edad, color, nombre, estaAdoptada, albergue, tipo
public class Mascota {
    int edad;
    String color;
    String nombre;
    boolean estaAdoptada;
    String albergue;
    String tipo;

    public Mascota(String tipo, String nombre, String color, int edad, String nombreAlbergue, String estaAdoptado) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.color = color;
        this.edad = edad;
        this.albergue = nombreAlbergue;

        this.estaAdoptada = estaAdoptado.toLowerCase() != "no";
    }
}

