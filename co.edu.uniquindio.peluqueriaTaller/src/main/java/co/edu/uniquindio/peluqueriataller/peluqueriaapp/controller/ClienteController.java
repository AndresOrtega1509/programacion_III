package co.edu.uniquindio.peluqueriataller.peluqueriaapp.controller;

import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.ClienteDto;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.EmpleadoDto;

import java.util.List;

public class ClienteController {

    ModelFactoryController modelFactoryController;

    public ClienteController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public List<ClienteDto> obtenerClientes() {
        return modelFactoryController.obtenerClientes();
    }

    public boolean agregarCliente(ClienteDto clienteDto) {
        return modelFactoryController.agregarCliente(clienteDto);
    }
}
