package co.edu.uniquindio.proyectofinal.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.service.IRegistroControllerService;
import co.edu.uniquindio.proyectofinal.proyectofinal.mapping.dto.UsuarioDto;

public class RegistroController implements IRegistroControllerService {

    ModelFactoryController modelFactoryController;

    public RegistroController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }
    @Override
    public boolean agregarUsuario(UsuarioDto usuarioDto) {
        return modelFactoryController.agregarUsuario(usuarioDto);
    }
}
