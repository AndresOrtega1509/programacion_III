package co.edu.uniquindio.proyectofinal.proyectofinal.viewController;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.CrearPresupuestoController;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Categoria;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Presupuesto;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Sesion;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Usuario;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

public class CrearPresupuestoViewController {

    @FXML
    private TableView<Categoria> tableCategoria;

    @FXML
    private TableColumn<Categoria, String> tcIdCategoria;

    @FXML
    private TableColumn<Categoria, String> tcNombreCategoria;

    @FXML
    private TextField txtMontoAsignado;

    @FXML
    private TextField txtNombrePresupuesto;
    private Categoria categoria;
    CrearPresupuestoController crearPresupuestoController;
    private final Sesion sesion = Sesion.getInstancia();

    public CrearPresupuestoViewController() {
        crearPresupuestoController = new CrearPresupuestoController();
    }

    public void initialize() {
        tcIdCategoria.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getIdCategoria()));
        tcNombreCategoria.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getNombreCategoria()));
        txtNombrePresupuesto.setDisable(true);
        mostrarCategorias();
        // Agregar el evento de doble clic a la tabla
        tableCategoria.setRowFactory(tv -> {
            TableRow<Categoria> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1 && (!row.isEmpty())) {
                    Categoria categoria = row.getItem();
                    this.categoria = categoria;
                    txtNombrePresupuesto.setText(categoria.getNombreCategoria());

                }
            });
            return row;
        });
    }

    private void mostrarCategorias() {
        Usuario usuario = sesion.getUsuario();

        tableCategoria.setItems(FXCollections.observableArrayList(usuario.obtenerCategoriasUnicas()));
    }

    @FXML
    public void crearPresupuesto(ActionEvent actionEvent) {

        try {
            if (validarDatos()) {

                float montoAsignado = Float.parseFloat(txtMontoAsignado.getText());
                Presupuesto presupuesto = crearPresupuestoController.agregarPresupuesto(sesion.getUsuario().getIdUsuario(), txtNombrePresupuesto.getText(),
                        montoAsignado, categoria);
                System.out.println(presupuesto);
                mostrarMensaje("Categoria", "Notificación Usuario", "El presupuesto se ha agregado correctamente",
                        Alert.AlertType.INFORMATION);
                cerrarVentana();
            }

        }catch (Exception e){
            mostrarMensaje("Categoria","Notificación Usuario", e.getMessage(), Alert.AlertType.ERROR);
        }

    }

    private boolean validarDatos() {
        String mensaje = "";
        if(txtMontoAsignado.getText().isEmpty())
            mensaje += "El monto es obligatorio \n" ;
        if(categoria == null)
            mensaje += "Seleccione la categoria \n" ;
        if(mensaje.isEmpty()){
            return true;
        }else{
            mostrarMensaje("Notificación Usuario","Datos invalidos",mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }

    private void cerrarVentana() {

        Stage stage = (Stage) txtNombrePresupuesto.getScene().getWindow();
        stage.close();
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }
}
