package co.edu.uniquindio.proyectofinal.proyectofinal.model.services;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.Cuenta;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Usuario;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoCuenta;

public interface IBancoService {

    void actualizarUsuario(String idUsuario, String nombre, String correoElectronico, String numeroTelefono, String direccion) throws Exception;
    Usuario validarInicioSesion(String nombre, String idUsuario) throws Exception;
    Usuario obtenerUsuario(String idUsuario, int posicion);
    String agregarCuenta(String idCuenta, String nombreBanco, float saldo, String idUsuario,
                         TipoCuenta tipoCuenta) throws Exception;
    Cuenta consultarCuenta(String idUsuario, int posicion);
    boolean eliminarUsuario(String idUsuario) throws Exception;
    boolean eliminarCuenta(String idCuenta) throws Exception;
    String consultarSaldo(String idUsuario);

}
