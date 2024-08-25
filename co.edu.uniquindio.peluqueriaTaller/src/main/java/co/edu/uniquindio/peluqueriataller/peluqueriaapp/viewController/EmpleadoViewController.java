package co.edu.uniquindio.peluqueriataller.peluqueriaapp.viewController;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.peluqueriataller.peluqueriaapp.controller.EmpleadoController;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.EmpleadoDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EmpleadoViewController {
    
    EmpleadoController empleadoController;
    ObservableList<EmpleadoDto> listaEmpleadosDto = FXCollections.observableArrayList();
    EmpleadoDto empleadoSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<EmpleadoDto> tablaEmpleado;

    @FXML
    private TableColumn<EmpleadoDto, String> tcApellidoEmpleado;

    @FXML
    private TableColumn<EmpleadoDto, String> tcCedulaEmpleado;

    @FXML
    private TableColumn<EmpleadoDto, String> tcCelularEmpleado;

    @FXML
    private TableColumn<EmpleadoDto, String> tcCorreoEmpleado;

    @FXML
    private TableColumn<EmpleadoDto, String> tcNombreEmpleado;

    @FXML
    private TextField txtApellidoEmpleado;

    @FXML
    private TextField txtCedulaEmpleado;

    @FXML
    private TextField txtCelularEmpleado;

    @FXML
    private TextField txtCorreoEmpleado;

    @FXML
    private TextField txtNombreEmpleado;

    @FXML
    void initialize() {
        empleadoController = new EmpleadoController();
        initView();
    }

    @FXML
    void agregarEmpleadoAction(ActionEvent event) {
        
        crearEmpleado();
    }

    @FXML
    void actualizarEmpleadoAction(ActionEvent event) {

        actualizarEmpleado();
    }

    @FXML
    void EliminarEmpleadoAction(ActionEvent event) {

        eliminarEmpleado();
    }

    private void crearEmpleado() {

        //1. Capturar los datos
        EmpleadoDto empleadoDto = construirEmpleadoDto();
        //2. Validar la información
        if(datosValidos(empleadoDto)){
            if(empleadoController.agregarEmpleado(empleadoDto)){
                listaEmpleadosDto.add(empleadoDto);
                mostrarMensaje("Notificación empleado", "Empleado creado", "El empleado se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposEmpleado();
            }else{
                mostrarMensaje("Notificación empleado", "Empleado no creado", "El empleado no se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación empleado", "Empleado no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }
    }

    private void actualizarEmpleado() {

        boolean clienteActualizado = false;
        //1. Capturar los datos
        String cedulaActual = empleadoSeleccionado.cedula();
        EmpleadoDto empleadoDto = construirEmpleadoDto();
        //2. verificar el empleado seleccionado
        if(empleadoSeleccionado != null){
            //3. Validar la información
            if(datosValidos(empleadoSeleccionado)){
                clienteActualizado = empleadoController.actualizarEmpleado(cedulaActual,empleadoDto);
                if(clienteActualizado){
                    listaEmpleadosDto.remove(empleadoSeleccionado);
                    listaEmpleadosDto.add(empleadoDto);
                    tablaEmpleado.refresh();
                    mostrarMensaje("Notificación empleado", "Empleado actualizado", "El empleado se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                    limpiarCamposEmpleado();
                }else{
                    mostrarMensaje("Notificación empleado", "Empleado no actualizado", "El empleado no se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                }
            }else{
                mostrarMensaje("Notificación empleado", "Empleado no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
            }

        }
    }

    private void eliminarEmpleado() {

        boolean empleadoEliminado = false;
        if(empleadoSeleccionado != null){
            if(mostrarMensajeConfirmacion("¿Estas seguro de elmininar al empleado?")){
                empleadoEliminado = empleadoController.eliminarEmpleado(empleadoSeleccionado.cedula());
                if(empleadoEliminado){
                    listaEmpleadosDto.remove(empleadoSeleccionado);
                    empleadoSeleccionado = null;
                    tablaEmpleado.getSelectionModel().clearSelection();
                    limpiarCamposEmpleado();
                    mostrarMensaje("Notificación empleado", "Empleado eliminado", "El empleado se ha eliminado con éxito", Alert.AlertType.INFORMATION);
                }else{
                    mostrarMensaje("Notificación empleado", "Empleado no eliminado", "El empleado no se puede eliminar", Alert.AlertType.ERROR);
                }
            }
        }else{
            mostrarMensaje("Notificación empleado", "Empleado no seleccionado", "Seleccionado un empleado de la lista", Alert.AlertType.WARNING);
        }
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

    private void limpiarCamposEmpleado() {

        txtNombreEmpleado.setText("");
        txtApellidoEmpleado.setText("");
        txtCedulaEmpleado.setText("");
        txtCorreoEmpleado.setText("");
        txtCelularEmpleado.setText("");
    }

    private boolean datosValidos(EmpleadoDto empleadoDto) {

        String mensaje = "";
        if(empleadoDto.nombre() == null || empleadoDto.nombre().isEmpty())
            mensaje += "El nombre es invalido \n" ;
        if(empleadoDto.apellido() == null || empleadoDto.apellido().isEmpty())
            mensaje += "El apellido es invalido \n" ;
        if(empleadoDto.cedula() == null || empleadoDto.cedula().isEmpty())
            mensaje += "La cedula es invalida \n" ;
        if(empleadoDto.correo() == null || empleadoDto.correo().isEmpty())
            mensaje += "El correo es invalido \n" ;
        if(empleadoDto.celular() == null || empleadoDto.celular().isEmpty())
            mensaje += "El celular es invalido \n" ;
        if(mensaje.isEmpty()){
            return true;
        }else{
            mostrarMensaje("Notificación empleado","Datos invalidos",mensaje, Alert.AlertType.WARNING);
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

    private EmpleadoDto construirEmpleadoDto() {

        return new EmpleadoDto(
                txtNombreEmpleado.getText(),
                txtApellidoEmpleado.getText(),
                txtCedulaEmpleado.getText(),
                txtCorreoEmpleado.getText(),
                txtCelularEmpleado.getText()
        );
    }

    private void initView() {

        initDataBinding();
        obtenerEmpleados();
        tablaEmpleado.getItems().clear();
        tablaEmpleado.setItems(listaEmpleadosDto);
        listenerSelection();
    }

    private void initDataBinding() {

        tcNombreEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcApellidoEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellido()));
        tcCedulaEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedula()));
        tcCorreoEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().correo()));
        tcCelularEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().celular()));
    }

    private void listenerSelection() {

        tablaEmpleado.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            empleadoSeleccionado = newSelection;
            mostrarInformacionCliente(empleadoSeleccionado);
        });
    }

    private void mostrarInformacionCliente(EmpleadoDto empleadoSeleccionado) {

        if(empleadoSeleccionado != null){
            txtNombreEmpleado.setText(empleadoSeleccionado.nombre());
            txtApellidoEmpleado.setText(empleadoSeleccionado.apellido());
            txtCedulaEmpleado.setText(empleadoSeleccionado.cedula());
            txtCorreoEmpleado.setText(empleadoSeleccionado.correo());
            txtCelularEmpleado.setText(empleadoSeleccionado.celular());
        }
    }

    private void obtenerEmpleados() {
        
        listaEmpleadosDto.addAll(empleadoController.obtenerEmpleados());
    }
}
