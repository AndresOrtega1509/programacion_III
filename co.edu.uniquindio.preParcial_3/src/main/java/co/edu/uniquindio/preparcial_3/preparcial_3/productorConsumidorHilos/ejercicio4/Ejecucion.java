package co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio4;

import co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio4.Consumidor;
import co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio4.Tuberia;

public class Ejecucion {

    public static void main(String[] args) {

        Tuberia tuberia = new Tuberia();
        Productor p1 = new Productor(tuberia);
        Productor p2 = new Productor(tuberia);
        Consumidor c = new Consumidor(tuberia);

        p1.start();
        p2.start();
        c.start();

    }
}
