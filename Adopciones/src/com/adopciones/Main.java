package com.adopciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

    public static String getContentOfFile(String pathname) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(pathname);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String content = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                content += linea + "\n";
            }
            return content;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        /*

        - Mascota: edad, color, nombre, estaAdoptada, albergue, tipo
        - Albergue: nombre, capacidad (recibirMascota, entregarMascota)
        - Persona: nombre, direccion (adoptarMascota, entregarMascota)




        Podemos crear albergues de animales. Cada albergue
        tendra un nombre y un limite de animales a albergar.
        Un animal podra ser adoptado por una persona.

        Se tiene un archivo de albergues con su capacidad (Se carga al iniciar el programa)

            albergues.csv
                nombre, capacidad
                El milagro, 5
                Otro, 10

        Se tiene un archivo de mascotas (Se carga al iniciar el programa):

            mascotas.csv
                tipo, nombre, color, edad, albergue, adoptado
                Gato, Cachetes, gris, 5, El milagro, No
                Conejo, Pelusa, blanco, 5, El milagro, Si

        - Opcion adoptar:
            - Mostrar una lista de mascotas no adoptadas
            - Elegir una por el nombre
            - Escribir el nombre de quien lo adopta

        - Opcion albergar:
            - Se recibe la mascota: tipo, nombre, color, edad
            - Se selecciona automaticamente el albergue que tenga menos animales.


        Se necesita registrar un log en un .CSV:
            - Cuando un animal es albergado (Nombre del albergue, nombre del animal, fecha y hora)
            - Cuando un animal es adoptado (Nombre de la persona, nombre de la mascota, fecha y hora)

        //log_adopciones.txt
        Adoptante,Mascota,Fecha
        Darwin,Chispas,17/02/2021
        Alison,Cachetes,17/02/2021

        //log_albergados.txt
        Albergue,Animal,Fecha
        El Milagro,Cachetes,10/02/2021
        El Milagro,Chispas,15/02/2021
        */
        String prueba = "         Pelusa  ";
        prueba = prueba.trim();
        Albergue albegue = new Albergue("El milagro", 20);
        String content = getContentOfFile("C:\\Users\\dalex\\Downloads\\Ejemplo\\mascotas.csv");
        String[] lineas = content.split("\n");

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
        }

        System.out.println("");


    }
}
