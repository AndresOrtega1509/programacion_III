package co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio1;

import co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio1.Productor;

public class Ejecucion {

	public static void main( String args[] ) {
		Tuberia t = new Tuberia();
		Productor p1 = new Productor( t );
		Productor p2 = new Productor( t );
		Consumidor c = new Consumidor( t );

		p1.start();
		p2.start();
		c.start();
	}
}