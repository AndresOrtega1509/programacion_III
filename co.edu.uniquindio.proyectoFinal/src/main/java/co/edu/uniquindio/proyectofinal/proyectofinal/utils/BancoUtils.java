package co.edu.uniquindio.proyectofinal.proyectofinal.utils;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.BilleteraVirtual;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Usuario;

public class BancoUtils {

    public static BilleteraVirtual inicializarDatos() {

        BilleteraVirtual billeteraVirtual = new BilleteraVirtual();

        Usuario usuario1 = new Usuario();
        usuario1.setNombre("sara");
        usuario1.setIdUsuario("321");
        usuario1.setCorreoElectronico("sara@hotmail.com");
        usuario1.setDireccion("parque sucre");
        usuario1.setNumeroTelefono("3132334323");

        billeteraVirtual.getListaUsuarios().add(usuario1);

        System.out.println(usuario1);

        return billeteraVirtual;

    }

}
