package co.edu.uniquindio.proyectofinal.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.service.ILoginController;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Usuario;

public class LoginController implements ILoginController {

    ModelFactoryController modelFactoryController;

    public LoginController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }
    @Override
    public Usuario validarInicioSesion(String nombre, String idUsuario) throws Exception {
         return modelFactoryController.validarInicioSesion(nombre, idUsuario);
    }

    @Override
    public void registroAcciones(String mensaje, int nivel, String accion, String usuarioAsociado) {
        modelFactoryController.registrarAccionesSistema(mensaje, nivel, accion, usuarioAsociado);
    }
}
