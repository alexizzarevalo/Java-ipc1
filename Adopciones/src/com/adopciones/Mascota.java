package com.adopciones;

import java.io.Serializable;

// Mascota: edad, color, nombre, estaAdoptada, albergue, tipo
public class Mascota implements Serializable {

    public static String[] nameOfColumns = {
            "Id",
            "Albergue",
            "Color",
            "Edad",
            "Tipo",
            "Adoptada",
            "Nombre",
    };

    private int id;
    private int edad;
    private String color;
    private String nombre;
    private boolean estaAdoptada;
    private String albergue;
    private String tipo;

    public Mascota(int id, String tipo, String nombre, String color, int edad, String nombreAlbergue, String estaAdoptado) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.color = color;
        this.edad = edad;
        this.albergue = nombreAlbergue;

        this.estaAdoptada = estaAdoptado.toLowerCase() != "no";
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public Object[] getAsRow() {
        return new Object[]{
                this.id,
                this.albergue,
                this.color,
                this.edad,
                this.tipo,
                this.estaAdoptada,
                this.nombre,
        };
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

