package co.edu.uniquindio.tallerRecursividad.buscarElemento;

public class Ejercicio7 {
    public  static  void main(String[] args){

        String[] array = {"a", "hola", "l", "e"};
        int indice = 0;
        String elementoABuscar = "e";

        boolean elemento = buscarElemento(array, indice, elementoABuscar);

        if(elemento){
            System.out.print("El elementro ha sido encontrado en el array");
        }else {
            System.out.print("El elemento no ha sido encontrado en el array");
        }
    }

    private static boolean buscarElemento(String[] array, int indice, String elementoABuscar) {
        // Caso base
        if (indice >= array.length){
            return false;
        }else {
            if (array[indice].equals(elementoABuscar)){
                return true;
            }else {
                //Casp recursivo
                return buscarElemento(array, indice + 1, elementoABuscar);
            }
        }
    }
}