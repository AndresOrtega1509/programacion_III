package co.edu.uniquindio.proyectofinal.proyectofinal.mapping.mappers;

import co.edu.uniquindio.proyectofinal.proyectofinal.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Usuario;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BilleteraVirtualMapper {

    BilleteraVirtualMapper INSTANCE = Mappers.getMapper(BilleteraVirtualMapper.class);

    @Named("usuarioToUsuarioDto")
    UsuarioDto usuarioToUsuarioDto(Usuario usuario);

    @Mapping(source = "idUsuario", target = "idUsuario")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "correoElectronico", target = "correoElectronico")
    @Mapping(source = "numeroTelefono", target = "numeroTelefono")
    @Mapping(source = "direccion", target = "direccion")
    Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);

    @IterableMapping(qualifiedByName = "usuarioToUsuarioDto")
    List<UsuarioDto> getUsuariosDto(List<Usuario> listaUsuarios);


}
