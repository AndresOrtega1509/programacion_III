package co.edu.uniquindio.proyectofinal.proyectofinal.controller.service;

import co.edu.uniquindio.proyectofinal.proyectofinal.mapping.dto.UsuarioDto;

public interface IModelFactoryService {

    boolean agregarUsuario(UsuarioDto usuarioDto);

    void navegarVentana(String nombreArchivoFxml, String tituloVentana);
}
