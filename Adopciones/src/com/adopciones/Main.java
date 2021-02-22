package com.adopciones;

public class Main {

    public static void main(String[] args) {
        Albergue albegue = new Albergue("El milagro", 20);
        String content = Archivos.readFile("C:\\Users\\dalex\\Downloads\\Ejemplo\\mascotas.csv");
        String[] lineas = content.split("\n");
        Mascota[] mascotas = new Mascota[2];
        for (int i = 1; i < lineas.length; i++) {
            String[] atributos = lineas[i].split(",");

            String tipo = atributos[0];
            String nombre = atributos[1];
            String color = atributos[2];
            int edad = Integer.parseInt(atributos[3].trim());
            String nombreAlbergue = atributos[4];
            String estaAdoptado = atributos[5];

            Mascota mascota = new Mascota(tipo, nombre, color, edad, nombreAlbergue, estaAdoptado);
            albegue.recibirMascota(mascota);
            mascotas[i-1] = mascota;
        }
    }
}
