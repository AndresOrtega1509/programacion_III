package co.edu.uniquindio.problemaNDados;

import java.util.ArrayList;
import java.util.List;

public class LanzamientoDados {
    public static void main(String[] args) {
        int cantidadDados = 2; // Número de dados
        List<Integer> combinacion = new ArrayList<>();
        lanzarDados(cantidadDados, combinacion, 1);
    }

    private static void lanzarDados(int cantidadDados, List<Integer> combinacion, int valor) {

        // Caso base: si se han lanzado todos los dados
        if (cantidadDados == 0) {
            System.out.println(combinacion); // Imprimir la combinacion completa
        } else if (valor <= 6) {  // Solo continuamos si el valor está en el rango [1,6]
            // Añadir el valor actual a la combinacion
            combinacion.add(valor);

            // Llamada recursiva con un dado menos
            lanzarDados(cantidadDados - 1, combinacion, 1); // Reiniciamos el valor a 1 para el siguiente dado

            // Retroceso: eliminar el valor actual
            combinacion.remove(combinacion.size() - 1);

            // Avanzar al siguiente valor del dado actual
            lanzarDados(cantidadDados, combinacion, valor + 1);
        }
    }
}