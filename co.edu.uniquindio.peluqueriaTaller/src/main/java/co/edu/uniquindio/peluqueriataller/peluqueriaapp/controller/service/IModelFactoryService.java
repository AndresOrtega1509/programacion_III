package co.edu.uniquindio.peluqueriataller.peluqueriaapp.controller.service;

import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.ClienteDto;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.EmpleadoDto;

import java.util.List;

public interface IModelFactoryService {

    List<EmpleadoDto> obtenerEmpleados();
    List<ClienteDto> obtenerClientes();
    boolean agregarEmpleado(EmpleadoDto empleadoDto);
    boolean agregarCliente(ClienteDto clienteDto);

    boolean eliminarEmpleado(String cedula);

    boolean actualizarEmpleado(String cedulaActual, EmpleadoDto empleadoDto);
}
