package co.edu.uniquindio.peluqueriataller.peluqueriaapp.controller;

import co.edu.uniquindio.peluqueriataller.peluqueriaapp.controller.service.ICitaControllerService;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.CitaDto;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.ClienteDto;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Cita;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Cliente;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Empleado;

import java.util.List;

public class CitaController implements ICitaControllerService {

    ModelFactoryController modelFactoryController;

    public CitaController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

    @Override
    public Cliente obtenerClienteCedula(String cedula) throws Exception {
        return modelFactoryController.obtenerClienteCedula(cedula);
    }

    @Override
    public Empleado obtenerEmpleadoCedula(String cedula) throws Exception {
        return modelFactoryController.obtenerEmpleadoCedula(cedula);
    }

    @Override
    public List<CitaDto> obtenerCitasDto() {
        return modelFactoryController.obtenerCitasDto();
    }

    @Override
    public boolean agregarCita(CitaDto citaDto) {

        return modelFactoryController.agregarCita(citaDto);
    }
}
