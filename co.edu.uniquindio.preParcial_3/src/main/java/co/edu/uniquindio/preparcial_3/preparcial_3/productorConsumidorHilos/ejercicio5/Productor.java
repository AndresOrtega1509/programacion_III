package co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio5;

public class Productor extends Thread {

    private Tanque tanque;
    private int capacidadCarga = 100;
    private int cargaPorAbastecimiento = 20;
    private String nombreProductor;

    public Productor(Tanque tanque, String nombreProductor) {
        this.tanque = tanque;
        this.nombreProductor = nombreProductor;
    }

    @Override
    public void run() {
        while (capacidadCarga > 0) {
            try {
                tanque.abastecer(cargaPorAbastecimiento, nombreProductor);
                capacidadCarga = capacidadCarga - cargaPorAbastecimiento;
                Thread.sleep(500); // Simula el tiempo de carga
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombreProductor +" finalizó, ya no tiene más gasolina para abastecer.");
    }
}
