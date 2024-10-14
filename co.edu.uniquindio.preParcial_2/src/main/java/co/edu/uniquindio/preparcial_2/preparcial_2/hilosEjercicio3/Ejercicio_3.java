package co.edu.uniquindio.preparcial_2.preparcial_2.hilosEjercicio3;

public class Ejercicio_3 {

    private static String variable = "";
    private static final Object lock = new Object();
    private static boolean puedeEscribir = true; // Para alternar los hilos
    private static long tiempoInicio;
    private static final long DURACION_TOTAL = 20000; // Duración total de 20 segundos

    public static void main(String[] args) {
        tiempoInicio = System.currentTimeMillis();

        Thread hiloEscribir = new Thread(new HiloEscribir());
        Thread hiloLeer = new Thread(new HiloLeer());

        hiloEscribir.start();
        hiloLeer.start();

        try {
            hiloEscribir.join();
            hiloLeer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class HiloEscribir extends Thread {
        @Override
        public void run() {
            while (System.currentTimeMillis() - tiempoInicio < DURACION_TOTAL) {
                synchronized (lock) {
                    while (!puedeEscribir) { // Espera hasta que sea su turno
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // Concatenar información durante 6 segundos
                    long tiempoInicioEscritura = System.currentTimeMillis();
                    while (System.currentTimeMillis() - tiempoInicioEscritura < 6000) {
                        variable += "hola";
                        System.out.println("Escribiendo: " + variable);
                        try {
                            Thread.sleep(1000); // Simulación de escribir por intervalos
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    puedeEscribir = false; // Cambiar el turno
                    lock.notifyAll(); // Despertar al otro hilo
                }
            }
        }
    }

    static class HiloLeer extends Thread {
        @Override
        public void run() {
            while (System.currentTimeMillis() - tiempoInicio < DURACION_TOTAL) {
                synchronized (lock) {
                    while (puedeEscribir) { // Espera hasta que sea su turno
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // Leer y mostrar la variable, luego limpiar la información
                    String var = variable;
                    System.out.println("Leyendo y mostrando: " + var);
                    variable = ""; // Limpiar la variable
                    puedeEscribir = true; // Cambiar el turno
                    lock.notifyAll(); // Despertar al otro hilo
                }
            }
        }
    }
}
