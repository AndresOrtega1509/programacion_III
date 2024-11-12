package co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio4;

import java.util.HashSet;
import java.util.Set;

public class Tuberia {

    private char buffer[] = new char[10];
    private int siguiente = 0;
    // Flags para saber el estado del buffer
    private boolean estaLlena = false;
    private boolean estaVacia = true;
    private Set<Character> letrasEnBuffer = new HashSet<>();

    // M�todo para retirar letras del buffer
    public synchronized char recoger()
    {
        // No se puede consumir si el buffer est� vac�o
        while( estaVacia == true )
        {
            try {
                wait(); // Se sale cuando estaVacia cambia a false
            } catch( InterruptedException e ) {
                ;
            }
        }
        // Decrementa la cuenta, ya que va a consumir una letra
        siguiente--;
        char letra = buffer[siguiente];
        letrasEnBuffer.remove(letra);
        // Comprueba si se retir� la �ltima letra
        if( siguiente == 0 )
            estaVacia = true;
        // El buffer no puede estar lleno, porque acabamos
        // de consumir
        estaLlena = false;
        notify();

        // Devuelve la letra al thread consumidor
        return letra;
    }



    // M�todo para a�adir letras al buffer
    public synchronized void lanzar( char c )
    {
        // Espera hasta que haya sitio para otra letra
        while( estaLlena || letrasEnBuffer.contains(c))
        {
            try {
                wait(); // Se sale cuando estaLlena cambia a false
            } catch( InterruptedException e ) {
                ;
            }
        }

        // A�ade una letra en el primer lugar disponible
        buffer[siguiente] = c;
        letrasEnBuffer.add(c);
        // Cambia al siguiente lugar disponible
        siguiente++;
        // Comprueba si el buffer est� lleno
        if( siguiente == 10 )
            estaLlena = true;
        estaVacia = false;
        notify();
    }
}
