package com.adopciones;

import com.interfaz.Dashboard;
import com.google.gson.*;
import com.interfaz.IntefazGrafica;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        // Leer el contenido completo archivo
        //
        String contenidoArchivoJson = "[{\"Id\":5,\"tipo\":\"Gato\",\"nombre\":\"Cachetes\",\"color\":\"Gris\",\"edad\":2,\"albergue\":\"El milagro\",\"estaAdoptada\":true}]";

        Gson gson = new Gson();
        Mascota[] mascotas1 = gson.fromJson(contenidoArchivoJson, Mascota[].class);
        System.out.println();

        String json = new Gson().toJson(mascotas1);


//        JsonArray jsonArray = new JsonArray();
//        JsonObject jsonObject = new JsonObject();
//        jsonObject.add("id", new JsonPrimitive(5));
//        jsonObject.add("tipo", new JsonPrimitive("Gato"));
//        jsonObject.add("nombre", new JsonPrimitive("Cachetes"));
//        jsonObject.add("color", new JsonPrimitive("Gris"));
//        jsonObject.add("edad", new JsonPrimitive(2));
//        jsonObject.add("nombreAlbergue", new JsonPrimitive("El milagro"));
//        jsonObject.add("estaAdoptado", new JsonPrimitive("No"));
//        jsonArray.add(jsonObject);

//        System.out.println(jsonArray);
        Albergue[] albergues = {
                new Albergue(1, "El milagro", 20),
                new Albergue(2, "El milagro", 20)
        };

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
            int id = Integer.parseInt(atributos[6]);

            Mascota mascota = new Mascota(id, tipo, nombre, color, edad, nombreAlbergue, estaAdoptado);
            //            albegue.recibirMascota(mascota);
            mascotas[i - 1] = mascota;
        }

        String contentAsig = Archivos.readFile("C:\\Users\\dalex\\Downloads\\Ejemplo\\asignarAlbergue.txt");
        String[] lineasAsig = contentAsig.split("\n");
        for (int i = 1; i < lineasAsig.length; i++) {
            String[] atributos = lineasAsig[i].split(",");

            int idAlbergue = Integer.parseInt(atributos[0].trim());
            int idMascota = Integer.parseInt(atributos[1].trim());

            asignarMascotaAlAlbergue(albergues, mascotas, idAlbergue, idMascota);
            System.out.println();
        }

        Object[][] datosMascotas = new Object[mascotas.length][];
        for (int i = 0; i < mascotas.length; i++) {
            datosMascotas[i] = mascotas[i].getAsRow();
        }
        System.out.println();


        IntefazGrafica ventana = new IntefazGrafica(datosMascotas, Mascota.nameOfColumns);
        ventana.setVisible(true);







//        Dashboard dashboard = new Dashboard(datosMascotas, Mascota.nameOfColumns);
//        dashboard.setVisible(true);
//        dashboard.dispose(); // Libera recursos de la ventana y sus hijos (setVisible(false) solo la oculta)
//        dashboard.setVisible(true);


        // Se serializa el arreglo de mascotas
        Archivos.serialize("C:\\Users\\dalex\\Downloads\\Ejemplo\\mascota_serializada.pok", mascotas);

        // Se deserializa el arreglos de mascotas
        Object objetoLeido = Archivos.deserialize("C:\\Users\\dalex\\Downloads\\Ejemplo\\mascota_serializada.pok");
        Mascota[] mascotasLeidas = (Mascota[]) objetoLeido;
        System.out.println(mascotasLeidas);
    }

    public static void asignarMascotaAlAlbergue(Albergue[] albergues, Mascota[] mascotas, int idAlbergue, int idMascota) {
        Albergue albergue = findAlbergueById(albergues, idAlbergue);
        Mascota mascota = findMascotaById(mascotas, idMascota);
        albergue.recibirMascota(mascota);
    }

    public static Albergue findAlbergueById(Albergue[] albergues, int idAlbergue) {
        for (int j = 0; j < albergues.length; j++) {
            Albergue albergue = albergues[j];
            if (albergue.id == idAlbergue) {
                return albergue;
            }
        }
        return null;
    }

    public static Mascota findMascotaById(Mascota[] mascotas, int idMascota) {
        for (int k = 0; k < mascotas.length; k++) {
            Mascota mascota = mascotas[k];
            if (mascota.getId() == idMascota) {
                return mascota;
            }
        }
        return null;
    }
}
