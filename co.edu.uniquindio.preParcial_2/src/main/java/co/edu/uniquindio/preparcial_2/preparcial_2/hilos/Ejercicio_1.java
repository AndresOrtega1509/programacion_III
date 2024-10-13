package co.edu.uniquindio.preparcial_2.preparcial_2.hilos;

public class Ejercicio_1 {

    public static void main(String[] args) {
        Hilo1 hilo = new Hilo1();
        hilo.start();

        Hilo2 hilo2 = new Hilo2();
        hilo2.start();

        Hilo3 hilo3 = new Hilo3("el ultimo");
        hilo3.start();
    }
}
