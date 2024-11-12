package co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio2;

public class P3 extends Productor{

    public P3(Tuberia tuberia, char[] caracteres) {
        super(tuberia, caracteres, 250);  // Espera 250 milisegundos para enviar el siguiente número
    }


    @Override
    protected void lanzarCaracter(char c) {
        if (esNumero(c)) {
            getTuberia().lanzar(c);
            System.out.println("P3 ha lanzado la vocal: " + c);
        }
    }

    private boolean esNumero(char c) {
        return "0123456789".indexOf(c) != -1;  // Comprueba si el carácter es un número
    }

}
