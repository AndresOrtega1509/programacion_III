package co.edu.uniquindio.restaurante.restaurante.controller;

import co.edu.uniquindio.restaurante.restaurante.PedidoViewController;
import co.edu.uniquindio.restaurante.restaurante.config.RabbitFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import javafx.application.Platform;
import javafx.scene.control.Alert;

import java.nio.charset.StandardCharsets;

import static co.edu.uniquindio.restaurante.restaurante.util.Constantes.QUEUE_NUEVA_PUBLICACION;

public class ModelFactoryController implements Runnable {


    private static final String QUEUE_NAME = QUEUE_NUEVA_PUBLICACION;

    private Thread hiloServicioConsumer1;
    private RabbitFactory rabbitFactory;
    private ConnectionFactory connectionFactory;
    private String mensajeRecibido = null;

    private PedidoViewController pedidoViewController;

    public ModelFactoryController() {
        initRabbitConnection();
    }

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    private void initRabbitConnection() {
        rabbitFactory = new RabbitFactory();
        connectionFactory = rabbitFactory.getConnectionFactory();
    }

    public void setPedidoViewController(PedidoViewController controller) {
        this.pedidoViewController = controller;
    }

    public void producirMensaje(String queue, String message) {
        try (Connection connection = connectionFactory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(queue, false, false, false, null);
            channel.basicPublish("", queue, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + message + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consumirMensajesServicio1() {
        hiloServicioConsumer1 = new Thread(this);
        hiloServicioConsumer1.start();
    }

    @Override
    public void run() {
        consumirMensajes();
    }

    private void consumirMensajes() {
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                mensajeRecibido = message;
                System.out.println("Mensaje recibido: " + message);

                Platform.runLater(() -> {
                    mostrarAlerta("Notificación", "Mensaje recibido", "Ha recibido un mensaje: " + message, Alert.AlertType.INFORMATION);
                });

                if (pedidoViewController != null) {
                    Platform.runLater(() -> pedidoViewController.actualizarMensaje(message));
                }
            };
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostrarAlerta(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    public String getMensajeRecibido() {
        return mensajeRecibido;
    }
}
