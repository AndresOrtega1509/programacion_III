package co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.productorConsumidorSockets.ejercicio1;

public class MainCliente {

    public static void main(String[] args) {
        Cliente appCliente = new Cliente("localhost",8081);
        System.out.println("Iniciando cliente\n");
        appCliente.iniciarCliente();
    }
}
