package co.edu.uniquindio.otrosEjerciciosRec.ejercicio5;

public class Ejercicio5 {

    public static void main(String[] args) {
        int[] vector = {1, 3, 2, 1, 5, 7, 1};
        int inicio = 0;
        int fin = vector.length - 1;
        int elementoABuscar = 1;
        int apariciones = determinarNumeroApariciones(vector, inicio, fin, elementoABuscar);
        System.out.println("La cantidad de apariciones son: " + apariciones);

    }

    private static int determinarNumeroApariciones(int[] vector, int inicio, int fin, int elementoABuscar) {

        if (inicio > fin){
            return 0;
        }else {
            if (vector[inicio] == elementoABuscar){
                return determinarNumeroApariciones(vector, inicio + 1, fin, elementoABuscar) + 1;
            }else {
                return determinarNumeroApariciones(vector, inicio + 1, fin, elementoABuscar);
            }
        }
    }
}
