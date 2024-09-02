package co.edu.uniquindio.otrosEjerciciosRec.ejercicio4;

public class Ejercicio4 {
    public static void main(String[] args) {

        int n = 123;
        int resultado = sumarCifras(n);
        System.out.println("Cantidad de cifras: " + resultado);
    }

    private static int sumarCifras(int n) {

        if (n < 10){
            return n;
        }else {
            return n % 10 + sumarCifras(n / 10);
        }
    }
}
