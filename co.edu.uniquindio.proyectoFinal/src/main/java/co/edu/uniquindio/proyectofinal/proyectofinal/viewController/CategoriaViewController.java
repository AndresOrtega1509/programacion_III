package co.edu.uniquindio.proyectofinal.proyectofinal.viewController;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.CategoriaController;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Categoria;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Sesion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CategoriaViewController {

    @FXML
    private TextField txtCategoria;

    @FXML
    private TextField txtDescripcion;

    CategoriaController categoriaController;
    private String idTransaccion;
    private final Sesion sesion = Sesion.getInstancia();


    public CategoriaViewController() {
        categoriaController = new CategoriaController();
    }

    public void Agregar(ActionEvent actionEvent) {

        try {
            Categoria categoria = categoriaController.agregarCategoria(sesion.getUsuario(),txtCategoria.getText(), txtDescripcion.getText(), idTransaccion );
            mostrarMensaje("Categoria","Notificación Usuario","Categoria creada con exito",
                    Alert.AlertType.INFORMATION);
            System.out.println(categoria);
            cerrarVentana();
        } catch (Exception e) {
            mostrarMensaje("Categoria","Notificación Usuario",e.getMessage(),
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

        Stage stage = (Stage) txtCategoria.getScene().getWindow();
        stage.close();
    }

    public void inicializarValores(String idTransaccion) {
        this.idTransaccion = idTransaccion;

    }
}
