package co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EstacionServicio {

    public static void main(String[] args) {
        Tanque tanque = new Tanque();

        Productor productor1 = new Productor(tanque, "productor1");
        Productor productor2 = new Productor(tanque, "productor2");
        Productor productor3 = new Productor(tanque, "productor3");

        // Crear clientes (vehículos y motocicletas)
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(tanque, 10, "Vehículo"));
        clientes.add(new Cliente(tanque, 4, "Motocicleta"));
        clientes.add(new Cliente(tanque, 10, "Vehículo"));
        clientes.add(new Cliente(tanque, 4, "Motocicleta"));

        // Iniciar los hilos de productores
        productor1.start();
        productor2.start();
        productor3.start();

        // Iniciar los hilos de clientes
        for (Cliente cliente : clientes) {
            cliente.start();
        }

        // Esperar la finalización de los productores
        try {
            productor1.join();
            productor2.join();
            productor3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Esperar la finalización de los clientes
        for (Cliente cliente : clientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Simulación finalizada.");
    }
}
