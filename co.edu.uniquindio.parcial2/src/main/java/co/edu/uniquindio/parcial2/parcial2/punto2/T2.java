package co.edu.uniquindio.parcial2.parcial2.punto2;

public class T2 extends Thread{

    private int[][] matriz;
    private double promedio;

    public T2(int[][] matriz){

        this.matriz = matriz;
    }

    @Override
    public void run() {
        promedio = calcularPromedioMatriz(matriz);
    }

    private double calcularPromedioMatriz(int[][] matriz) {

        int suma = 0;
        int cantidadElementos = 0;

        // Recorremos la matriz fila por fila
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j]; // Sumamos cada elemento
                cantidadElementos++;  // Contamos los elementos
            }
        }

        // Retornamos el promedio como un valor double
        return (double) suma / cantidadElementos;
    }

    public double getPromedio() {
        return promedio;
    }
}
