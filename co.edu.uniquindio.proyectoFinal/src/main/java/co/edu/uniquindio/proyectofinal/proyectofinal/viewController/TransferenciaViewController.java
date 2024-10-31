package co.edu.uniquindio.proyectofinal.proyectofinal.viewController;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoTransaccion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class TransferenciaViewController {

    @FXML
    private TextField txtCuenta;
    @FXML
    private TextField txtMonto;
    @FXML
    private TextField txtValor;
    @FXML
    private ComboBox<TipoTransaccion> cbTipoTransaccion;
    @FXML
    private TextField txtDescripcion;

    @FXML
    public void initialize() {
        cbTipoTransaccion.getItems().addAll(TipoTransaccion.values());
    }

    public void transferir(ActionEvent actionEvent) {
    }
}
