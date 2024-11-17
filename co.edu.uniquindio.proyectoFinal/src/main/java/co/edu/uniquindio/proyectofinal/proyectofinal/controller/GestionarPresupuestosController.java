package co.edu.uniquindio.proyectofinal.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.Categoria;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Presupuesto;

import java.util.ArrayList;

public class GestionarPresupuestosController {

    ModelFactoryController modelFactoryController;

    public GestionarPresupuestosController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public Presupuesto agregarPresupuesto(String idUsuario, String nombrePresupuesto, float montoAsignado, Categoria categoria) throws Exception {

        return modelFactoryController.agregarPresupuesto(idUsuario, nombrePresupuesto, montoAsignado, categoria);
    }

    public ArrayList<Presupuesto> obtenerListaPresupuestosUsuario(String idUsuario) {
        return modelFactoryController.obtenerListaPresupuestosUsuario(idUsuario);
    }

    public void eliminarPresupuesto(Presupuesto presupuesto) throws Exception {

        modelFactoryController.eliminarPresupuesto(presupuesto);
    }
}
