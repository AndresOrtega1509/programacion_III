package co.edu.uniquindio.otrosEjerciciosRec.ejercicio2;

public class Ejercicio2 {

    public static void main(String[] args) {

        int[] arreglo = {2,0,0};
        int n = 0;
        int ceros = contarCantidadCeros(arreglo, n);
        System.out.println("La cantidad de ceros del arreglo son: " + ceros);
    }

    private static int contarCantidadCeros(int[] arreglo, int n) {

        if (n > arreglo.length - 1){
            return 0;
        }else {
            if (arreglo[n] == 0){
                return contarCantidadCeros(arreglo, n+1) + 1;
            }else {
                return contarCantidadCeros(arreglo, n+1);
            }
        }
    }
}
