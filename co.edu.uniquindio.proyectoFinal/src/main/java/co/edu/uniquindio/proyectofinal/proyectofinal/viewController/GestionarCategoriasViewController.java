package co.edu.uniquindio.proyectofinal.proyectofinal.viewController;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.GestionarCategoriasController;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Categoria;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Sesion;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Usuario;
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

public class GestionarCategoriasViewController {

    @FXML
    private TableView<Categoria> tablaCategorias;

    @FXML
    private TableColumn<Categoria, String> tcDescripcion;

    @FXML
    private TableColumn<Categoria, String> tcIdCategoria;

    @FXML
    private TableColumn<Categoria, String> tcNombreCategoria;
    GestionarCategoriasController gestionarCategoriasController;
    private final Sesion sesion = Sesion.getInstancia();
    private Categoria categoria;

    public GestionarCategoriasViewController() {
        gestionarCategoriasController = new GestionarCategoriasController();
    }

    public void initialize(){

        tcIdCategoria.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getIdCategoria()));
        tcDescripcion.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getDescripcionCategoria()));
        tcNombreCategoria.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getNombreCategoria()));
        mostrarCategorias();
        // Agregar el evento de un clic a la tabla
        tablaCategorias.setRowFactory(tv -> {
            TableRow<Categoria> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1 && (!row.isEmpty())) {
                    Categoria categoria = row.getItem();
                    this.categoria = categoria;

                }
            });
            return row;
        });

    }

    private void eliminarCategoria(Categoria categoria) {

        try {
            gestionarCategoriasController.eliminarCategoria(sesion.getUsuario(), categoria);
            cerrarVentana();
            mostrarMensaje("Categoria","Notificación Usuario", "La categoria se ha eliminado correctamente",
                    Alert.AlertType.INFORMATION);
        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }

    private void cerrarVentana() {

        Stage stage = (Stage) tablaCategorias.getScene().getWindow();
        stage.close();
    }


    private void mostrarCategorias() {
        tablaCategorias.setItems(FXCollections.observableArrayList(sesion.getUsuario().getListaCategorias()));
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    public void IrActualizarCategoria(ActionEvent actionEvent) {
        if (categoria != null) {
            cerrarVentana();
            navegarVentana("/co/edu/uniquindio/proyectofinal/proyectofinal/actualizarCategoria.fxml", "Banco - Actualización", categoria);
        }else {
            mostrarMensaje("Categoria","Notificación Usuario", "Seleccione una categoria",
                    Alert.AlertType.WARNING);
        }

    }

    public void eliminarCategoria(ActionEvent actionEvent) {

        if (categoria != null) {
            eliminarCategoria(categoria);
        }else {
            mostrarMensaje("Categoria","Notificación Usuario", "Seleccione una categoria",
                    Alert.AlertType.WARNING);
        }
    }

    private void navegarVentana(String nombreArchivoFxml, String tituloVentana, Categoria categoria) {
        try {

            // Cargar la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreArchivoFxml));
            Parent root = loader.load();


            // Obtener el controlador de la nueva ventana
            ActualizarCategoriaViewController controller = loader.getController();
            controller.inicializarValores(categoria);

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
