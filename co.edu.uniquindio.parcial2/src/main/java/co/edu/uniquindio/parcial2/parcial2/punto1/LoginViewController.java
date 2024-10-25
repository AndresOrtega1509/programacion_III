package co.edu.uniquindio.parcial2.parcial2.punto1;

import co.edu.uniquindio.parcial2.parcial2.punto1.utils.ArchivoUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginViewController {

    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtContrasenia;

    ModelFactoryController modelFactoryController;

    public LoginViewController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

    @FXML
    public void logiarse(ActionEvent actionEvent) {

        try {

            boolean acceso = modelFactoryController.verificarInicioSesion(txtUsuario.getText(), txtContrasenia.getText());

            if (acceso) {
                mostrarMensaje("Notificacion - Usuario","Inicio de sesión exitoso", "Los datos del usuario son validos",
                        Alert.AlertType.INFORMATION);
                navegarVentana("/co/edu/uniquindio/parcial2/parcial2/gestion.fxml",
                        "Gestion");
            }else {

                mostrarMensaje("Notificacion - Usuario","Inicio de sesión no exitoso",
                        "Los datos ingresados no coinciden", Alert.AlertType.ERROR);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private void navegarVentana(String nombreArchivoFxml, String tituloVentana) {

        try {

            // Cargar la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreArchivoFxml));
            Parent root = loader.load();

            // Crear la escena
            Scene scene = new Scene(root);

            // Crear un nuevo escenario (ventana)
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(tituloVentana);

            // Mostrar la nueva ventana
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
