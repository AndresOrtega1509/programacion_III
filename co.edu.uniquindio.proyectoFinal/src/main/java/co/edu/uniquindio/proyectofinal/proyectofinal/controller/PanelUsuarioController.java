package co.edu.uniquindio.proyectofinal.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.service.IPanelUsuarioService;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Cuenta;

public class PanelUsuarioController implements IPanelUsuarioService {

    ModelFactoryController modelFactoryController;

    public PanelUsuarioController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }
    @Override
    public Cuenta consultarCuenta(String idUsuario, int posicion) throws Exception {
        return modelFactoryController.consultarCuenta(idUsuario,posicion);
    }
}
