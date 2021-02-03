# Arreglos multidimensionales

- **Tambien llamados matrices**
- **Los índices de cada dimension inician en 0 hasta (n-1) donde n es el tamaño de la dimension.**
- **VECTORES DE VECTORES**

### Declaracion (Sin inicializacion)

```java
// Con los [][] despues del tipo
int[][] notas;
// Con los [][] despues del nombre
int notas[][];
```

### Formas de inicializar

#### En la misma declaración

```java
int[][] edades = new int[4][5]; // Se inicializa en la misma declaracion
```

#### Declarar y luego inicializar

```java
int[][] notas;       // Solo se declara la matriz
notas = new int[4][5]; // Se inicializa la matriz
```

#### Con valor null

```java
int[][] notas = null;
```

#### Con una cantidad especifica de elementos y con valores por defecto

```java
int[][] notas = new int[4][5]; //El valor por defecto de numeros es 0
// [0, 0, 0, 0, 0]
// [0, 0, 0, 0, 0]
// [0, 0, 0, 0, 0]
// [0, 0, 0, 0, 0]
```

#### Inicializar de una vez con valores

```java
int[][] notas = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}};
// Dimensiones: 4 filas * 5 columnas
```

### Llenar cada posicion una a una

```java
int[][] notas = new int[2][2];
notas[0][0] = 100; //El primer indice es 0
notas[0][1] = 80; 
notas[1][0] = 50; 
notas[1][1] = 70;
/*
100  80
 50  70
*/
```