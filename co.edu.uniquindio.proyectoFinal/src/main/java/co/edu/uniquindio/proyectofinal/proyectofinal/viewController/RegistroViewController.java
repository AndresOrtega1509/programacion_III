package co.edu.uniquindio.proyectofinal.proyectofinal.viewController;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.RegistroController;
import co.edu.uniquindio.proyectofinal.proyectofinal.mapping.dto.UsuarioDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistroViewController {

    RegistroController registroController;
    ObservableList<UsuarioDto> listaUsuariosDto = FXCollections.observableArrayList();

    @FXML
    private TextField txtIdentificacion;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtNumeroTelefono;

    @FXML
    public void initialize() {
        registroController = new RegistroController();
    }

    public void registrarse(ActionEvent actionEvent) {
        
        crearUsuario();
    }

    private void crearUsuario() {
        //1. Capturar los datos
        UsuarioDto usuarioDto = construirUsuarioDto();
        //2. Validar la información
        if(datosValidos(usuarioDto)){
            if (registroController.obtenerUsuario(txtIdentificacion.getText(), 0) == null){

                if(registroController.agregarUsuario(usuarioDto)){
                    listaUsuariosDto.add(usuarioDto);
                    mostrarMensaje("Notificación usuario", "Usuario creado", "El usuario se ha creado con éxito", Alert.AlertType.INFORMATION);
                    registrarAcciones("Usuario creado", 1, "agregar usuario",
                            txtNombre.getText() + " se registró en la aplicación");
                    cerrarVentana();
                }else{
                    mostrarMensaje("Notificación usuario", "Usuario no creado", "El usuario no se ha creado con éxito", Alert.AlertType.ERROR);
                }
            }else {
                mostrarMensaje("Notificación usuario", "Usuario existente", "Ya existe un usuario con el numero de identificacion:  " + txtIdentificacion.getText(),
                        Alert.AlertType.ERROR);

                registrarAcciones("Usuario ya existe", 2, "agregar usuario", txtNombre.getText() + " con la identificacion: "+
                        txtIdentificacion.getText() + " ya existe");
            }

        }else{
            mostrarMensaje("Notificación usuario", "Usuario no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
            registrarAcciones("Usuario no creado", 2, "agregar usuario", "");
        }
    }

    private void registrarAcciones(String mensaje, int nivel, String accion, String usuarioAsociado) {
        registroController.registrarAcciones(mensaje, nivel, accion, usuarioAsociado);
    }

    private void cerrarVentana() {

        Stage stage = (Stage) txtIdentificacion.getScene().getWindow();
        stage.close();
    }

    private boolean datosValidos(UsuarioDto usuarioDto) {

        String mensaje = "";
        if(usuarioDto.nombre() == null || usuarioDto.nombre().isEmpty())
            mensaje += "El nombre es invalido \n" ;
        if(usuarioDto.direccion() == null || usuarioDto.direccion().isEmpty())
            mensaje += "La direccion es invalida \n" ;
        if(usuarioDto.idUsuario() == null || usuarioDto.idUsuario().isEmpty())
            mensaje += "El numero de identificación es invalido \n" ;
        if(usuarioDto.correoElectronico() == null || usuarioDto.correoElectronico().isEmpty())
            mensaje += "El correo es invalido \n" ;
        if(usuarioDto.numeroTelefono() == null || usuarioDto.numeroTelefono().isEmpty())
            mensaje += "El numero de telefono es invalido \n" ;
        if(mensaje.isEmpty()){
            return true;
        }else{
            mostrarMensaje("Notificación Usuario","Datos invalidos",mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private UsuarioDto construirUsuarioDto() {

        return new UsuarioDto(
                txtIdentificacion.getText(),
                txtNombre.getText(),
                txtCorreo.getText(),
                txtNumeroTelefono.getText(),
                txtDireccion.getText()
        );
    }

}
