package co.edu.uniquindio.proyectofinal.proyectofinal.viewController;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.GestionarPresupuestosController;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Categoria;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Presupuesto;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Sesion;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import java.io.IOException;

public class GestionarPresupuestoViewController {

    @FXML
    private TableView<Presupuesto> tablaPresupuestos;

    @FXML
    private TableColumn<Presupuesto, String> tcIdPresupuesto;

    @FXML
    private TableColumn<Presupuesto, String> tcMontoAsignado;

    @FXML
    private TableColumn<Presupuesto, String> tcMontoGastado;

    @FXML
    private TableColumn<Presupuesto, String> tcNombrePresupuesto;
    private final Sesion sesion = Sesion.getInstancia();
    GestionarPresupuestosController gestionarPresupuestosController;
    private Presupuesto presupuesto;

    public GestionarPresupuestoViewController() {
        gestionarPresupuestosController = new GestionarPresupuestosController();
    }

    @FXML
    void initialize() {
        tcIdPresupuesto.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getIdPresupuesto()));
        tcNombrePresupuesto.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getNombre()));
        tcMontoAsignado.setCellValueFactory(CellData -> new SimpleStringProperty("" + CellData.getValue().getMontoAsignado()));
        tcMontoGastado.setCellValueFactory(CellData -> new SimpleStringProperty("" + CellData.getValue().getMontoGastado()));
        mostrarPresupuestos(sesion.getUsuario().getIdUsuario());

        // Agregar el evento de un clic a la tabla
        tablaPresupuestos.setRowFactory(tv -> {
            TableRow<Presupuesto> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1 && (!row.isEmpty())) {
                    Presupuesto presupuesto = row.getItem();
                    this.presupuesto = presupuesto;

                }
            });
            return row;
        });
    }

    private void mostrarPresupuestos(String idUsuario) {
        tablaPresupuestos.setItems(FXCollections.observableArrayList(gestionarPresupuestosController.
                obtenerListaPresupuestosUsuario(idUsuario)));
    }

    @FXML
    void IrActualizarPresupuesto(ActionEvent event) throws IOException {
        if (presupuesto != null) {
            cerrarVentana();
            FXMLLoader loader = navegarVentana(
                    "/co/edu/uniquindio/proyectofinal/proyectofinal/actualizarPresupuesto.fxml",
                    "Banco - Actualizar Datos");

            ActualizarPresupuestoViewController controlador = loader.getController();
            controlador.inicializarValores(presupuesto);
        }else {
            mostrarMensaje("Presupuesto","Notificación Usuario",
                    "Seleccione un presupuesto para actualizar",
                    Alert.AlertType.WARNING);
        }
    }

    @FXML
    void IrCrearPresupuesto(ActionEvent event) throws IOException {

        cerrarVentana();
        navegarVentana("/co/edu/uniquindio/proyectofinal/proyectofinal/crearPresupuesto.fxml",
                "Banco - Presupuesto");
    }

    private void cerrarVentana() {

        Stage stage = (Stage) tablaPresupuestos.getScene().getWindow();
        stage.close();
    }

    private FXMLLoader  navegarVentana(String nombreArchivoFxml, String tituloVentana) throws IOException {
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

        return loader;
    }

    @FXML
    void eliminarPresupuesto(ActionEvent event) {

        try {
            if (presupuesto != null) {
                gestionarPresupuestosController.eliminarPresupuesto(presupuesto);
                cerrarVentana();
                mostrarMensaje("Presupuesto","Notificación Usuario", "El presupuesto se ha eliminado correctamente",
                        Alert.AlertType.INFORMATION);
            }else {
                mostrarMensaje("Presupuesto","Notificación Usuario",
                        "Seleccione un presupuesto para eliminar",
                        Alert.AlertType.WARNING);
            }

        }catch (Exception e) {
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
