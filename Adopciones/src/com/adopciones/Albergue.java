package com.adopciones;

// Albergue: nombre, capacidad (recibirMascota, entregarMascota)
public class Albergue {
    String nombre;
    int capacidad;
    Mascota[] arrayMascota;

    public Albergue(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        arrayMascota = new Mascota[this.capacidad];
        System.out.println("Instanciando albergue. " + nombre + " con capacidad: " + capacidad);
    }

    public boolean recibirMascota(Mascota mascota) {
        // Retorna verdadero si se recibio la mascota
        for (int i = 0; i < arrayMascota.length; i++) {
            if (arrayMascota[i] == null) {
                arrayMascota[i] = mascota;
                return true;
            }
        }

        return false;
    }


    public Mascota entregarMascota(String nombre) {
        for (int i = 0; i < arrayMascota.length; i++) {
            Mascota mascota = arrayMascota[i];
            if (mascota.nombre == nombre) {
                arrayMascota[i] = null;
                return mascota;
            }
        }

        return null;
    }

}
