package co.edu.uniquindio.preparcial_2.preparcial_2.hilosEjercicio1;

public class Hilo2 extends Thread {

    @Override
    public void run() {
        try {

            int entero = 2;

            for (int i = 0; i < 10; i++) {
                System.out.println(entero * entero);
                Thread.sleep(1500);
            }

        }catch (InterruptedException interruptedException){
            interruptedException.printStackTrace();
        }

    }
}
