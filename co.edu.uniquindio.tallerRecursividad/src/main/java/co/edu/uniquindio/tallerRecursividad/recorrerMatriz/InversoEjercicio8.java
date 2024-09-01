package co.edu.uniquindio.tallerRecursividad.recorrerMatriz;

public class InversoEjercicio8 {

    public  static  void main(String[] args){

        int[][] matriz  =   {{1,2,3},
                            {4,5,6},
                            {7,8,9},
                            {10,11,12}};
        int i = matriz.length - 1;
        int j = matriz[i].length - 1;

        recorrerMatrizInverso(matriz, i, j);
    }

    private static void recorrerMatrizInverso(int[][] matriz, int i, int j) {

        if (i >= 0) {

            if (j >= 0) {

                System.out.print(matriz[i][j] + " ");

                if (j == 0) {
                    i--;
                    if (i != -1){
                        j = matriz[i].length - 1;
                        System.out.println();
                    }
                } else {
                    j--;
                }
                recorrerMatrizInverso(matriz, i, j);
            }
        }
    }
}
