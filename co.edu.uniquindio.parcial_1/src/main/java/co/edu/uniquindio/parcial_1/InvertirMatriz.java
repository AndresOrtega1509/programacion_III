package co.edu.uniquindio.parcial_1;

public class InvertirMatriz {

    //Presentado por: Andres Felipe Ortega Mendez

    public static void main(String[] args) {

        String[][] matriz = {
                {"vacio", "carro", "vaul", "perro", "vacio"},
                {"colombia", "casa", "moto", "caza", "colombia"},
                {"llanta", "reir", "archivo", "silla", "llanta"},
                {"cocina", "ola", "ave", "freir", "cocina"},
        };
        String[][] matrizInvertida = new String[4][5];
        int i = matriz.length - 1;;
        int j = matriz[i].length - 1;
        recorrerMatriz(matriz,i, j, matrizInvertida);
        imprimirMatrizInvertida(matrizInvertida, 0, 0);

    }

    private static void recorrerMatriz(String[][] matriz, int i, int j, String[][] matrizInvertida) {

        if (i >= 0) {

            if (j >= 0) {

                matrizInvertida[i][j] = invertirPalabra(matriz, i, j,0);

                if (j == 0) {
                    i--;
                    if (i != -1) {
                        j = matriz[i].length - 1;
                        System.out.println();
                    }
                } else {
                    j--;

                }
                recorrerMatriz(matriz, i, j, matrizInvertida);
            }
        }
    }


    private static String invertirPalabra(String[][] matriz, int i, int j, int posicion) {

        String palabraInvertida = "";
        String palabra = palabraInvertida + matriz[i][j].charAt(posicion);

        if (posicion == matriz[i][j].length() - 1) {
            return palabra;
        }else {
            return invertirPalabra(matriz, i, j, posicion + 1) + palabra ;
        }

    }

    private static void imprimirMatrizInvertida(String[][] matrizInvertida, int i, int j) {

        if (i <= matrizInvertida.length - 1) {

            if (j <= matrizInvertida[i].length - 1) {

                System.out.print(matrizInvertida[i][j] + " ");

                if (j == matrizInvertida[i].length - 1) {
                    j = 0;
                    i++;
                    System.out.println();
                } else {
                    j++;
                }
                imprimirMatrizInvertida(matrizInvertida, i, j);
            }
        }
    }

}
