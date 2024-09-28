package co.edu.uniquindio.proyectofinal.proyectofinal.viewController;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.LoginController;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Sesion;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginViewController {

    LoginController loginController;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtIdUsuario;

    @FXML
    void initialize() {
        loginController = new LoginController();
    }

    public void logiarse(ActionEvent actionEvent) {

        try {
            Usuario usuario = loginController.validarInicioSesion(
                    txtNombre.getText(),
                    txtIdUsuario.getText());

            if (usuario != null) {
                Sesion sesion = Sesion.getInstancia();
                sesion.setUsuario(usuario);

                mostrarMensaje("Notificacion - Usuario","Inicio de sesión exitoso", "Los datos del usuario son validos",
                        Alert.AlertType.INFORMATION);
                cerrarVentana();

                if (usuario.isTieneCuenta()){
                    navegarVentanaPanel("/co/edu/uniquindio/proyectofinal/proyectofinal/panelUsuario.fxml", "Banco - Panel Principal", usuario);
                }else {
                    navegarVentanaCuenta("/co/edu/uniquindio/proyectofinal/proyectofinal/cuenta.fxml", "Banco - creación cuenta bancaria", usuario);
                }
            }

        } catch (Exception e) {
            mostrarMensaje("Notificacion - Usuario","Inicio de sesión no exitoso",
                    e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void cerrarVentana() {

        Stage stage = (Stage) txtIdUsuario.getScene().getWindow();
        stage.close();
    }

    private void navegarVentanaCuenta(String nombreArchivoFxml, String tituloVentana, Usuario usuario) {

        try {

            // Cargar la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreArchivoFxml));
            Parent root = loader.load();


            // Obtener el controlador de la nueva ventana
            CuentaViewController controller = loader.getController();
            controller.inicializarValores(usuario);

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

    private void navegarVentanaPanel(String nombreArchivoFxml, String tituloVentana, Usuario usuario) {

        try {

            // Cargar la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreArchivoFxml));
            Parent root = loader.load();


            // Obtener el controlador de la nueva ventana
            PanelUsuarioViewController controller = loader.getController();
            controller.inicializarValores(usuario);

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

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }
}
