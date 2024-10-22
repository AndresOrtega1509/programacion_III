package co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RestauranteViewController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtContrasenia;

    ModelFactoryController2 modelFactoryController2;

    public RestauranteViewController() {
        modelFactoryController2 = ModelFactoryController2.getInstance();
    }

    public void logiarse(ActionEvent actionEvent) {
        try {

            boolean acceso = modelFactoryController2.verificarInicioSesion(txtNombre.getText(), txtContrasenia.getText());

            if (acceso) {
                System.out.println("Acceso permitido");
            }else {
                System.out.println("Acceso no permitido");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
