package co.edu.uniquindio.proyectofinal.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.service.ICuentaBancariaService;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoCuenta;

public class CuentaBancariaController implements ICuentaBancariaService {

    ModelFactoryController modelFactoryController;

    public CuentaBancariaController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }
    @Override
    public void agregarCuenta(String idCuenta, String nombreBanco, Double saldo, String idUsuario, TipoCuenta tipoCuenta) throws Exception {
        modelFactoryController.agregarCuenta(idCuenta, nombreBanco, saldo, idUsuario, tipoCuenta);
    }

    @Override
    public void registrarAcciones(String mensaje, int nivel, String accion) {
        modelFactoryController.registrarAccionesSistema(mensaje, nivel, accion);
    }

    @Override
    public void guardarResourceXML() {
        modelFactoryController.guardarResourceXML();
    }
}
