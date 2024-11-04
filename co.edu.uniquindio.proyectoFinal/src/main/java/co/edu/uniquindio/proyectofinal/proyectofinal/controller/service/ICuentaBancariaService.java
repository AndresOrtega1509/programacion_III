package co.edu.uniquindio.proyectofinal.proyectofinal.controller.service;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.Cuenta;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoCuenta;

public interface ICuentaBancariaService {

    Cuenta agregarCuenta(String idCuenta, String nombreBanco, Double saldo, String idUsuario, TipoCuenta tipoCuenta) throws Exception;

    void registrarAcciones(String mensaje, int nivel, String accion, String usuarioAsociado);

    void guardarResourceXML();
}
