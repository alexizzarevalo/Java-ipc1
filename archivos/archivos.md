### Leer un archivo

```java
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
```

```java
//crea el archivo en disco, recibe como parámetro la lista de estudiantes
public static void createFile(String pathname) {
    FileWriter flwriter = null;
    try {
        //crea el flujo para escribir en el archivo
        flwriter = new FileWriter(pathname);
        //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
        BufferedWriter bfwriter = new BufferedWriter(flwriter);
        for (int i = 0; i < 10; i++) {
            // Escribe los datos en el archivo
            bfwriter.write("Linea " + (i + 1));
        }
        //cierra el buffer intermedio
        bfwriter.close();

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (flwriter != null) {
            try {//cierra el flujo principal
                flwriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

```java
public static void addToEndFile(String pathname, String data) {
    FileWriter flwriter = null;
    try {
        flwriter = new FileWriter(pathname, true); // True indica que se va a agregar datos al final
        BufferedWriter bfwriter = new BufferedWriter(flwriter);
        // Escribe los datos en el archivo
        bfwriter.write(data);
        bfwriter.close();

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (flwriter != null) {
            try {
                flwriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```