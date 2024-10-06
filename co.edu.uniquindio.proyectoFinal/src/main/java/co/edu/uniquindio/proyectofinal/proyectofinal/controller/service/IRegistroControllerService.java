package co.edu.uniquindio.proyectofinal.proyectofinal.controller.service;

import co.edu.uniquindio.proyectofinal.proyectofinal.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Usuario;

public interface IRegistroControllerService {

    boolean agregarUsuario(UsuarioDto usuarioDto);

    void registrarAcciones(String mensaje, int nivel, String accion);
    Usuario obtenerUsuario(String idUsuario, int posicion);
}
