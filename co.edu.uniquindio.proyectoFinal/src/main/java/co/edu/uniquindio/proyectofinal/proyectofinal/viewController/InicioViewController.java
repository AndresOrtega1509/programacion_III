package co.edu.uniquindio.proyectofinal.proyectofinal.viewController;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.InicioController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InicioViewController {
    
    InicioController inicioController;

    @FXML
    void initialize() {

         inicioController = new InicioController();

    }

    public void irRegistroUsuario(ActionEvent actionEvent) {

        inicioController.navegarVentana("/co/edu/uniquindio/proyectofinal/proyectofinal/registro.fxml", "Registro - Usuario");
    }

    public void irIniciarSesion(ActionEvent actionEvent) {

        inicioController.navegarVentana("/co/edu/uniquindio/proyectofinal/proyectofinal/login.fxml", "Login - Usuario");
    }
}
