package co.edu.uniquindio.tallerRecursividad.recorrerMatriz;

public class Ejercicio8 {

    public  static  void main(String[] args){

        int[][] matriz  = {
                {1, 2, 3,
                 4, 5, 6,
                 7, 8, 9}
        };
        int i = 0;
        int j = 0;

        recorrerMatriz(matriz, i, j);
    }

    private static void recorrerMatriz(int[][] matriz, int i, int j) {

        if (i <= matriz.length - 1) {

            if (j <= matriz[i].length - 1) {

                System.out.print(matriz[i][j]);

                if (j == matriz[i].length - 1) {
                    j = 0;
                    i++;
                    System.out.println("\n");
                } else {
                    j++;
                }
                recorrerMatriz(matriz, i, j);
            }
        }
    }
}
