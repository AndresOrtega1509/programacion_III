package co.edu.uniquindio.proyectofinal.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.Categoria;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Usuario;

public class CategoriaController {

    ModelFactoryController modelFactoryController;

    public CategoriaController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public Categoria agregarCategoria(Usuario usuario,String nombreCategoria, String descripcion, String idTransaccion) throws Exception {
        return modelFactoryController.agregarCategoria(usuario,nombreCategoria, descripcion, idTransaccion);
    }


}
