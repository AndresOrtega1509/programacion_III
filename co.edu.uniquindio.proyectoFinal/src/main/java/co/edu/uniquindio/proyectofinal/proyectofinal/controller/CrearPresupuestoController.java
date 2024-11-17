package co.edu.uniquindio.proyectofinal.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.Categoria;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Presupuesto;

import java.util.ArrayList;

public class CrearPresupuestoController {
    ModelFactoryController modelFactoryController;

    public CrearPresupuestoController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public Presupuesto agregarPresupuesto(String idUsuario, String nombrePresupuesto, float montoAsignado, Categoria categoria) throws Exception {

        return modelFactoryController.agregarPresupuesto(idUsuario, nombrePresupuesto, montoAsignado, categoria);
    }

}
