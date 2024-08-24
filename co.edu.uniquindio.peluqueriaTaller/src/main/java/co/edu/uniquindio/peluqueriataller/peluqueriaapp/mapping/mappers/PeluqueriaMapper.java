package co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.mappers;

import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.ClienteDto;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Cliente;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Empleado;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface PeluqueriaMapper {

    PeluqueriaMapper INSTANCE = Mappers.getMapper(PeluqueriaMapper.class);

    @Named("empleadoToEmpleadoDto")
    EmpleadoDto empleadoToEmpleadoDto(Empleado empleado);

    Empleado empleadoDtoToEmpleado(EmpleadoDto empleadoDto);

    @IterableMapping(qualifiedByName = "empleadoToEmpleadoDto")
    List<EmpleadoDto> getEmpleadosDto(List<Empleado> listaEmpleados);

//    @Named("mappingToEmpeladoDto")
//    EmpleadoDto mappingToEmpeladoDto(Empleado empleado);

    Cliente clienteDtoToCliente(ClienteDto clienteDto);

    @IterableMapping(qualifiedByName = "clienteToClienteDto")
    List<ClienteDto> getClientesDto(List<Cliente> listaClientes);

    @Mapping(target = "nombre", source = "persona.nombre")
    @Mapping(target = "apellido", source = "persona.apellido")
    @Mapping(target = "cedula", source = "persona.cedula")
    @Mapping(target = "correo", source = "persona.correo")
    @Mapping(target = "celular", source = "persona.celular")
    ClienteDto clienteToClienteDto(Cliente cliente);


}
