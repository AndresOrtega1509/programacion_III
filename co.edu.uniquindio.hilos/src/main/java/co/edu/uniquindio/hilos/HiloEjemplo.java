package co.edu.uniquindio.hilos;

public class HiloEjemplo extends Thread {

    @Override
    public void run() {

        try {
            System.out.println("Hilo thread");

            Thread.sleep(5000);

            System.out.println("Hilo thread finalizado");

        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
