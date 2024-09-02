package co.edu.uniquindio.otrosEjerciciosRec.ejercicio3;

public class Ejercicio3 {

    public static void main(String[] args) {

        int[] vector = {4, 2, 5, 3, 1};
        int inicio = 0;
        int fin = vector.length - 1;
        int numeroMenor = encontrarNumeroMenor(vector, inicio, fin);
        System.out.println("El numero menor del arreglo es: "+ numeroMenor);
    }

    private static int encontrarNumeroMenor(int[] vector, int inicio, int fin) {

        if (inicio == fin) {
            return vector[inicio];
        }

        // Llamada recursiva para encontrar el numero menor del arreglo
        int numeroMenor = encontrarNumeroMenor(vector, inicio + 1, fin);

        // Comparación: devolver el menor valor entre el valor actual y el numero menor
        if (vector[inicio] < numeroMenor) {
            return vector[inicio];
        } else {
            return numeroMenor;
        }
    }
}
