package co.edu.uniquindio.restaurante.restaurante;

import co.edu.uniquindio.restaurante.restaurante.controller.ModelFactoryController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.desktop.QuitEvent;

import static co.edu.uniquindio.restaurante.restaurante.util.Constantes.QUEUE_NUEVA_PUBLICACION;


public class PedidoViewController {
    @FXML
    private TextArea txtMensaje;
    @FXML
    private TextField txtMensajeAEnviar;
    private static final String QUEUE_NAME = QUEUE_NUEVA_PUBLICACION;

    private final ModelFactoryController modelFactoryController;

    public PedidoViewController() {
        modelFactoryController = ModelFactoryController.getInstance();
        modelFactoryController.setPedidoViewController(this);
    }

    @FXML
    public void enviarMensaje(ActionEvent actionEvent) {
        // Solo enviar mensaje si esta instancia es el productor
        if (Main.rol.equalsIgnoreCase("productor")) {
            txtMensaje.appendText(txtMensajeAEnviar.getText() + "\n");
            System.out.println("Enviando mensaje...");
            modelFactoryController.producirMensaje(QUEUE_NAME, txtMensajeAEnviar.getText());
        }
    }

    public void actualizarMensaje(String mensaje) {
        txtMensaje.appendText(mensaje + "\n");
    }
}
