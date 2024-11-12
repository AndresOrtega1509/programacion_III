package co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio2;

public class Productor extends Thread {

    private final Tuberia tuberia;
    private final char[] caracteres;
    private final int tiempoEspera;
    private int indice;  // índice para ciclo continuo sobre caracteres

    public Productor(Tuberia tuberia, char[] caracteres, int tiempoEspera) {
        this.tuberia = tuberia;
        this.caracteres = caracteres;
        this.tiempoEspera = tiempoEspera;
        this.indice = 0;
    }

    public Tuberia getTuberia() {
        return tuberia;
    }

    public char[] getCaracteres() {
        return caracteres;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    @Override
    public void run() {
        while (true) {
            char c = caracteres[indice];  // selecciona el carácter en el índice actual
            lanzarCaracter(c);

            indice = (indice + 1) % caracteres.length;  // ciclo continuo en el arreglo

            try {
                Thread.sleep(tiempoEspera);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void lanzarCaracter(char c) {
        // Este método será sobrescrito por las clases hijas (P1, P2, etc.)
    }
}
