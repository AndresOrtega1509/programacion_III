package co.edu.uniquindio.preparcial_2.preparcial_2.hilos;

public class Hilo3 extends Thread {

    private final String nombre;

    public Hilo3(String nombre) {

        this.nombre = nombre;
    }

    public void run() {

        try {
            for (int i = 0; i < 15; i++) {
                System.out.println(nombre);
                Thread.sleep(500);
            }
        }catch (InterruptedException interruptedException){
            interruptedException.printStackTrace();
        }
    }
}
