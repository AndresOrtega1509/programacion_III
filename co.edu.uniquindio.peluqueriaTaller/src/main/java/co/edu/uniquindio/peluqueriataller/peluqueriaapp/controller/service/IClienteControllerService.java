package co.edu.uniquindio.peluqueriataller.peluqueriaapp.controller.service;

import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.ClienteDto;

import java.util.List;

public interface IClienteControllerService {

    List<ClienteDto> obtenerClientes();
    boolean agregarCliente(ClienteDto clienteDto);
    boolean actualizarCliente(String cedulaActual, ClienteDto clienteDto);
    boolean eliminarCliente(String cedula) throws Exception;
}
