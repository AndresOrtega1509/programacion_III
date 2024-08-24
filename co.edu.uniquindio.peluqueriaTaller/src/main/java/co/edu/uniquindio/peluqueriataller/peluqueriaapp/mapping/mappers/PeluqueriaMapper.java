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

    @Named("clienteToClienteDto")
    @Mapping(source = "nombre", target = "nombre")
    ClienteDto clienteToClienteDto(Cliente cliente);

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellido", target = "apellido")
    @Mapping(source = "cedula", target = "cedula")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "celular", target = "celular")
    Cliente clienteDtoToCliente(ClienteDto clienteDto);

    @Named("empleadoToEmpleadoDto")
    EmpleadoDto empleadoToEmpleadoDto(Empleado empleado);

    Empleado empleadoDtoToEmpleado(EmpleadoDto empleadoDto);

    @IterableMapping(qualifiedByName = "empleadoToEmpleadoDto")
    List<EmpleadoDto> getEmpleadosDto(List<Empleado> listaEmpleados);

    @IterableMapping(qualifiedByName = "clienteToClienteDto")
    List<ClienteDto> getClientesDto(List<Cliente> listaClientes);
}
