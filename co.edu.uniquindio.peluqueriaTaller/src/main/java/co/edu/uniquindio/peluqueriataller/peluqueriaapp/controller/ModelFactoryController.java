package co.edu.uniquindio.peluqueriataller.peluqueriaapp.controller;

import co.edu.uniquindio.peluqueriataller.peluqueriaapp.controller.service.IModelFactoryService;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.mappers.PeluqueriaMapper;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Empleado;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Peluqueria;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.utils.PeluqueriaUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ModelFactoryController implements IModelFactoryService {

    @Setter
    @Getter
    Peluqueria peluqueria;

    PeluqueriaMapper mapper = PeluqueriaMapper.INSTANCE;

    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        System.out.println("invocación clase singleton");
        cargarDatosBase();
    }

    private void cargarDatosBase() {
        peluqueria = PeluqueriaUtils.inicializarDatos();
    }

    @Override
    public List<EmpleadoDto> obtenerEmpleados() {
        return mapper.getEmpleadosDto(peluqueria.getListaEmpleados());
    }

    @Override
    public boolean agregarEmpleado(EmpleadoDto empleadoDto) {
        try{
            if(!peluqueria.verificarEmpleadoExistente(empleadoDto.cedula())) {
                Empleado empleado = mapper.empleadoDtoToEmpleado(empleadoDto);
                getPeluqueria().agregarEmpleado(empleado);
            }
            return true;
        }catch (Exception e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarEmpleado(String cedula) {
        boolean flagExiste = false;
        try {
            flagExiste = getPeluqueria().eliminarEmpleado(cedula);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarEmpleado(String cedulaActual, EmpleadoDto empleadoDto) {
        try {
            Empleado empleado = mapper.empleadoDtoToEmpleado(empleadoDto);
            getPeluqueria().actualizarEmpleado(cedulaActual, empleado);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
