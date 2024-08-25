package co.edu.uniquindio.peluqueriataller.peluqueriaapp.controller.service;

import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.CitaDto;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.ClienteDto;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Cliente;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Empleado;

import java.util.List;

public interface IModelFactoryService {

    List<EmpleadoDto> obtenerEmpleados();
    List<ClienteDto> obtenerClientes();
    List<CitaDto> obtenerCitasDto();
    boolean agregarCita(CitaDto citaDto);
    Cliente obtenerClienteCedula(String cedula) throws Exception;
    Empleado obtenerEmpleadoCedula(String cedula) throws Exception;
    boolean agregarEmpleado(EmpleadoDto empleadoDto);
    boolean agregarCliente(ClienteDto clienteDto);

    boolean eliminarEmpleado(String cedula);
    boolean eliminarCliente(String cedula) throws Exception;

    boolean actualizarEmpleado(String cedulaActual, EmpleadoDto empleadoDto);
    boolean actualizarCliente(String cedulaActual, ClienteDto clienteDto);
}
