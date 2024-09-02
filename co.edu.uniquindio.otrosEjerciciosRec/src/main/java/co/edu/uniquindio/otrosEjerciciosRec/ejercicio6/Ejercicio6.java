package co.edu.uniquindio.otrosEjerciciosRec.ejercicio6;

public class Ejercicio6 {
    public static void main(String[] args) {
        String[] array = {"gato", "uni", "loro", "carro"};
        int indice = 0;
        recorrerArray(array, indice);
    }

    private static void recorrerArray(String[] array, int indice) {
        if (indice <= array.length - 1){
            System.out.println(array[indice]);

            recorrerArray(array, indice + 1);
        }
    }
}
