package co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.productorConsumidorSockets.ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    int puerto = 8081;
    ServerSocket server;
    Socket socketComunicacion;
    DataOutputStream flujoSalida;
    DataInputStream flujoEntrada;

    public Servidor() {
        // Constructor vacío
    }

    public void iniciarServidor() {
        try {
            server = new ServerSocket(puerto);
            System.out.println("Servidor iniciado en el puerto " + puerto);
            while (true) {
                System.out.println("Esperando al cliente...");
                socketComunicacion = server.accept();

                flujoSalida = new DataOutputStream(socketComunicacion.getOutputStream());
                flujoEntrada = new DataInputStream(socketComunicacion.getInputStream());

                // Recibir los datos del cliente
                recibirDatosPrimitivos();

                // Cerrar la conexión
                flujoEntrada.close();
                flujoSalida.close();
                socketComunicacion.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void recibirDatosPrimitivos() throws IOException {
        // Recibir cadena y número desde el cliente
        String cadena = flujoEntrada.readUTF();
        int numero = flujoEntrada.readInt();

        // Realizar operaciones
        int cantidadCifras = contarCifras(numero);
        int[] resultadoVocalesConsonantes = contarVocalesConsonantes(cadena, 0, 0, 0);

        // Imprimir resultados en el servidor
        System.out.println("Cadena recibida del cliente: " + cadena);
        System.out.println("Número recibido del cliente: " + numero);
        System.out.println("Cantidad de cifras en el número: " + cantidadCifras);
        System.out.println("Vocales en la cadena: " + resultadoVocalesConsonantes[0]);
        System.out.println("Consonantes en la cadena: " + resultadoVocalesConsonantes[1]);

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Enviar resultados al cliente
        flujoSalida.writeUTF("Cantidad de cifras: " + cantidadCifras);
        flujoSalida.writeUTF("Vocales en la cadena: " + resultadoVocalesConsonantes[0]);
        flujoSalida.writeUTF("Consonantes en la cadena: " + resultadoVocalesConsonantes[1]);

        System.out.println("Resultados enviados al cliente.");

    }

    // Método recursivo para contar cifras de un número
    private int contarCifras(int numero) {
        if (numero < 10) return 1;
        return 1 + contarCifras(numero / 10);
    }

    // Método recursivo para contar vocales y consonantes
    private int[] contarVocalesConsonantes(String cadena, int indice, int vocales, int consonantes) {
        if (indice == cadena.length()) return new int[]{vocales, consonantes};

        char c = Character.toLowerCase(cadena.charAt(indice));
        if ("aeiou".indexOf(c) != -1) {
            vocales++;
        } else if (Character.isLetter(c)) {
            consonantes++;
        }

        return contarVocalesConsonantes(cadena, indice + 1, vocales, consonantes);
    }
}
