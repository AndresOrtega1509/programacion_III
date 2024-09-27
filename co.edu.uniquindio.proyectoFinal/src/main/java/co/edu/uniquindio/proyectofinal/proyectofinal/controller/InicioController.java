package co.edu.uniquindio.proyectofinal.proyectofinal.controller;

public class InicioController {

    ModelFactoryController modelFactoryController;

    public InicioController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public void navegarVentana(String nombreArchivoFxml, String tituloVentana) {
        modelFactoryController.navegarVentana(nombreArchivoFxml, tituloVentana);
    }

}
