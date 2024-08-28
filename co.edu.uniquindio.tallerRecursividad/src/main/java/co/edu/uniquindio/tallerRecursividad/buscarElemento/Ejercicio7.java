package co.edu.uniquindio.tallerRecursividad.buscarElemento;

public class Ejercicio7 {
    public  static  void main(String[] args){

        String[] array = {"a", "hola", "l", "e"};
        int indiceInicial = 0;
        String elementoABuscar = "L";

        boolean elemento = buscarElemento(array, indiceInicial, elementoABuscar);

        if(elemento){
            System.out.print("El elementro ha sido encontrado en el array");
        }else {
            System.out.print("El elemento no ha sido encontrado en el array");
        }
    }

    private static boolean buscarElemento(String[] array, int indiceInicial, String elementoABuscar) {
        // Caso base
        if (indiceInicial >= array.length){
            return false;
        }else {
            if (array[indiceInicial].equals(elementoABuscar)){
                return true;
            }else {
                //Casp recursivo
                return buscarElemento(array, indiceInicial + 1, elementoABuscar);
            }
        }
    }
}