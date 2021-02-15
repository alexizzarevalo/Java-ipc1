```java
package com.ipc1;

public class Main {

    static class Computadora {
        // Atributos o Estado
        String tipoProcesdor;
        protected int RAM; // en GB
        String color;
        int disco; // en GB
        double tamanioMonitor; // En pulgadas

        // Constructor, se llama cuando se instancia la clase. Puede incluir 0 o más parametros
        public Computadora() {
            System.out.println("Instanciando");
        }

        // Constructor con parametros.
        public Computadora(String color) {
            System.out.println("Instanciando");
            this.color = color; // Le asigno el valor del parametro al atributo de la clase
        }

        // Comportamiento o acciones
        private boolean encender() {
            System.out.println("Encendiendo");
            System.out.println("Ir al circuito y mandarle señal");
            return true;
        }

        public void apagar() {
            System.out.println("Apagando...");
        }
    }

    static class Dell extends Computadora { // La clase Dell hereda los atributos y comportamiento de Computadora
        int garantia; // Ademas, tiene garantia
    }

    public static void main(String[] args) {
	    //Instanciar la clase Computadora
        Computadora micompu = new Computadora(); // Se llama el constructor sin parametros
        micompu.color = "Negra";
        micompu.disco = 500;
        micompu.RAM = 8;

        Computadora otracompu = new Computadora("Gris"); // Se llama el constructor con un parametro
        otracompu.RAM = 16;
        otracompu.disco = 1000;

        micompu.encender();
        otracompu.encender();

        Computadora miotracompu = micompu; // Se copia la referencia de micompu a miotracompu

        Dell dell = new Dell(); // Se crea una Dell que a su vez es una Computadora (Por herencia)
        dell.garantia = 2;

        // Se puede declarar usando como tipo la clase padre (Computadora), pero
        // ya no podra acceder a garantia (Que solo existe en la clase Dell)
        Computadora compu2 = new Dell();
    }
}

```