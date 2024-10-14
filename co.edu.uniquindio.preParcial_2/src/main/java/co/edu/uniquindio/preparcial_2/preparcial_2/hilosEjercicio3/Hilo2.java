package co.edu.uniquindio.preparcial_2.preparcial_2.hilosEjercicio3;

public class Hilo2 extends Thread {

    @Override
    public void run() {
        while (System.currentTimeMillis() - Ejercicio_3.tiempoInicio < Ejercicio_3.DURACION_TOTAL) {
            synchronized (Ejercicio_3.lock) {
                while (Ejercicio_3.puedeEscribir) {
                    try {
                        Ejercicio_3.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String var = Ejercicio_3.variable;
                System.out.println("Leyendo y mostrando: " + var);
                Ejercicio_3.variable = "";
                Ejercicio_3.puedeEscribir = true;
                Ejercicio_3.lock.notifyAll();
            }
        }
    }
}
