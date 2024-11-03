package co.edu.uniquindio.proyectofinal.proyectofinal.controller.service;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoTransaccion;

public interface ITransferenciaControllerService {
    void realizarTransaccion(String numeroCuentaOrigen, String numeroCuentaDestino, float monto, TipoTransaccion tipoTransaccion, String descripcion) throws Exception;
}
