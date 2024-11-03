package co.edu.uniquindio.proyectofinal.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.service.ITransferenciaControllerService;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoTransaccion;

public class TransferenciaController implements ITransferenciaControllerService {
    ModelFactoryController modelFactoryController;

    public TransferenciaController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }
    @Override
    public void realizarTransaccion(String numeroCuentaOrigen, String numeroCuentaDestino, float monto, TipoTransaccion tipoTransaccion, String descripcion) throws Exception {
        modelFactoryController.realizarTransaccion(numeroCuentaOrigen, numeroCuentaDestino, monto, tipoTransaccion, descripcion);
    }
}
