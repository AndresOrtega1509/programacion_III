package co.edu.uniquindio.proyectofinal.proyectofinal.controller.service;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.Cuenta;

public interface IPanelUsuarioService {

    Cuenta consultarCuenta(String idUsuario, int posicion) throws Exception;
    boolean eliminarUsuario(String idUsuario);
    boolean eliminarCuenta(String idCuenta) throws Exception;
    String consultarSaldo(String idUsuario);
}
