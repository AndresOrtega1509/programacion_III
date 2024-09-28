package co.edu.uniquindio.proyectofinal.proyectofinal.viewController;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.PanelUsuarioController;
import co.edu.uniquindio.proyectofinal.proyectofinal.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Cuenta;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Sesion;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Transaccion;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Usuario;
import co.edu.uniquindio.proyectofinal.proyectofinal.viewController.observer.ObservadorActualizar;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Optional;

public class PanelUsuarioViewController implements ObservadorActualizar {

    @FXML
    private Label lblNombre;
    @FXML
    private Label lblCuenta;
    @FXML
    private TableView<Transaccion> tablaTransacciones;
    @FXML
    private TableColumn<Transaccion ,String> txtIdTransaccion;
    @FXML
    private TableColumn<Transaccion, String> txtFecha;
    @FXML
    private TableColumn<Transaccion ,String> txtMonto;
    @FXML
    private TableColumn<Transaccion, String> txtUsuario;
    @FXML
    private TableColumn<Transaccion, String> txtTipoTransaccion;

    ObservableList<UsuarioDto> listaUsuariosDto = FXCollections.observableArrayList();

    private final Sesion sesion = Sesion.getInstancia();
    PanelUsuarioController panelUsuarioController;
    private Cuenta cuenta;


    @FXML
    public void initialize() {
        panelUsuarioController = new PanelUsuarioController();
        Usuario usuario = sesion.getUsuario();
        inicializarValores(usuario);

        txtIdTransaccion.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getIdTransaccion()));
        txtFecha.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getFecha().toString()));
        txtMonto.setCellValueFactory(CellData -> new SimpleStringProperty("" + CellData.getValue().getMonto()));
        txtUsuario.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getUsuario().getNombre()));
        txtTipoTransaccion.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getTipoTransaccion().toString()));
    }


    public void inicializarValores(Usuario usuario) {

        try {
            if(usuario != null){
                cuenta = panelUsuarioController.consultarCuenta(usuario.getIdUsuario(), 0);
                sesion.setCuenta(cuenta);

                lblNombre.setText(usuario.getNombre() +", bienvenido a su banco, aquí podra ver sus transacciones");
                lblCuenta.setText("Nro. Cuenta: " + cuenta.getNumeroCuenta());
                //consultarTransacciones();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consultarSaldo(ActionEvent actionEvent) {
    }

    public void irTransferencia(ActionEvent actionEvent) {
    }

    public void irActualizar(ActionEvent actionEvent) throws Exception {

        FXMLLoader loader = navegarVentana("/co/edu/uniquindio/proyectofinal/proyectofinal/actualizar.fxml",
                "Banco - Actualizar Datos");

        ActualizarViewController controlador = loader.getController();
        controlador.inicializarObservable(this);

    }

    public void cerrarSesion(ActionEvent actionEvent) throws Exception {

        mostrarMensaje("Notificacion Usuario","Cerrar Sesion","Se ha cerrado la sesión correctamente", Alert.AlertType.INFORMATION);
        Stage stage = (Stage) tablaTransacciones.getScene().getWindow();
        sesion.cerrarSesion();
        stage.close();

        navegarVentana("/co/edu/uniquindio/proyectofinal/proyectofinal/login.fxml", "Banco - Iniciar Sesión");
    }

    private FXMLLoader navegarVentana(String nombreArchivoFxml, String tituloVentana) throws Exception{

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

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    @Override
    public void notificarActualizacion() {
        lblNombre.setText(sesion.getUsuario().getNombre() + ", bienvenido a su billetera virtual, aquí podra ver sus transacciones");
    }

    public void irCrearCuentaBancaria(ActionEvent actionEvent) throws Exception {
        navegarVentana("/co/edu/uniquindio/proyectofinal/proyectofinal/cuenta.fxml", "Banco - creación cuenta bancaria");
    }

    public void eliminar(ActionEvent actionEvent) throws Exception {
        if(mostrarMensajeConfirmacion("¿Estas seguro de elmininar su cuenta?")){

            boolean clienteEliminado = panelUsuarioController.eliminarUsuario(sesion.getUsuario().getIdUsuario());
            boolean cuentaEliminada = panelUsuarioController.eliminarCuenta(sesion.getCuenta().getIdCuenta());
            if(clienteEliminado){

            }
            cerrarVentana();
        }
                
    }

    private void cerrarVentana() {
        Stage stage = (Stage) lblCuenta.getScene().getWindow();
        stage.close();
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }
}
