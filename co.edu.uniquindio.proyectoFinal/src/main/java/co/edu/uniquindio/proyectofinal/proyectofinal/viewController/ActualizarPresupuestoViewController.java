package co.edu.uniquindio.proyectofinal.proyectofinal.viewController;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.ActualizarPresupuestoController;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Presupuesto;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Sesion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ActualizarPresupuestoViewController {

    @FXML
    private TextField txtIdPresupuesto;

    @FXML
    private TextField txtMontoAsignado;

    @FXML
    private TextField txtMontoGastado;

    @FXML
    private TextField txtNombrePresupuesto;
    private final Sesion sesion = Sesion.getInstancia();
    ActualizarPresupuestoController actualizarPresupuestoController;
    private Presupuesto presupuesto;


    public void inicializarValores(Presupuesto presupuesto) {
        actualizarPresupuestoController = new ActualizarPresupuestoController();
        this.presupuesto = presupuesto;
        String montoGastado = String.valueOf(presupuesto.getMontoGastado());
        String montoAsignado = String.valueOf(presupuesto.getMontoAsignado());
        txtIdPresupuesto.setText(presupuesto.getIdPresupuesto());
        txtMontoGastado.setText(montoGastado);
        txtMontoAsignado.setText(montoAsignado);
        txtNombrePresupuesto.setText(presupuesto.getNombre());
    }

    public void actualizarPresupuesto(ActionEvent actionEvent) {
        try {
            if (validarDatos()){
                float montoAsignado = Float.parseFloat(txtMontoAsignado.getText());
                float montoGastado = Float.parseFloat(txtMontoGastado.getText());
                actualizarPresupuestoController.actualizarPresupuesto(sesion.getUsuario().getIdUsuario(),
                        txtNombrePresupuesto.getText(),montoAsignado, montoGastado, presupuesto.getIdPresupuesto());
                cerrarVentana();
                mostrarMensaje("Presupuesto","Notificación Usuario", "El presupuesto se ha actualizado correctamente",
                        Alert.AlertType.INFORMATION);
            }

        }catch (Exception e) {
            mostrarMensaje("Presupuesto","Notificación Usuario", e.getMessage(),
                    Alert.AlertType.ERROR);
        }
    }

    private boolean validarDatos() {

        String mensaje = "";
        if(txtMontoAsignado.getText().isEmpty())
            mensaje += "El monto asignado es obligatorio \n" ;
        if(txtMontoGastado.getText().isEmpty())
            mensaje += "El monto gastado es obligatorio \n" ;
        if(mensaje.isEmpty()){
            return true;
        }else{
            mostrarMensaje("Notificación Usuario","Datos invalidos",mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private void cerrarVentana() {

        Stage stage = (Stage) txtIdPresupuesto.getScene().getWindow();
        stage.close();
    }
}
