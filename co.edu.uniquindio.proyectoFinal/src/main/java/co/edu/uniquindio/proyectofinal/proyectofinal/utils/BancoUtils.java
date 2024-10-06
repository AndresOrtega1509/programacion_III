package co.edu.uniquindio.proyectofinal.proyectofinal.utils;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.BilleteraVirtual;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Cuenta;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Usuario;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoCuenta;

public class BancoUtils {

    public static BilleteraVirtual inicializarDatos() {

        BilleteraVirtual billeteraVirtual = new BilleteraVirtual();

        Usuario usuario1 = new Usuario();
        usuario1.setNombre("sara");
        usuario1.setIdUsuario("321");
        usuario1.setCorreoElectronico("sara@hotmail.com");
        usuario1.setDireccion("parque sucre");
        usuario1.setNumeroTelefono("3132334323");
        usuario1.setTieneCuenta(true);

        billeteraVirtual.getListaUsuarios().add(usuario1);

        Cuenta cuenta  = new Cuenta();
        cuenta.setNombreBanco("Nequi");
        cuenta.setIdCuenta("321");
        cuenta.setTipoCuenta(TipoCuenta.AHORROS);
        cuenta.setUsuario(usuario1);
        cuenta.setNumeroCuenta("5846375637");
        cuenta.setSaldo(0.0);

        billeteraVirtual.getListaCuentas().add(cuenta);
        usuario1.getListaCuentas().add(cuenta);

        System.out.println(usuario1);
        System.out.println(cuenta);

        return billeteraVirtual;

    }

}
