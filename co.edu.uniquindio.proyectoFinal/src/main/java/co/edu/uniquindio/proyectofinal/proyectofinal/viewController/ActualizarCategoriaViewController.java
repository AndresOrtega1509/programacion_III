package co.edu.uniquindio.proyectofinal.proyectofinal.viewController;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.ActualizarCategoriaController;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Categoria;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Sesion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ActualizarCategoriaViewController {

    @FXML
    private TextField txtIdCategoria;
    @FXML
    private TextField txtNombreCategoria;
    @FXML
    private TextField txtDescripcion;
    ActualizarCategoriaController actualizarCategoriaController;
    private final Sesion sesion = Sesion.getInstancia();
    private Categoria categoria;

    public ActualizarCategoriaViewController() {
        actualizarCategoriaController = new ActualizarCategoriaController();
    }

    public void inicializarValores(Categoria categoria) {
        this.categoria = categoria;
        txtIdCategoria.setText(categoria.getIdCategoria());
        txtNombreCategoria.setText(categoria.getNombreCategoria());
        txtDescripcion.setText(categoria.getDescripcionCategoria());
    }

    public void actualizarCategoria(ActionEvent actionEvent) {
        try {
            actualizarCategoriaController.actualizarCategoria(sesion.getUsuario(), categoria.getIdCategoria(),
                    txtNombreCategoria.getText(), txtDescripcion.getText());
            cerrarVentana();
            mostrarMensaje("Categoria","Notificación Usuario", "La categoria se ha actualizado correctamente",
                    Alert.AlertType.INFORMATION);
        }catch (Exception e) {
            mostrarMensaje("Categoria","Notificación Usuario", e.getMessage(),
                    Alert.AlertType.ERROR);
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

        Stage stage = (Stage) txtDescripcion.getScene().getWindow();
        stage.close();
    }
}
