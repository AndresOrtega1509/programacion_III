package co.edu.uniquindio.preparcial_2.preparcial_2.hilosEjercicio2;

public class T2 extends Thread {

    private String palabra;
    private int cantidadVocales;

    public T2(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public void run() {

        cantidadVocales = contarVocales(palabra, 0);

    }

    private int contarVocales(String palabra, int i) {

        if (i > palabra.length() - 1){
            return 0;
        }else {
            if (palabra.charAt(i) == 'a' || palabra.charAt(i) == 'e'|| palabra.charAt(i) == 'i'
                    || palabra.charAt(i) == 'o' || palabra.charAt(i) == 'u'){

                return contarVocales(palabra, i + 1) + 1;
            }else {
                return contarVocales(palabra, i + 1);
            }
        }
    }

    public int getCantidadVocales() {
        return cantidadVocales;
    }
}
