```java
public static String generateHTMLForMat(double[][] mat) {
    String tabla = "<table>";
    for (int i = 0; i < mat.length; i++) {
        String row = "<tr>";
        for (int j = 0; j < mat[0].length; j++) {
            row += "<td>" + mat[i][j] + "</td>";
        }
        row += "</tr>";
        tabla += row;
    }
    tabla += "</table>";

    return tabla;
}
 ```
