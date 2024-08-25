package co.edu.uniquindio.peluqueriataller.peluqueriaapp.viewController;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ResourceBundle;

import co.edu.uniquindio.peluqueriataller.peluqueriaapp.controller.CitaController;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.CitaDto;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Cliente;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Empleado;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CitaViewController  {

    CitaController citaController;
    ObservableList<CitaDto> listaCitasDto = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCedulaCliente;

    @FXML
    private TextField txtCedulaEmpleado;

    @FXML
    private DatePicker dpFecha;

    @FXML
    private TableView<CitaDto> tablaCita;

    @FXML
    private TableColumn<CitaDto, String> tcCliente;

    @FXML
    private TableColumn<CitaDto, String> tcEmpleado;

    @FXML
    private TableColumn<CitaDto, String> tcFecha;

    @FXML
    private TableColumn<CitaDto, String> tcHora;

    @FXML
    private TextField txtHora;

    @FXML
    void initialize() {
        citaController = new CitaController();
        initView();

    }

    private void initView() {

        initDataBinding();
        obtenerCitas();
        tablaCita.getItems().clear();
        tablaCita.setItems(listaCitasDto);

    }
    private void initDataBinding() {

        tcCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cliente()));
        tcEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().empleado()));
        tcFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fecha().toString()));
        tcHora.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().hora()));
    }

    @FXML
    void crearCitaAction(ActionEvent event) {
        crearCita();
    }

    private void crearCita() {

        //1. Capturar los datos
        CitaDto citaDto = construirCitaDto();
        //2. Validar la información
        if(datosValidos(citaDto)){
            if(citaController.agregarCita(citaDto)){
                listaCitasDto.add(citaDto);
                mostrarMensaje("Notificación cita", "Cita creada", "La cita se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposCliente();
            }else{
                mostrarMensaje("Notificación cita", "Cita no creada", "La cita no se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación cita", "Cita no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }
    }

    private void limpiarCamposCliente() {
        txtCedulaCliente.setText("");
        txtCedulaEmpleado.setText("");
        dpFecha.setValue(null);
        txtHora.setText("");

    }

    private boolean datosValidos(CitaDto citaDto) {

        LocalDateTime fechaHoy = LocalDateTime.now();
        String mensaje = "";
        if(citaDto.cliente() == null || citaDto.cliente().isEmpty())
            mensaje += "La cedula del cliente es invalida \n" ;
        if(citaDto.empleado() == null || citaDto.empleado().isEmpty())
            mensaje += "La cedula del empleado es invalida \n" ;
        if(citaDto.fecha() == null || dpFecha == null)
            mensaje += "La fecha es invalida \n" ;
        if(citaDto.hora() == null || citaDto.hora().isEmpty())
            mensaje += "La hora es invalida \n" ;
        if(citaDto.fecha().isBefore(ChronoLocalDate.from(fechaHoy)))
            mensaje += "La fecha es invalida \n" ;
        if(mensaje.isEmpty()){
            return true;
        }else{
            mostrarMensaje("Notificación cita","Datos invalidos",mensaje, Alert.AlertType.WARNING);
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

    private CitaDto construirCitaDto() {

        try {
            Cliente clienteEncontrado = citaController.obtenerClienteCedula(txtCedulaCliente.getText());
            Empleado empleadoEncontrado = citaController.obtenerEmpleadoCedula(txtCedulaEmpleado.getText());

            return new CitaDto(
                    clienteEncontrado.getNombre(),
                    empleadoEncontrado.getNombre(),
                    dpFecha.getValue(),
                    txtHora.getText()
            );
        }catch (Exception e){
            mostrarMensaje("Notificación cita","Datos invalidos", e.getMessage(), Alert.AlertType.ERROR);
        }

        return null;
    }

    private void obtenerCitas() {

        listaCitasDto.addAll(citaController.obtenerCitasDto());
    }
}