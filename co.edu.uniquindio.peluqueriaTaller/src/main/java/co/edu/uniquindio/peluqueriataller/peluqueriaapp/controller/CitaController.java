package co.edu.uniquindio.peluqueriataller.peluqueriaapp.controller;

import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.CitaDto;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.ClienteDto;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Cita;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Cliente;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Empleado;

import java.util.List;

public class CitaController {

    ModelFactoryController modelFactoryController;

    public CitaController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public Cliente obtenerClienteCedula(String cedula) throws Exception {
        return modelFactoryController.obtenerClienteCedula(cedula);
    }

    public Empleado obtenerEmpleadoCedula(String cedula) throws Exception {
        return modelFactoryController.obtenerEmpleadoCedula(cedula);
    }

    public List<CitaDto> obtenerCitasDto() {
        return modelFactoryController.obtenerCitasDto();
    }
    public boolean agregarCita(CitaDto citaDto) {

        return modelFactoryController.agregarCita(citaDto);
    }
}
