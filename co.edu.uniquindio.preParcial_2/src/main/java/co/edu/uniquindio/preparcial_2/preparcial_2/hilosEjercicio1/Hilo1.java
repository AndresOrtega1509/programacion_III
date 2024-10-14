package co.edu.uniquindio.preparcial_2.preparcial_2.hilosEjercicio1;

public class Hilo1 extends Thread {

    @Override
    public void run() {
        try {
            String[] arreglo = {"hola", "hilo thread", "Carro", "Moto", "Casa", "temu"};

            for (String valores : arreglo) {
                System.out.println(valores);
                Thread.sleep(1000);
            }

        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
