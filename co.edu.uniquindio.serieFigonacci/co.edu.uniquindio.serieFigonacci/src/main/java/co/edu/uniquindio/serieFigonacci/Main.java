package co.edu.uniquindio.serieFigonacci;

public class Main {
    public static void main(String[] args) {
        int numero = 12343;
        int cifras = contarCifras(numero);
        System.out.print("El numero de digitos del numero: " + numero + " es:" + cifras);

    }

    private static int contarCifras(int numero) {

        if (numero < 10){
            return 1;
        }else {
            return contarCifras(numero / 10) + 1;
        }
    }
}