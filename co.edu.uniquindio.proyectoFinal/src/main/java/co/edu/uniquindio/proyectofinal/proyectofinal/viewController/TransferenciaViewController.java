package co.edu.uniquindio.proyectofinal.proyectofinal.viewController;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.TransferenciaController;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Sesion;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoTransaccion;
import co.edu.uniquindio.proyectofinal.proyectofinal.viewController.observer.ObservadorTransaccion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
            if (validarDatos()){
                float monto = Float.parseFloat(txtMonto.getText());
                TipoTransaccion tipoTransaccion = TipoTransaccion.valueOf(cbTipoTransaccion.getValue());
                transferenciaController.realizarTransaccion(sesion.getCuenta().getNumeroCuenta(),txtCuenta.getText(),
                        monto, tipoTransaccion, txtDescripcion.getText());
                observadorTransaccion.notificarTransaccion();
                mostrarMensaje("Notificación usuario", "Transacción exitosa", "La transferencia ha sido procesada correctamente",
                        Alert.AlertType.INFORMATION);
                cerrarVentana();
            }


        } catch (Exception e) {
            mostrarMensaje("Notificación usuario", "Transacción rechazada", e.getMessage(),
                    Alert.AlertType.ERROR);
        }
    }

    private boolean validarDatos() {

        float monto = Float.parseFloat(txtMonto.getText());

        String mensaje = "";
        if(txtCuenta == null || txtCuenta.getText().isEmpty())
            mensaje += "La cuenta de destino es obligatoria \n" ;
        if(txtMonto == null || txtMonto.getText().isEmpty())
            mensaje += "El monto es obligatorio \n" ;
        if(monto <= 0)
            mensaje += "El monto es invalido \n" ;
        if(cbTipoTransaccion.getValue() == null)
            mensaje += "El tipo de transación es obligatorio \n" ;
        if(mensaje.isEmpty()){
            return true;
        }else{
            mostrarMensaje("Notificación Usuario","Datos invalidos",mensaje, Alert.AlertType.WARNING);
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

}
