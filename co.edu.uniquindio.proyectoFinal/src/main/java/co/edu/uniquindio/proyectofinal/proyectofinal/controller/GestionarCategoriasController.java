package co.edu.uniquindio.proyectofinal.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.Categoria;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Usuario;

public class GestionarCategoriasController {

    ModelFactoryController modelFactoryController;

    public GestionarCategoriasController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public void eliminarCategoria(Usuario usuario, Categoria categoria) {
        modelFactoryController.eliminarCategoria(usuario, categoria);
    }
}
