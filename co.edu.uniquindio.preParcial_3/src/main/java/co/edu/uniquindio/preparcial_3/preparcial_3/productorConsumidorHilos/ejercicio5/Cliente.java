package co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio5;

public class Cliente extends Thread {

    private Tanque tanque;
    private int consumo;
    private String tipoVehiculo;

    public Cliente(Tanque tanque, int consumo, String tipoVehiculo) {
        this.tanque = tanque;
        this.consumo = consumo;
        this.tipoVehiculo = tipoVehiculo;
    }

    @Override
    public void run() {
        tanque.consumir(consumo, tipoVehiculo);
    }
}
