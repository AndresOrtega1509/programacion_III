package co.edu.uniquindio.problemaNDados;

import java.util.ArrayList;
import java.util.List;

public class LanzamientoDados {
    public static void main(String[] args) {
        int cantidadDados = 2; // Número de dados
        List<Integer> secuencia = new ArrayList<>();
        lanzarDados(cantidadDados, secuencia, 1);
    }

    private static void lanzarDados(int cantidadDados, List<Integer> secuencia, int valor) {

        // Caso base: si se han lanzado todos los dados
        if (cantidadDados == 0) {
            System.out.println(secuencia); // Imprimir la secuencia completa
        } else if (valor <= 6) {  // Solo continuamos si el valor está en el rango [1,6]
            // Añadir el valor actual a la secuencia
            secuencia.add(valor);

            // Llamada recursiva con un dado menos
            lanzarDados(cantidadDados - 1, secuencia, 1); // Reiniciamos el valor a 1 para el siguiente dado

            // Retroceso: eliminar el valor actual
            secuencia.remove(secuencia.size() - 1);

            // Avanzar al siguiente valor del dado actual
            lanzarDados(cantidadDados, secuencia, valor + 1);
        }
    }
}