package co.edu.uniquindio.preParcial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrizEdades {

    public static void main(String[] args) {

        int[][] matriz = {
                {5, 7, 1, 3},
                {6, 45, 13, 89},
                {2, 28, 496, 8128},
                {11, 4, 8, 89},
                {6, 37, 43, 10},

        };
        int i = matriz.length - 1;
        int j = 0;
        List<Integer> listaPrimos = new ArrayList<>();
        List<Integer> listaPerfectos = new ArrayList<>();

        recorrerMatriz(matriz, i, j, listaPrimos, listaPerfectos);

        System.out.println("Edades primas: " + listaPrimos);
        System.out.println("Edades perfectas: " + listaPerfectos);
    }

    private static void recorrerMatriz(int[][] matriz, int i, int j, List<Integer> listaPrimos, List<Integer> listaPerfectos) {

        if (i >= 0) {

            if (j <= matriz[i].length - 1) {

                int numero = matriz[i][j];

                boolean primo = esPrimo(numero, 2);
                if (primo){
                    listaPrimos.add(numero);
                }

                if (esPerfecto(numero)) {
                    listaPerfectos.add(numero);
                }

                if (j == matriz[i].length - 1) {
                    i--;
                    if (i != -1) {
                        j = 0;
                    }
                } else {
                    j++;
                }
                recorrerMatriz(matriz, i, j, listaPrimos, listaPerfectos);
            }
        }
    }

    private static boolean esPrimo(int numero, int divisor) {

        if (numero <= 1) return false;
        if (divisor == numero) return true;
        if (numero % divisor == 0) return false;
        return esPrimo(numero, divisor + 1);
    }

    private static boolean esPerfecto(int numero) {

        return numero > 1 && sumaDivisores(numero, 1) == numero;
    }

    private static int sumaDivisores(int numero, int divisor) {

        if (divisor >= numero) return 0;
        if (numero % divisor == 0) {
            return divisor + sumaDivisores(numero, divisor + 1);
        } else {
            return sumaDivisores(numero, divisor + 1);
        }
    }

}
