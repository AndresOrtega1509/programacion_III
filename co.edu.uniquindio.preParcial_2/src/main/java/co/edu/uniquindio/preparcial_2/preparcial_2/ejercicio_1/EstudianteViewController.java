package co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class EstudianteViewController {

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNota1;

    @FXML
    private TextField txtNota2;

    @FXML
    private TextField txtNota3;

    ModelFactoryController modelFactoryController;

    public EstudianteViewController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

    @FXML
    public void crearEstudiante(ActionEvent actionEvent) {

        try{
            if (validarDatos()){

                double nota1 = Double.parseDouble(txtNota1.getText());
                double nota2 = Double.parseDouble(txtNota2.getText());
                double nota3 = Double.parseDouble(txtNota3.getText());
                modelFactoryController.crearEstudiante(txtCodigo.getText(), txtNombre.getText(),nota1,nota2,nota3);
                mostrarMensaje("Notificación Estudiante","Estudiante guardado",
                        "Estudiante guardado con exito",Alert.AlertType.INFORMATION);
                limpiarCampos();
                modelFactoryController.registrarAccionesSistema("Estudiante guardado", 1, "crearEstudiante");
            }

        } catch (Exception e) {
            mostrarMensaje("Notificacion estudiante", "Estudiante existente", e.getMessage(), Alert.AlertType.ERROR);
            modelFactoryController.registrarAccionesSistema("Estudiante existente", 3, "crearEstudiante");
        }


    }

    private void limpiarCampos() {

        txtCodigo.clear();
        txtNombre.clear();
        txtNota1.clear();
        txtNota2.clear();
        txtNota3.clear();
    }

    private boolean validarDatos() {
        String mensaje = "";
        if(txtCodigo == null || txtNombre.getText().isEmpty())
            mensaje += "El codigo es invalido \n" ;
        if(txtNombre == null || txtNombre.getText().isEmpty())
            mensaje += "El nombre es invalido \n" ;
        if(txtNota1 == null || txtNota1.getText().isEmpty())
            mensaje += "La nota 1 es invalida \n" ;
        if(txtNota2 == null || txtNota2.getText().isEmpty())
            mensaje += "La nota 2 es invalida \n" ;
        if(txtNota3 == null || txtNota3.getText().isEmpty())
            mensaje += "La nota 3 es invalida \n" ;
        if(mensaje.isEmpty()){
            return true;
        }else{
            mostrarMensaje("Notificación Estudiante","Datos invalidos",mensaje, Alert.AlertType.WARNING);
            modelFactoryController.registrarAccionesSistema("Datos invalidos", 2, "validarDatos");
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

    @FXML
    public void buscarEstudiante(ActionEvent actionEvent) {
        String codigo = txtCodigo.getText();
        if (codigo != null && !codigo.isEmpty()) {
            Estudiante estudiante = modelFactoryController.buscarEstudiantePorCodigo(codigo);
            if (estudiante != null) {
                txtCodigo.setText(estudiante.getCodigo());
                txtNombre.setText(estudiante.getNombre());
                txtNota1.setText(String.valueOf(estudiante.getNota1()));
                txtNota2.setText(String.valueOf(estudiante.getNota2()));
                txtNota3.setText(String.valueOf(estudiante.getNota3()));
                
            } else {
                mostrarMensaje("Información del Estudiante", "Estudiante no encontrado",
                        "No se encontró un estudiante con el código especificado.",
                        Alert.AlertType.WARNING);
            }
        } else {
            mostrarMensaje("Error de búsqueda", "Código vacío",
                    "Por favor, ingrese un código para realizar la búsqueda.",
                    Alert.AlertType.WARNING);
        }
    }
}
