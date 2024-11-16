package co.edu.uniquindio.proyectofinal.proyectofinal.viewController;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.Presupuesto;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class GestionarPresupuestoViewController {

    @FXML
    private TableView<Presupuesto> tablaCategorias;

    @FXML
    private TableColumn<Presupuesto, String> tcIdPresupuesto;

    @FXML
    private TableColumn<Presupuesto, String> tcMontoAsignado;

    @FXML
    private TableColumn<Presupuesto, String> tcMontoGastado;

    @FXML
    private TableColumn<Presupuesto, String> tcNombrePresupuesto;

    @FXML
    void IrActualizarPresupuesto(ActionEvent event) {

    }

    @FXML
    void IrCrearPresupuesto(ActionEvent event) {

    }

    @FXML
    void eliminarPresupuesto(ActionEvent event) {

    }

    @FXML
    void initialize() {
        tcIdPresupuesto.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getIdPresupuesto()));
        tcNombrePresupuesto.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getNombre()));
        tcMontoAsignado.setCellValueFactory(CellData -> new SimpleStringProperty("" + CellData.getValue().getMontoAsignado()));
        tcMontoGastado.setCellValueFactory(CellData -> new SimpleStringProperty("" + CellData.getValue().getMontoGastado()));
    }
}
