package com.adopciones;

public class Main {

    public static void main(String[] args) {
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
            if (mascota.id == idMascota) {
                return mascota;
            }
        }
        return null;
    }
}
