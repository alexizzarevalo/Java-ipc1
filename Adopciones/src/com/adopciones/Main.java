package com.adopciones;

import com.interfaz.Dashboard;
import com.google.gson.*;
import com.interfaz.IntefazGrafica;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        // Leer el contenido completo archivo
        //
        String contenidoArchivoJson = Archivos.readFile("C:\\Users\\dalex\\Downloads\\Ejemplo\\mascotas.json");

        Gson gson = new Gson();
        Mascota[] arregloMascotas = gson.fromJson(contenidoArchivoJson, Mascota[].class);




        Document documento = new Document();
        FileOutputStream ficheroPdf = new FileOutputStream("C:\\Users\\dalex\\Downloads\\Ejemplo\\reporte.pdf");
        // Se asocia el documento al OutputStream y se indica que el espaciado entre
// lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
        PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);

// Se abre el documento.
        documento.open();

        documento.add(new Paragraph("Reporte de mascotas",
                FontFactory.getFont("arial",   // fuente
                        14,                            // tamaño
                        Font.BOLD,                   // estilo
                        BaseColor.BLACK)));             // color

        int numColumns = 7;
        PdfPTable tabla = new PdfPTable(numColumns);
        for (int i = 0; i < arregloMascotas.length; i++)
        {
            tabla.addCell(String.valueOf(arregloMascotas[i].getId()));
            tabla.addCell(String.valueOf(arregloMascotas[i].getNombre()));
            tabla.addCell(String.valueOf(arregloMascotas[i].getColor()));
            tabla.addCell(String.valueOf(arregloMascotas[i].getTipo()));
            tabla.addCell(String.valueOf(arregloMascotas[i].getAlbergue()));
            tabla.addCell(String.valueOf(arregloMascotas[i].getEdad()));
            tabla.addCell(String.valueOf(true));
        }
        documento.add(tabla);



        documento.close();
        //        Mascota[] mascotas1 = gson.fromJson(contenidoArchivoJson, Mascota[].class);
//        System.out.println();
//
//        String json = new Gson().toJson(mascotas1);


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
//        Albergue[] albergues = {
//                new Albergue(1, "El milagro", 20),
//                new Albergue(2, "El milagro", 20)
//        };

        /*
        String content = Archivos.readFile("C:\\Users\\dalex\\Downloads\\Ejemplo\\mascotas.csv");
        String[] lineas = content.split("\n");
        Mascota[] mascotas = new Mascota[lineas.length - 1];
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
        }*/
/*
        String contentAsig = Archivos.readFile("C:\\Users\\dalex\\Downloads\\Ejemplo\\asignarAlbergue.txt");
        String[] lineasAsig = contentAsig.split("\n");
        for (int i = 1; i < lineasAsig.length; i++) {
            String[] atributos = lineasAsig[i].split(",");

            int idAlbergue = Integer.parseInt(atributos[0].trim());
            int idMascota = Integer.parseInt(atributos[1].trim());

            asignarMascotaAlAlbergue(albergues, mascotas, idAlbergue, idMascota);
            System.out.println();
        }*/

        Object[][] datosMascotas = new Object[arregloMascotas.length][];
        for (int i = 0; i < arregloMascotas.length; i++) {
            datosMascotas[i] = arregloMascotas[i].getAsRow();
        }
        System.out.println();


        IntefazGrafica ventana = new IntefazGrafica(datosMascotas, Mascota.nameOfColumns);
        ventana.setVisible(true);







//        Dashboard dashboard = new Dashboard(datosMascotas, Mascota.nameOfColumns);
//        dashboard.setVisible(true);
//        dashboard.dispose(); // Libera recursos de la ventana y sus hijos (setVisible(false) solo la oculta)
//        dashboard.setVisible(true);


        // Se serializa el arreglo de mascotas
//        Archivos.serialize("C:\\Users\\dalex\\Downloads\\Ejemplo\\mascota_serializada.pok", mascotas);

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
