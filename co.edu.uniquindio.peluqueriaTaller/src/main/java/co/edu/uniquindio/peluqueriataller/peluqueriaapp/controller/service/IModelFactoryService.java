package co.edu.uniquindio.peluqueriataller.peluqueriaapp.controller.service;

import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.EmpleadoDto;

import java.util.List;

public interface IModelFactoryService {

    List<EmpleadoDto> obtenerEmpleados();
    boolean agregarEmpleado(EmpleadoDto empleadoDto);

    boolean eliminarEmpleado(String cedula);

    boolean actualizarEmpleado(String cedulaActual, EmpleadoDto empleadoDto);
}
