package co.edu.uniquindio.proyectofinal.proyectofinal.controller.service;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoCuenta;

public interface ICuentaBancariaService {

    String agregarCuenta(String idCuenta, String nombreBanco, float saldo, String idUsuario, TipoCuenta tipoCuenta) throws Exception;
}
