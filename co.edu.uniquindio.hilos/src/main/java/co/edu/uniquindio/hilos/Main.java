package co.edu.uniquindio.hilos;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hilo principal iniciado");

        HiloEjemplo hiloEjemplo = new HiloEjemplo();
        RunnableEjemplo runnableEjemplo = new RunnableEjemplo();
        Thread thread = new Thread(runnableEjemplo);

        hiloEjemplo.start();
        hiloEjemplo.join();

        thread.start();

        System.out.println("Hilo principal finalizado");

    }
}