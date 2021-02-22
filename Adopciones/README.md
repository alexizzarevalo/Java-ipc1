## Adopciones de mascotas

Podemos crear albergues de animales. Cada albergue
tendra un **nombre** y un **limite de animales** a albergar.
Un animal podra ser adoptado por una persona.

Se tiene un archivo CSV de albergues con su capacidad (*Se carga al iniciar el programa*)

```text
nombre, capacidad
El milagro, 5
Otro albergue, 10
```

Se tiene un archivo CSV de mascotas (*Se carga al iniciar el programa*):

```text
tipo, nombre, color, edad, albergue, adoptado
Gato, Cachetes, gris, 5, El milagro, No
Conejo, Pelusa, blanco, 5, El milagro, Si
```
---

- Opcion adoptar:
    - Mostrar una lista de mascotas no adoptadas
    - Elegir una por el nombre
    - Escribir el nombre de quien lo adopta
    
---

- Opcion albergar:
    - Se recibe la mascota: tipo, nombre, color, edad
    - Se selecciona automaticamente el albergue que tenga menos animales.

---

Se necesita registrar un log en un CSV:

- **Cuando un animal es albergado**: (Nombre del albergue, nombre del animal, fecha y hora)
- **Cuando un animal es adoptado**: (Nombre de la persona, nombre de la mascota, fecha y hora)

Ejemplo de log_adopciones.csv

```text
Adoptante,Mascota,Fecha
Darwin,Chispas,17/02/2021
Alison,Cachetes,17/02/2021
```

Ejemplo de log_albergados.csv

```text
Albergue,Animal,Fecha
El Milagro,Cachetes,10/02/2021
El Milagro,Chispas,15/02/2021
```
