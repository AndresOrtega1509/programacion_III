package co.edu.uniquindio.contarCifras;

public class Main {
    public static void main(String[] args) {
        int numero = 123;
        int cifras = contarCifras(numero);

    }

    private static int contarCifras(int numero) {

        if (numero < 10){
            return 1;
        }else {
            return contarCifras(numero / 10);
        }
    }
}