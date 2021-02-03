# Arreglos unidimensionales

- **Tambien llamados vectores**
- **Los índices inician en 0 hasta (n-1) donde n es el tamaño del arreglo.**

### Declaracion (Sin inicializacion)

```java
// Con los [] despues del tipo
int[] notas;
// Con los [] despues del nombre
int notas[];
```

### Formas de inicializar

#### En la misma declaración

```java
int[] edades = new int[20]; // Se inicializa en la misma declaracion
```

#### Declarar y luego inicializar

```java
int[] notas;       // Solo se declara el arreglo
notas = new int[5]; // Se inicializa el arreglo
```

#### Con valor null

```java
int[] notas = null;
```

#### Con una cantidad especifica de elementos y con valores por defecto

```java
int[] notas = new int[5]; //El valor por defecto de numeros es 0
// [0, 0, 0, 0, 0]
```

#### Inicializar de una vez con valores

```java
int[] notas = {50, 80, 90, 70, 100}; // El tamanio del arreglo es 5
```

### Llenar cada posicion una a una

```java
int[] notas = new int[5];
notas[0] = 50; //El primer indice es 0
notas[1] = 80;
notas[2] = 90;
notas[3] = 70;
notas[4] = 100; //El ultimo indice es (n - 1) = (5 - 1) = 4
```