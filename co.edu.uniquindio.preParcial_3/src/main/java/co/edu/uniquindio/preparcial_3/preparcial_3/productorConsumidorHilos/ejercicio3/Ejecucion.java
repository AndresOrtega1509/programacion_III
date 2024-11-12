package co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio3;

public class Ejecucion {

    public static void main(String[] args) {

        // Ruta del directorio donde se encuentran los archivos
        String directorioRutas = "src/main/resources/co/edu/uniquindio/preparcial_3/preparcial_3/archivos";

        // Palabras a buscar
        String palabra1 = "ingenieria";
        String palabra2 = "java";

        Buscador hilo1 = new Buscador(palabra1, directorioRutas);
        Buscador hilo2 = new Buscador(palabra2, directorioRutas);

        hilo1.start();
        hilo2.start();
    }
}
