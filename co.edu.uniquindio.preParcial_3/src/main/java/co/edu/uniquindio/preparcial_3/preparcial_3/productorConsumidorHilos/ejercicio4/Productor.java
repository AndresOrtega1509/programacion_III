package co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio4;

import co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio4.Tuberia;

public class Productor extends Thread {

    private Tuberia tuberia;
    private String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Productor(Tuberia tuberia) {
        this.tuberia = tuberia;
    }

    @Override
    public void run() {
        char c;

        // Mete 15 letras en la tuber�a
        for( int i=0; i < 15; i++ )
        {
            c = alfabeto.charAt( (int)(Math.random()*26 ) );
            tuberia.lanzar( c );
            // Imprime un registro con lo a�adido
            System.out.println( "Lanzado "+c+" a la tuberia." );
            // Espera un poco antes de a�adir m�s letras
            try
            {
                sleep( (int)(Math.random() * 100 ) );
            }
            catch( InterruptedException e )
            {
                System.out.println(e);;
            }
        }
    }
}
