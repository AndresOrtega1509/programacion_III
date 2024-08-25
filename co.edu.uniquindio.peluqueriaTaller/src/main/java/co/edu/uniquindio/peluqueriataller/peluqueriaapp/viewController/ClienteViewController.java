package co.edu.uniquindio.peluqueriataller.peluqueriaapp.viewController;

import co.edu.uniquindio.peluqueriataller.peluqueriaapp.controller.ClienteController;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.ClienteDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ClienteViewController {

    ClienteController clienteController;
    ObservableList<ClienteDto> listaClientesDto = FXCollections.observableArrayList();
    ClienteDto clienteSeleccionado;
    private CitaViewController citaViewController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtApellidoCliente;

    @FXML
    private TextField txtCedulaCliente;

    @FXML
    private TextField txtCelularCliente;

    @FXML
    private TextField txtCorreoCliente;

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private TableView<ClienteDto> tablaCliente;

    @FXML
    private TableColumn<ClienteDto, String> tcApellidoCliente;

    @FXML
    private TableColumn<ClienteDto, String> tcCedulaCliente;

    @FXML
    private TableColumn<ClienteDto, String> tcCelularCliente;

    @FXML
    private TableColumn<ClienteDto, String> tcCorreoCliente;

    @FXML
    private TableColumn<ClienteDto, String> tcNombreCliente;

    @FXML
    void initialize() {

        clienteController = new ClienteController();
        initView();

    }

    private void initView() {
        initDataBinding();
        obtenerClientes();
        tablaCliente.getItems().clear();
        tablaCliente.setItems(listaClientesDto);
        listenerSelection();
    }

    private void listenerSelection() {

        tablaCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            clienteSeleccionado = newSelection;
            mostrarInformacionCliente(clienteSeleccionado);
        });
    }

    private void mostrarInformacionCliente(ClienteDto clienteSeleccionado) {

        if(clienteSeleccionado != null){
            txtNombreCliente.setText(clienteSeleccionado.nombre());
            txtApellidoCliente.setText(clienteSeleccionado.apellido());
            txtCedulaCliente.setText(clienteSeleccionado.cedula());
            txtCorreoCliente.setText(clienteSeleccionado.correo());
            txtCelularCliente.setText(clienteSeleccionado.celular());
        }
    }

    private void initDataBinding() {

        tcNombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcApellidoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellido()));
        tcCedulaCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedula()));
        tcCorreoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().correo()));
        tcCelularCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().celular()));
    }

    private void obtenerClientes() {

        listaClientesDto.addAll(clienteController.obtenerClientes());
    }

    @FXML
    void agregarClienteAction(ActionEvent event) {

        crearCliente();
    }

    private void crearCliente() {

        //1. Capturar los datos
        ClienteDto clienteDto = construirClienteDto();
        //2. Validar la información
        if(datosValidos(clienteDto)){
            if(clienteController.agregarCliente(clienteDto)){
                listaClientesDto.add(clienteDto);
                mostrarMensaje("Notificación cliente", "Cliente creado", "El cliente se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposCliente();
            }else{
                mostrarMensaje("Notificación cliente", "Cliente no creado", "El cliente no se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación cliente", "Cliente no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }
    }

    private void limpiarCamposCliente() {

        txtNombreCliente.setText("");
        txtApellidoCliente.setText("");
        txtCedulaCliente.setText("");
        txtCorreoCliente.setText("");
        txtCelularCliente.setText("");
    }

    private boolean datosValidos(ClienteDto clienteDto) {

        String mensaje = "";
        if(clienteDto.nombre() == null || clienteDto.nombre().isEmpty())
            mensaje += "El nombre es invalido \n" ;
        if(clienteDto.apellido() == null || clienteDto.apellido().isEmpty())
            mensaje += "El apellido es invalido \n" ;
        if(clienteDto.cedula() == null || clienteDto.cedula().isEmpty())
            mensaje += "La cedula es invalida \n" ;
        if(clienteDto.correo() == null || clienteDto.correo().isEmpty())
            mensaje += "El correo es invalido \n" ;
        if(clienteDto.celular() == null || clienteDto.celular().isEmpty())
            mensaje += "El celular es invalido \n" ;
        if(mensaje.isEmpty()){
            return true;
        }else{
            mostrarMensaje("Notificación cliente","Datos invalidos",mensaje, Alert.AlertType.WARNING);
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

    private ClienteDto construirClienteDto() {

        return new ClienteDto(
                txtNombreCliente.getText(),
                txtApellidoCliente.getText(),
                txtCedulaCliente.getText(),
                txtCorreoCliente.getText(),
                txtCelularCliente.getText()
        );
    }

}