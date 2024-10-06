package co.edu.uniquindio.proyectofinal.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.service.IRegistroControllerService;
import co.edu.uniquindio.proyectofinal.proyectofinal.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Usuario;

public class RegistroController implements IRegistroControllerService {

    ModelFactoryController modelFactoryController;

    public RegistroController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }
    @Override
    public boolean agregarUsuario(UsuarioDto usuarioDto) {
        return modelFactoryController.agregarUsuario(usuarioDto);
    }

    @Override
    public void registrarAcciones(String mensaje, int nivel, String accion, String usuarioAsociado) {
        modelFactoryController.registrarAccionesSistema(mensaje, nivel, accion, usuarioAsociado);
    }

    @Override
    public Usuario obtenerUsuario(String idUsuario, int posicion) {
        return modelFactoryController.obtenerUsuario(idUsuario, posicion);
    }
}
