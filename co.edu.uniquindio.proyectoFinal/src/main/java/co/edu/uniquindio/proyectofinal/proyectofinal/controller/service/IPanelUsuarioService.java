package co.edu.uniquindio.proyectofinal.proyectofinal.controller.service;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.Cuenta;

public interface IPanelUsuarioService {

    Cuenta consultarCuenta(String idUsuario, int posicion) throws Exception;
}
