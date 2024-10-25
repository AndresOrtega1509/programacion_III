package co.edu.uniquindio.parcial2.parcial2.punto2;

public class T1 extends Thread{

    private int[][] matriz;
    private int numeroMenor;

    public T1(int[][] matriz) {
        this.matriz = matriz;
    }

    @Override
    public void run() {

        numeroMenor = obtenerNumeroMenor(matriz, 0, 0, matriz[0][0]);
    }

    private int obtenerNumeroMenor(int[][] matriz, int i, int j, int menorActual) {

        // Caso base
        if (i >= matriz.length) {
            return menorActual;
        }

        // Actualizamos el menor actual si encontramos un valor más pequeño
        if (matriz[i][j] < menorActual) {
            menorActual = matriz[i][j];
        }

        // Avanzamos en la columna
        if (j < matriz[i].length - 1) {
            return obtenerNumeroMenor(matriz, i, j + 1, menorActual);
        }
        // Si terminamos la fila, pasamos a la siguiente
        else {
            return obtenerNumeroMenor(matriz, i + 1, 0, menorActual);
        }
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public int getNumeroMenor() {
        return numeroMenor;
    }
}
