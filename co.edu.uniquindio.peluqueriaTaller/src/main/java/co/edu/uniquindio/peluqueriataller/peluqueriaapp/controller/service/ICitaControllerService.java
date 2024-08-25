package co.edu.uniquindio.peluqueriataller.peluqueriaapp.controller.service;

import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.CitaDto;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Cliente;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Empleado;

import java.util.List;

public interface ICitaControllerService {

    Cliente obtenerClienteCedula(String cedula) throws Exception;
    Empleado obtenerEmpleadoCedula(String cedula) throws Exception;
    List<CitaDto> obtenerCitasDto();
    boolean agregarCita(CitaDto citaDto);
}
