package co.edu.uniquindio.proyectofinal.proyectofinal.viewController;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.PanelUsuarioController;
import co.edu.uniquindio.proyectofinal.proyectofinal.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Cuenta;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Sesion;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Transaccion;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Usuario;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoTransaccion;
import co.edu.uniquindio.proyectofinal.proyectofinal.viewController.observer.ObservadorActualizar;
import co.edu.uniquindio.proyectofinal.proyectofinal.viewController.observer.ObservadorComboBoxCuentas;
import co.edu.uniquindio.proyectofinal.proyectofinal.viewController.observer.ObservadorTransaccion;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class PanelUsuarioViewController implements ObservadorActualizar, ObservadorTransaccion, ObservadorComboBoxCuentas {

    @FXML
    private Label lblNombre;
    @FXML
    private Label lblCuenta;
    @FXML
    public ComboBox<Cuenta> cbCuentas = new ComboBox<>();
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
    @FXML
    private TableColumn<Transaccion, String> txtDescripcion;
    @FXML
    private TextField txtNombreCategoria;

    @FXML
    private ComboBox<TipoTransaccion> comboTipoTransaccion;

    @FXML
    private DatePicker dpFechaTransaccion;
    private TipoTransaccion tipoTransaccion;
    private LocalDateTime fechaTransaccion;

    ObservableList<UsuarioDto> listaUsuariosDto = FXCollections.observableArrayList();

    private final Sesion sesion = Sesion.getInstancia();
    PanelUsuarioController panelUsuarioController;


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
        txtDescripcion.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getDescripcion()));

        comboTipoTransaccion.setItems(FXCollections.observableArrayList(TipoTransaccion.values()));
    }


    public void inicializarValores(Usuario usuario) {

        try {
            if(usuario != null){
                inicializarComboCuentas(usuario);
                Cuenta cuenta = panelUsuarioController.consultarCuenta(usuario.getIdUsuario(), 0);
                sesion.setCuenta(cuenta);

                lblNombre.setText(usuario.getNombre() +", bienvenido a su banco, aquí podra ver sus transacciones");
                lblCuenta.setText("Nro. Cuenta: " + cuenta.getNumeroCuenta());
                consultarTransacciones();


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inicializarComboCuentas(Usuario usuario) {
        cbCuentas.setItems(FXCollections.observableArrayList(usuario.getListaCuentas()));

    }

    private void consultarTransacciones() {

        tablaTransacciones.setItems(FXCollections.observableArrayList(sesion.getCuenta().getListaTransacciones()));
    }

    public void consultarSaldo(ActionEvent actionEvent) {

        String saldo = panelUsuarioController.consultarSaldo(sesion.getUsuario().getIdUsuario(), sesion.getCuenta().getIdCuenta());
        mostrarMensaje("Notificacion Usuario","Saldo disponible",
                "El saldo actual de su cuenta es de: " +"$"+ saldo, Alert.AlertType.INFORMATION);
    }

    public void irTransferencia(ActionEvent actionEvent) throws Exception {

        FXMLLoader loader = navegarVentana(
                "/co/edu/uniquindio/proyectofinal/proyectofinal/transferencia.fxml",
                "Banco - Transferir dinero");
        TransferenciaViewController controlador = loader.getController();
        controlador.inicializarObservable(this);

    }

    public void irActualizar(ActionEvent actionEvent) throws Exception {

        FXMLLoader loader = navegarVentana(
                "/co/edu/uniquindio/proyectofinal/proyectofinal/actualizar.fxml",
                "Banco - Actualizar Datos");

        ActualizarViewController controlador = loader.getController();
        controlador.inicializarObservable(this);

    }

    public void cerrarSesion(ActionEvent actionEvent) throws Exception {

        mostrarMensaje("Notificacion Usuario","Cerrar Sesion",
                "Se ha cerrado la sesión correctamente", Alert.AlertType.INFORMATION);
        registrarAcciones("La sesión se ha cerrado", 1, "cerrarSesion", sesion.getUsuario().getNombre()
        + " ha cerrado la sesión");
        Stage stage = (Stage) tablaTransacciones.getScene().getWindow();
        sesion.cerrarSesion();
        stage.close();

        navegarVentana("/co/edu/uniquindio/proyectofinal/proyectofinal/login.fxml",
                "Banco - Iniciar Sesión");
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
        lblNombre.setText(sesion.getUsuario().getNombre() + ", " +
                "bienvenido a su billetera virtual, aquí podra ver sus transacciones");
    }

    public void irCrearCuentaBancaria(ActionEvent actionEvent) throws Exception {

        FXMLLoader loader = navegarVentana("/co/edu/uniquindio/proyectofinal/proyectofinal/cuenta.fxml",
                "Banco - creación cuenta bancaria");

        CuentaViewController controlador = loader.getController();
        controlador.accederComboBoxCuentas(this);
    }

    //public void eliminar(ActionEvent actionEvent) throws Exception {
        //if(mostrarMensajeConfirmacion("¿Estas seguro de elmininar su cuenta?")){

        //registrarAcciones("Usuario eliminado", 1, "eliminar",
        //      sesion.getUsuario().getNombre() + " eliminó su cuenta");
        //  boolean clienteEliminado = panelUsuarioController.eliminarUsuario(sesion.getUsuario().getIdUsuario());
        // panelUsuarioController.eliminarCuenta(sesion.getCuenta().getIdCuenta());
        //    if(clienteEliminado){
        //      for (UsuarioDto usuarioDto : listaUsuariosDto) {
        //          listaUsuariosDto.remove(usuarioDto);
        //      }
        //   }
        //  cerrarVentana();
        // }

    //}



    private void registrarAcciones(String mensaje, int nivel, String accion, String usuarioAsociado) {

        panelUsuarioController.registrarAcciones(mensaje, nivel, accion, usuarioAsociado);
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

    public void cambiarCuenta(ActionEvent actionEvent) {

        try {
            Cuenta cuentaSeleccionada = cbCuentas.getSelectionModel().getSelectedItem();
            if (cuentaSeleccionada != null) {
                sesion.setCuenta(cuentaSeleccionada);
                lblCuenta.setText("Nro. Cuenta: " + sesion.getCuenta().getNumeroCuenta());
                consultarTransacciones();
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public void notificarTransaccion() {
        consultarTransacciones();
    }

    @Override
    public void notificarCreacionCuenta() {
        inicializarComboCuentas(sesion.getUsuario());
    }

    public void irGestionarCategorias(ActionEvent actionEvent) throws Exception {

        navegarVentana("/co/edu/uniquindio/proyectofinal/proyectofinal/gestionarCategorias.fxml",
                "Banco - Gestionar Categorias");
    }

    public void irGestionarPresupuesto(ActionEvent actionEvent) throws Exception {
        navegarVentana("/co/edu/uniquindio/proyectofinal/proyectofinal/gestionarPresupuesto.fxml",
                "Banco - Gestionar Presupuesto");
    }

    public void seleccionarTipoTransaccion(ActionEvent actionEvent) {

        this.tipoTransaccion = comboTipoTransaccion.getSelectionModel().getSelectedItem();
        dpFechaTransaccion.setDisable(true);
        txtNombreCategoria.setText("");
        txtNombreCategoria.setDisable(true);

    }

    public void seleccionarFechaTransaccion(ActionEvent actionEvent) {
        // Verifica si el valor seleccionado es nulo antes de continuar
        if (dpFechaTransaccion.getValue() == null) {
            // No realiza ninguna acción si el valor es nulo
            System.out.println("Fecha deseleccionada.");
            return;
        }

        // Si el valor no es nulo, realiza las acciones necesarias
        LocalDate fechaSeleccionada = dpFechaTransaccion.getValue();
        LocalDateTime inicioDia = fechaSeleccionada.atStartOfDay();
        this.fechaTransaccion = inicioDia;
        txtNombreCategoria.setText("");
        txtNombreCategoria.setDisable(true);
        comboTipoTransaccion.getSelectionModel().clearSelection();

    }

    @FXML
    public void filtrarTransaccion(ActionEvent actionEvent) {

        try {
            if (comboTipoTransaccion.getValue() == null && txtNombreCategoria.getText().isEmpty()) {
                ArrayList<Transaccion> transaccionFecha = panelUsuarioController.listarTransaccionFecha(
                        fechaTransaccion, sesion.getCuenta().getNumeroCuenta());
                if (transaccionFecha.isEmpty()) {
                    System.out.println("la lista esta vacia");
                }
                tablaTransacciones.setItems(FXCollections.observableArrayList(transaccionFecha));
                dpFechaTransaccion.setValue(null);

            }else if (txtNombreCategoria.getText().isEmpty() && dpFechaTransaccion.getValue() == null){
                ArrayList<Transaccion> transaccionTipoTransaccion = panelUsuarioController.listarTransaccionTipo(tipoTransaccion,
                        sesion.getCuenta().getNumeroCuenta());
                if (transaccionTipoTransaccion.isEmpty()) {
                    System.out.println("la lista esta vacia");
                }
                tablaTransacciones.setItems(FXCollections.observableArrayList(transaccionTipoTransaccion));
                comboTipoTransaccion.getSelectionModel().clearSelection();

            }else if (comboTipoTransaccion.getValue() == null && dpFechaTransaccion.getValue() == null){
                ArrayList<Transaccion> transaccionNombreCategoria = panelUsuarioController.listarTransaccionCategoria(txtNombreCategoria.getText(),
                        sesion.getCuenta().getNumeroCuenta());
                if (transaccionNombreCategoria.isEmpty()) {
                    System.out.println("la lista esta vacia");
                }
                tablaTransacciones.setItems(FXCollections.observableArrayList(transaccionNombreCategoria));
                txtNombreCategoria.setText("");
            }

            comboTipoTransaccion.setDisable(false);
            dpFechaTransaccion.setDisable(false);
            txtNombreCategoria.setDisable(false);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void mostrarTransacciones(ActionEvent actionEvent) {
        consultarTransacciones();
    }
}
