package co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio2;

import java.util.HashSet;
import java.util.Set;

public class Tuberia {

    private char[] buffer = new char[12]; // Buffer de tamaño 12
    private int siguiente = 0; // Índice para agregar o quitar caracteres
    private boolean estaLlena = false; // Estado del buffer
    private boolean estaVacia = true; // Estado del buffer
    private Set<Character> letrasEnBuffer = new HashSet<>(); // Para evitar caracteres duplicados en el buffer

    // Método para retirar letras del buffer
    public synchronized char recoger() {
        // No se puede consumir si el buffer está vacío
        while (estaVacia) {
            try {
                wait(); // Se sale cuando estaVacia cambia a false
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Buen manejo de la interrupción
            }
        }

        // Decrementa la cuenta, ya que va a consumir una letra
        siguiente--;
        char letra = buffer[siguiente];
        letrasEnBuffer.remove(letra);

        // Comprueba si se retiró la última letra
        if (siguiente == 0) {
            estaVacia = true; // Si el buffer está vacío, se marca como vacío
        }

        // El buffer no puede estar lleno, porque acabamos de consumir
        estaLlena = false;
        notify(); // Notificar a los productores que hay espacio

        return letra; // Devuelve la letra al hilo consumidor
    }

    // Método para añadir letras al buffer
    public synchronized void lanzar(char c) {
        // Espera hasta que haya sitio para otra letra o si el carácter ya está en el buffer
        while (estaLlena || letrasEnBuffer.contains(c)) {
            try {
                wait(); // Se sale cuando estaLlena cambia a false
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Buen manejo de la interrupción
            }
        }

        // Añade la letra en el primer lugar disponible
        buffer[siguiente] = c;
        letrasEnBuffer.add(c);
        siguiente++;

        // Comprueba si el buffer está lleno
        if (siguiente == buffer.length) {
            estaLlena = true; // Si el buffer está lleno, se marca como lleno
        }

        estaVacia = false; // El buffer no está vacío
        notify(); // Notificar al consumidor que hay una letra disponible
    }
}
