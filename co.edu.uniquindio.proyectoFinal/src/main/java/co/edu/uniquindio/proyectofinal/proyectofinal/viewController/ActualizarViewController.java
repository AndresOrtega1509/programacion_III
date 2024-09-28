package co.edu.uniquindio.proyectofinal.proyectofinal.viewController;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.ActualizarController;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Sesion;
import co.edu.uniquindio.proyectofinal.proyectofinal.viewController.observer.ObservadorActualizar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ActualizarViewController {

    ActualizarController actualizarController;

    @FXML
    private TextField txtIdUsuario;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtNumeroTelefono;
    @FXML
    private TextField txtDireccion;
    private final Sesion sesion = Sesion.getInstancia();
    private ObservadorActualizar observadorActualizar;

    @FXML
    public void initialize() {
        actualizarController = new ActualizarController();

        String nombre = sesion.getUsuario().getNombre();
        txtNombre.setText(nombre);
        String numeroIdentificacion = sesion.getUsuario().getIdUsuario();
        txtIdUsuario.setText(numeroIdentificacion);
        String correo = sesion.getUsuario().getCorreoElectronico();
        txtCorreo.setText(correo);
        String numeroTelefono = sesion.getUsuario().getNumeroTelefono();
        txtNumeroTelefono.setText(numeroTelefono);
        String direccion = sesion.getUsuario().getDireccion();
        txtDireccion.setText(direccion);
    }
    public void actualizarUsuario(ActionEvent actionEvent) {

        try {
            actualizarController.actualizarUsuario(txtIdUsuario.getText(), txtNombre.getText(), txtCorreo.getText(),
                    txtNumeroTelefono.getText(), txtDireccion.getText());
            observadorActualizar.notificarActualizacion();
            mostrarMensaje("Notificacion - Usuario","Actualización Usuario",
                    "El usuario ha sido actualizado con exito",
                    Alert.AlertType.INFORMATION);
            cerrarVentana();
        }catch (Exception e) {
            mostrarMensaje("Notificacion - Usuario","Actualización Usuario",
                    e.getMessage(),
                    Alert.AlertType.WARNING);
        }
    }

    private void cerrarVentana() {

        Stage stage = (Stage) txtNombre.getScene().getWindow();
        stage.close();
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    public void inicializarObservable(ObservadorActualizar observadorActualizar) {

        this.observadorActualizar = observadorActualizar;
    }
}
