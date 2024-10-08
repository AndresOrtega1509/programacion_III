package co.edu.uniquindio.hilos;

import java.util.concurrent.ThreadLocalRandom;

public class RunnableEjemplo implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Hilo Runnable");

            int randomNum = ThreadLocalRandom.current().nextInt(6000, 8000);
            Thread.sleep(randomNum);

            System.out.println("Hilo Runnable finalizado");

        }catch (InterruptedException interruptedException){

            interruptedException.printStackTrace();
        }

    }
}
