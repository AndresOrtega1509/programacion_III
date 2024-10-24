package co.edu.uniquindio.proyectofinal.proyectofinal.controller.service;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.Usuario;

public interface ILoginController {

    Usuario validarInicioSesion(String nombre, String idUsuario) throws Exception;

    void registroAcciones(String mensaje, int nivel, String accion, String usuarioAsociado);
}
