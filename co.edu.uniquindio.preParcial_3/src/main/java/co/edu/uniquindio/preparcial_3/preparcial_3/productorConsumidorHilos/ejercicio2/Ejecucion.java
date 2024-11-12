package co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio2;

public class Ejecucion {

    public static void main(String[] args) {

        Tuberia tuberia = new Tuberia();

        // Crear el arreglo con todos los caracteres necesarios
        char[] caracteres = new char[62 + 12];  // 26 + 26 (mayúsculas y minúsculas) + 10 (números) + 12 (caracteres especiales)

        // Llenar el arreglo con los caracteres
        int index = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            caracteres[index++] = c;  // Letras minúsculas
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            caracteres[index++] = c;  // Letras mayúsculas
        }
        for (char c = '0'; c <= '9'; c++) {
            caracteres[index++] = c;  // Números del 0 al 9
        }
        char[] caracteresEspeciales = {'@', '#', '-', '*', '$', '(', ')', '/', '%', '+', ':', ';'};
        System.arraycopy(caracteresEspeciales, 0, caracteres, index, caracteresEspeciales.length);  // Caracteres especiales

        // Crear los productores
        Productor p1 = new P1(tuberia, caracteres);
        Productor p2 = new P2(tuberia, caracteres);
        Productor p3 = new P3(tuberia, caracteres);
        Productor p4 = new P4(tuberia, caracteres);

        // Crear el consumidor
        Consumidor consumidor = new Consumidor(tuberia);

        // Iniciar los hilos
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        consumidor.start();
    }
}
