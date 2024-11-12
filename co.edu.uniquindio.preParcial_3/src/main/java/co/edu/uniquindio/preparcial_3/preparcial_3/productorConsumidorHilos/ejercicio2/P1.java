package co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio2;

public class P1 extends Productor{

    public P1(Tuberia tuberia, char[] caracteres) {
        super(tuberia, caracteres, 100);
    }

    @Override
    protected void lanzarCaracter(char c) {
        if (esVocal(c)) {
            getTuberia().lanzar(c);
            System.out.println("P1 ha lanzado la vocal: " + c);
        }
    }

    private boolean esVocal(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
