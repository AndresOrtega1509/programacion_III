package co.edu.uniquindio.proyectofinal.proyectofinal.viewController;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.CuentaBancariaController;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Sesion;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Usuario;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoCuenta;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CuentaViewController {

    @FXML
    private TextField txtIdCuenta;
    @FXML
    private TextField txtNombreBanco;
    @FXML
    private ComboBox<TipoCuenta> cbTipoCuenta;
    CuentaBancariaController cuentaBancariaController;
    private final Sesion sesion = Sesion.getInstancia();
    private Usuario usuario;

    @FXML
    public void initialize() {
        cuentaBancariaController = new CuentaBancariaController();
        cbTipoCuenta.setItems(FXCollections.observableArrayList(TipoCuenta.values()));
        Usuario usuario = sesion.getUsuario();
        inicializarValores(usuario);
    }

    public void crearCuenta(ActionEvent actionEvent) {

        try {
            if (datosValidos()){
                cuentaBancariaController.agregarCuenta(txtIdCuenta.getText(), txtNombreBanco.getText(),0.0,
                        usuario.getIdUsuario(), cbTipoCuenta.getValue());
                mostrarMensaje("Notificacion - Usuario","Creación Cuenta", "La cuenta ha sido creada con exito",
                        Alert.AlertType.INFORMATION);
                registrarAcciones("Cuenta bancaria creada", 1, "crearCuenta",
                        usuario.getNombre()+ " creó una cuenta bancaria");
                cerrarVentana();
                if (!usuario.isTieneCuenta()){
                    navegarVentana("/co/edu/uniquindio/proyectofinal/proyectofinal/panelUsuario.fxml", "Banco - Panel principal", usuario);
                }
                usuario.setTieneCuenta(true);
                cuentaBancariaController.guardarResourceXML();
            }else {
                registrarAcciones("Datos de cuenta bancaria invalidos", 2, "crearCuenta",
                        "");
            }

        }catch (Exception e) {
            mostrarMensaje("Notificacion - Usuario","Creación Cuenta", "La cuenta no se pudo crear",
                    Alert.AlertType.WARNING);
            registrarAcciones("Los datos de la cuenta son invalidos", 2, "crearCuenta",
                    usuario.getNombre() + " tuvo un error al crear su cuenta bancaria");
        }
    }

    private boolean datosValidos() {
        String mensaje = "";
        if(txtIdCuenta == null || txtIdCuenta.getText().isEmpty())
            mensaje += "El id de la cuenta es invalido \n" ;
        if(txtNombreBanco == null || txtNombreBanco.getText().isEmpty())
            mensaje += "El nombre del banco es invalida \n" ;
        if(cbTipoCuenta == null || cbTipoCuenta.getValue() == null)
            mensaje += "El tipo de cuenta es invalido \n" ;
        if(mensaje.isEmpty()){
            return true;
        }else{
            mostrarMensaje("Notificación Usuario","Datos invalidos",mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }

    private void registrarAcciones(String mensaje, int nivel, String accion, String usuarioAsociado) {
        cuentaBancariaController.registrarAcciones(mensaje,nivel,accion, usuarioAsociado);
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private void cerrarVentana() {

        Stage stage = (Stage) txtIdCuenta.getScene().getWindow();
        stage.close();
    }

    private void navegarVentana(String nombreArchivoFxml, String tituloVentana, Usuario usuario) {
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

    public void inicializarValores(Usuario usuario) {
        this.usuario = usuario;
    }
}
