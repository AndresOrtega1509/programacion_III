package co.edu.uniquindio.preparcial_2.preparcial_2.hilosEjercicio3;


public class Ejercicio_3 {

    public static String variable = "";
    public static final Object lock = new Object();
    public static boolean puedeEscribir = true;
    public static long tiempoInicio;
    public static final long DURACION_TOTAL = 20000; // Duración total de 20 segundos

    public static void main(String[] args) {
        tiempoInicio = System.currentTimeMillis();

        // Crear los hilos y pasarlos el objeto lock para sincronización
        Thread hiloEscribir = new Hilo1();
        Thread hiloLeer = new Hilo2();

        hiloEscribir.start();
        hiloLeer.start();

        try {
            hiloEscribir.join();
            hiloLeer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
