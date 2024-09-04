package co.edu.uniquindio.preParcial;

import java.util.ArrayList;

public class MatrizPalabras {
    public static void main(String[] args) {

        String[][] matriz = {{"vacio", "carro", "baul", "perro"},
                            {"colombia","casa", "moto", "caza"},
                            {"llanta", "reir", "archivo", "silla"},
                            {"cocina", "ola", "ave", "freir"}};
        int i = 0;
        int j = 0;
        ArrayList<String> listaPalabras = new ArrayList<>();
        ArrayList<String> palabrasVocales = recorrerMatriz(matriz, i, j, listaPalabras);
        System.out.println(palabrasVocales);

    }

    private static ArrayList<String> recorrerMatriz(String[][] matriz, int i, int j,
                                                    ArrayList<String> listaPalabras) {

        if (i <= matriz.length -1){
            int indice = 0;
            int posicionSiguiente = 1;
            boolean bocalesSeguidas = verificarVocalesSeguidas(matriz, i, j, indice, posicionSiguiente);
            if (bocalesSeguidas){
                listaPalabras.add(matriz[i][j]);
            }
            if (j <= matriz[i].length -1){
                if (j == matriz[i].length - 1) {
                    j = 0;
                    i++;
                } else {
                    j++;
                }
                recorrerMatriz(matriz, i, j, listaPalabras);
            }
        }
        return listaPalabras;
    }

    private static boolean verificarVocalesSeguidas(String[][] matriz, int i, int j, int posicionInicial,
                                                    int posicionSiguiente) {

        if (posicionInicial >= matriz[i][j].length() - 1) {

            return false;
        }else {
            if ((matriz[i][j].charAt(posicionInicial) == 'a' || matriz[i][j].charAt(posicionInicial) == 'e' || matriz[i][j].charAt(posicionInicial)
                    == 'i' || matriz[i][j].charAt(posicionInicial) == 'o' || matriz[i][j].charAt(posicionInicial) == 'u') &&
                    (matriz[i][j].charAt(posicionSiguiente) == 'a' || matriz[i][j].charAt(posicionSiguiente) == 'e' ||
                            matriz[i][j].charAt(posicionSiguiente) == 'i' || matriz[i][j].charAt(posicionSiguiente) == 'o'
                                                                || matriz[i][j].charAt(posicionSiguiente) == 'u')) {
                return true;
            }else {
                return verificarVocalesSeguidas(matriz, i, j, posicionInicial + 1, posicionSiguiente + 1);
            }
        }

    }

}
