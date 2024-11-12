package co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio5;

public class Tanque {

    private int capacidadMaxima = 1000;
    private int nivelGasolina = 0;

    public synchronized void abastecer(int galones, String nombreProductor) {

        while (nivelGasolina + galones > capacidadMaxima) {

            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        nivelGasolina += galones;
        System.out.println(nombreProductor + " abastece " + galones + " galones. Nivel actual: " + nivelGasolina);
        notifyAll(); // Notifica a los consumidores que pueden reanudar si esperaban gasolina
    }

    public synchronized void consumir(int galones, String tipoVehiculo) {

        while (nivelGasolina < galones) {

            try {
                System.out.println(tipoVehiculo + " espera, tanque insuficiente para " + galones + " galones.");
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        nivelGasolina = nivelGasolina - galones;
        System.out.println(tipoVehiculo + " consume " + galones + " galones. Nivel actual: " + nivelGasolina);
        notifyAll(); // Notifica a los productores que pueden reanudar si esperaban espacio
    }
}
