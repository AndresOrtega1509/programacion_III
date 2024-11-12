package co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio2;

public class P4 extends Productor{

    public P4(Tuberia tuberia, char[] caracteres) {
        super(tuberia, caracteres, 350);  // Espera 350 milisegundos para enviar el siguiente carácter especial
    }


    @Override
    protected void lanzarCaracter(char c) {
        if (esCaracterEspecial(c)) {
            getTuberia().lanzar(c);
            System.out.println("P4 ha lanzado la vocal: " + c);
        }
    }

    private boolean esCaracterEspecial(char c) {
        return "@#$%&*()/-+:;".indexOf(c) != -1;  // Comprueba si el carácter es un carácter especial
    }
}
