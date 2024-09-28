package co.edu.uniquindio.proyectofinal.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.service.ICuentaBancariaService;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoCuenta;

public class CuentaBancariaController implements ICuentaBancariaService {

    ModelFactoryController modelFactoryController;

    public CuentaBancariaController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }
    @Override
    public String agregarCuenta(String idCuenta, String nombreBanco, float saldo, String idUsuario, TipoCuenta tipoCuenta) throws Exception {
        return modelFactoryController.agregarCuenta(idCuenta, nombreBanco, saldo, idUsuario, tipoCuenta);
    }
}
