package co.edu.uniquindio.proyectofinal.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.Usuario;

public class ActualizarCategoriaController {
    ModelFactoryController modelFactoryController;

    public ActualizarCategoriaController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public void actualizarCategoria(Usuario usuario, String idCategoria, String nombreCategoria, String descripcion) throws Exception {
        modelFactoryController.actualizarCategoria(usuario, idCategoria, nombreCategoria, descripcion);
    }
}
