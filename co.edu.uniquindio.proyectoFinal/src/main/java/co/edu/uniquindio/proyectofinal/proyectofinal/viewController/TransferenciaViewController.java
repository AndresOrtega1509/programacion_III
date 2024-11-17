package co.edu.uniquindio.proyectofinal.proyectofinal.viewController;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.TransferenciaController;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Sesion;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Transaccion;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoTransaccion;
import co.edu.uniquindio.proyectofinal.proyectofinal.viewController.observer.ObservadorTransaccion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Optional;

public class TransferenciaViewController {

    @FXML
    private TextField txtCuenta;
    @FXML
    private TextField txtMonto;
    @FXML
    private ComboBox<String> cbTipoTransaccion;
    @FXML
    private TextField txtDescripcion;
    private ObservadorTransaccion observadorTransaccion;
    private final Sesion sesion = Sesion.getInstancia();
    TransferenciaController transferenciaController;

    @FXML
    public void initialize() {
        cbTipoTransaccion.getItems().addAll("TRANSFERENCIA", "RETIRO");
        transferenciaController = new TransferenciaController();
    }

    public void transferir(ActionEvent actionEvent) {

        try {
            if (validarDatos()) {
                String tipoSeleccionado = cbTipoTransaccion.getSelectionModel().getSelectedItem();
                float monto = Float.parseFloat(txtMonto.getText());
                TipoTransaccion tipoTransaccion = TipoTransaccion.valueOf(cbTipoTransaccion.getValue());
                Transaccion transaccion = null;

                if ("RETIRO".equals(tipoSeleccionado)) {
                    transferenciaController.realizarTransaccion(sesion.getCuenta().getNumeroCuenta(), "", monto, tipoTransaccion, txtDescripcion.getText());
                } else {
                    transaccion = transferenciaController.realizarTransaccion(
                            sesion.getCuenta().getNumeroCuenta(),
                            txtCuenta.getText(),
                            monto,
                            tipoTransaccion,
                            txtDescripcion.getText()
                    );
                }

                observadorTransaccion.notificarTransaccion();
                mostrarMensaje("Notificación usuario", "Transacción exitosa", "La transferencia ha sido procesada correctamente", Alert.AlertType.INFORMATION);

                // Realiza la navegación si es una transferencia
                if (transaccion != null) {
                    if(mostrarMensajeConfirmacion("¿Desea crear una categoria para su transferencia?")){
                        navegarVentana("/co/edu/uniquindio/proyectofinal/proyectofinal/crearCategoria.fxml", "Banco - Categoria - Transaccion", transaccion.getIdTransaccion());
                    }
                }

                cerrarVentana();
            }
        } catch (Exception e) {
            mostrarMensaje("Notificación usuario", "Transacción rechazada", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validarDatos() {

        String mensaje = "";
        // Validar que el tipo de transacción esté seleccionado
        if (cbTipoTransaccion.getValue() == null) {
            mensaje += "El tipo de transacción es obligatorio \n";
            if (txtCuenta == null || txtCuenta.getText().isEmpty()){
                mensaje += "La cuenta de destino es obligatoria \n";
            }
        } else if ("TRANSFERENCIA".equals(cbTipoTransaccion.getValue())) {
            // Si el tipo de transacción es "TRANSFERENCIA", validar la cuenta de destino
            if (txtCuenta == null || txtCuenta.getText().isEmpty()) {
                mensaje += "La cuenta de destino es obligatoria \n";
            }
        }
        if (txtMonto == null || txtMonto.getText().isEmpty()) {
            mensaje += "El monto es obligatorio \n";
        } else {
            try {
                float monto = Float.parseFloat(txtMonto.getText());
                if (monto <= 0) {
                    mensaje += "El monto es invalido \n";
                }
            } catch (NumberFormatException e) {
                mensaje += "El monto debe ser un número válido \n";
            }
        }

        if (mensaje.isEmpty()) {
            return true;
        } else {
            mostrarMensaje("Notificación Usuario", "Datos invalidos", mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }

    private void cerrarVentana() {
        Stage stage = (Stage) txtMonto.getScene().getWindow();
        stage.close();
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    public void inicializarObservable(ObservadorTransaccion observadorTransaccion) {
        this.observadorTransaccion = observadorTransaccion;
    }

    public void seleccionarTipoTransaccion(ActionEvent actionEvent) {
        if (cbTipoTransaccion.getSelectionModel().getSelectedItem().equals("RETIRO")) {
            txtCuenta.setDisable(true);
            if (!txtCuenta.getText().isEmpty()) {
                txtCuenta.clear();
            }
        }else {
            txtCuenta.setDisable(false);
        }
    }


    private FXMLLoader navegarVentana(String nombreArchivoFxml, String tituloVentana, String idTransaccion) throws Exception{

        // Cargar la vista
        FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreArchivoFxml));
        Parent root = loader.load();

        // Obtener el controlador de la nueva ventana
        CategoriaViewController controller = loader.getController();
        controller.inicializarValores(idTransaccion);

        // Crear la escena
        Scene scene = new Scene(root);

        // Crear un nuevo escenario (ventana)
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(tituloVentana);

        // Mostrar la nueva ventana
        stage.show();

        return loader;
    }
}
