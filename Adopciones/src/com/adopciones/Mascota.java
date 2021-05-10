package com.adopciones;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

// Mascota: edad, color, nombre, estaAdoptada, albergue, tipo
public class Mascota implements Serializable {

    public static String[] nameOfColumns = {
            "Id",
            "Mas info",
            "Nombre",
            "Color",
            "Edad",
            "Tipo",
            "Adoptada",
            "Albergue",
    };

    @Expose()
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
        if (this.nombre == null) {
            return "";
        }
        return nombre;
    }

    public int getId() {
        return id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isEstaAdoptada() {
        return estaAdoptada;
    }

    public void setEstaAdoptada(boolean estaAdoptada) {
        this.estaAdoptada = estaAdoptada;
    }

    public String getAlbergue() {
        return albergue;
    }

    public void setAlbergue(String albergue) {
        this.albergue = albergue;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Object[] getAsRow() {
        return new Object[]{
                this.id,
                "Ver mas informacion",
                this.nombre,
                this.color,
                this.edad,
                this.tipo,
                this.estaAdoptada,
                this.albergue,
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

