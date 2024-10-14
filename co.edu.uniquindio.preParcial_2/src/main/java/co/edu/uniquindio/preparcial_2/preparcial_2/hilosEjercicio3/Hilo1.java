package co.edu.uniquindio.preparcial_2.preparcial_2.hilosEjercicio3;

public class Hilo1 extends Thread {

    @Override
    public void run() {
        while (System.currentTimeMillis() - Ejercicio_3.tiempoInicio < Ejercicio_3.DURACION_TOTAL) {
            synchronized (Ejercicio_3.lock) {
                while (!Ejercicio_3.puedeEscribir) {
                    try {
                        Ejercicio_3.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                long tiempoInicioEscritura = System.currentTimeMillis();
                while (System.currentTimeMillis() - tiempoInicioEscritura < 6000) {
                    Ejercicio_3.variable += "hola";
                    System.out.println("Escribiendo: " + Ejercicio_3.variable);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Ejercicio_3.puedeEscribir = false;
                Ejercicio_3.lock.notifyAll();
            }
        }
    }
}
