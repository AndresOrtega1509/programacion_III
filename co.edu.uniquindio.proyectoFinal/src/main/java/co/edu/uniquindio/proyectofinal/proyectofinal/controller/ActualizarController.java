package co.edu.uniquindio.proyectofinal.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.service.IActualizarControllerService;

public class ActualizarController implements IActualizarControllerService {

    ModelFactoryController modelFactoryController;

    public ActualizarController() {

        modelFactoryController = ModelFactoryController.getInstance();
    }
    @Override
    public void actualizarUsuario(String idUsuario, String nombre, String correo, String telefono, String direccion) throws Exception {
        modelFactoryController.actualizarUsuario(idUsuario, nombre, correo, telefono,direccion);
    }
}
