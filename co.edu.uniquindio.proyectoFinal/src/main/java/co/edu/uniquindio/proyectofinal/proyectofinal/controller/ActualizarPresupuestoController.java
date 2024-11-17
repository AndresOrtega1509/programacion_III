package co.edu.uniquindio.proyectofinal.proyectofinal.controller;

public class ActualizarPresupuestoController {

    ModelFactoryController modelFactoryController;

    public ActualizarPresupuestoController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public void actualizarPresupuesto(String idUsuario, String nombrePresupuesto, float montoAsignado, float montoGastado,
                                      String idPresupuesto) throws Exception{
        modelFactoryController.actualizarPresupuesto(idUsuario,nombrePresupuesto,montoAsignado,montoGastado,idPresupuesto);
    }
}
