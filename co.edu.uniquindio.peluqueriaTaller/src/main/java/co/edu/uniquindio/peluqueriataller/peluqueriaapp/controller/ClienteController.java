package co.edu.uniquindio.peluqueriataller.peluqueriaapp.controller;

import co.edu.uniquindio.peluqueriataller.peluqueriaapp.controller.service.IClienteControllerService;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.ClienteDto;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.EmpleadoDto;

import java.util.List;

public class ClienteController implements IClienteControllerService {

    ModelFactoryController modelFactoryController;

    public ClienteController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

    @Override
    public List<ClienteDto> obtenerClientes() {
        return modelFactoryController.obtenerClientes();
    }

    @Override
    public boolean agregarCliente(ClienteDto clienteDto) {
        return modelFactoryController.agregarCliente(clienteDto);
    }

    @Override
    public boolean actualizarCliente(String cedulaActual, ClienteDto clienteDto) {
        return modelFactoryController.actualizarCliente(cedulaActual, clienteDto);
    }

    @Override
    public boolean eliminarCliente(String cedula) throws Exception {
        return modelFactoryController.eliminarCliente(cedula);
    }
}
