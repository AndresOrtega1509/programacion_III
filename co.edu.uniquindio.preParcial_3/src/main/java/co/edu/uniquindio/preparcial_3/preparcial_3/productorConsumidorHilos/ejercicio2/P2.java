package co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio2;

public class P2 extends Productor{

    public P2(Tuberia tuberia, char[] caracteres) {
        super(tuberia, caracteres, 150);  // Espera 150 ms para enviar la siguiente consonante
    }


    @Override
    protected void lanzarCaracter(char c) {
        if (esConsonante(c)) {
            getTuberia().lanzar(c);
            System.out.println("P2 ha lanzado la vocal: " + c);
        }
    }

    private boolean esConsonante(char c) {
        return "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(c) != -1;
    }
}
