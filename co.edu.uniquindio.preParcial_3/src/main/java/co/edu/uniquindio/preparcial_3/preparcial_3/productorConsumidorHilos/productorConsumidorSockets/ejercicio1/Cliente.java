package co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.productorConsumidorSockets.ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

    String host;
    int puerto;
    Socket socketComunicacion;
    DataOutputStream flujoSalida;
    DataInputStream flujoEntrada;

    public Cliente(String host, int puerto) {
        this.host = host;
        this.puerto = puerto;
    }

    public void iniciarCliente() {
        try {
            crearConexion();

            flujoEntrada = new DataInputStream(socketComunicacion.getInputStream());
            flujoSalida = new DataOutputStream(socketComunicacion.getOutputStream());

            // Enviar datos al servidor
            enviarDatosPrimitivos();

            // Recibir y mostrar los resultados del servidor
            recibirDatosPrimitivos();

            // Cerrar conexión
            flujoEntrada.close();
            flujoSalida.close();
            socketComunicacion.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void enviarDatosPrimitivos() throws IOException {
        // Enviar cadena y número al servidor
        String cadena = "hola";
        int numero = 5486;

        flujoSalida.writeUTF(cadena);
        flujoSalida.writeInt(numero);

        System.out.println("Enviando cadena: " + cadena);
        System.out.println("Enviando número: " + numero);
    }

    private void recibirDatosPrimitivos() throws IOException {
        // Recibir resultados del servidor
        System.out.println("Datos recibidos del servidor: " + flujoEntrada.readUTF());
        System.out.println("Datos recibidos del servidor: " + flujoEntrada.readUTF());
        System.out.println("Datos recibidos del servidor: " + flujoEntrada.readUTF());
    }

    private void crearConexion() throws IOException {
        socketComunicacion = new Socket(host, puerto);
        System.out.println("Conectado al servidor en " + host + ":" + puerto);
    }
}
