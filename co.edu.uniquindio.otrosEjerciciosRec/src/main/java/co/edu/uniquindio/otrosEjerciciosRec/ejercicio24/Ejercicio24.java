package co.edu.uniquindio.otrosEjerciciosRec.ejercicio24;

public class Ejercicio24 {

    public static void main(String[] args) {

        int[][] matriz = {{1,3,5,7},
                        {2,4,6,8}};
        int i = 0;
        int j = 0;
        convertirMatrizAtranspuesta(matriz, i, j);
    }

    private static void convertirMatrizAtranspuesta(int[][] matriz, int i, int j) {

        // Criterio de parada: cuando hemos recorrido todas las columnas
        if (j <= matriz[0].length - 1) {
            if (i <= matriz.length - 1) {
                // Imprimir el elemento de la posición actual
                System.out.print(matriz[i][j] + " ");

                // Llamada recursiva para la siguiente fila, misma columna
                convertirMatrizAtranspuesta(matriz, i + 1, j);
            } else {
                // Reiniciar la fila y pasar a la siguiente columna
                convertirMatrizAtranspuesta(matriz, 0, j + 1);
            }
        }
    }
}
