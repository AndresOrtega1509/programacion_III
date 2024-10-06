package co.edu.uniquindio.proyectofinal.proyectofinal.controller.service;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoCuenta;

public interface ICuentaBancariaService {

    void agregarCuenta(String idCuenta, String nombreBanco, Double saldo, String idUsuario, TipoCuenta tipoCuenta) throws Exception;

    void registrarAcciones(String mensaje, int nivel, String accion);

    void guardarResourceXML();
}
