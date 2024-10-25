package co.edu.uniquindio.preparcial_2.preparcial_2.hilosEjercicio4;

public class t3 extends Thread{

    private String palabra;
    private int resultado;

    public t3(String palabra) {
        this.palabra = palabra;
    }
    public void run() {
        resultado = contarConsonantesPalabra(palabra, 0);
    }

    private int contarConsonantesPalabra(String palabra, int indice) {

        palabra = palabra.toLowerCase();

        if (indice > palabra.length() -1) {
            return 0;
        }else {
            char letra = palabra.charAt(indice);
            if ((letra >= 'a' && letra <= 'z') && !(letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u')) {
                return contarConsonantesPalabra(palabra, indice + 1) + 1;
            }else {
                return contarConsonantesPalabra(palabra, indice + 1);
            }
        }
    }

    public int getResultado() {
        return resultado;
    }
}
