package co.edu.uniquindio.proyectofinal.proyectofinal.controller.service;

import co.edu.uniquindio.proyectofinal.proyectofinal.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Cuenta;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Usuario;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoCuenta;

public interface IModelFactoryService {

    boolean agregarUsuario(UsuarioDto usuarioDto);

    void navegarVentana(String nombreArchivoFxml, String tituloVentana);
    Usuario validarInicioSesion(String nombre, String idUsuario) throws Exception;
    Cuenta consultarCuenta(String idUsuario, int posicion) throws Exception;
    String agregarCuenta(String idCuenta, String nombreBanco, float saldo, String idUsuario, TipoCuenta tipoCuenta) throws Exception;
    void actualizarUsuario(String idUsuario, String nombre, String correo, String telefono, String direccion) throws Exception;
    boolean eliminarUsuario(String idUsuario);
    boolean eliminarCuenta(String idCuenta) throws Exception;
    String consultarSaldo(String idUsuario);
}
