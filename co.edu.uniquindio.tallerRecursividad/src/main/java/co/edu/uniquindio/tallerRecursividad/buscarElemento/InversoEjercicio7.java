package co.edu.uniquindio.tallerRecursividad.buscarElemento;

public class InversoEjercicio7 {

    public static void main(String[] args){

        String[] array = {"a", "hola", "l", "e"};
        int indice = array.length - 1;
        String elementoABuscar = "a";

        boolean elemento = buscarElementoInverso(array, indice, elementoABuscar);

        if(elemento){
            System.out.print("El elementro ha sido encontrado en el array");
        }else {
            System.out.print("El elemento no ha sido encontrado en el array");
        }
    }

    private static boolean buscarElementoInverso(String[] array, int indice, String elementoABuscar) {

        // Caso base
        if (indice < 0){
            return false;
        }else {
            if (array[indice].equals(elementoABuscar)) {
                return true;
            } else {
                //Casp recursivo
                return buscarElementoInverso(array, indice - 1, elementoABuscar);
            }
        }
    }
}
