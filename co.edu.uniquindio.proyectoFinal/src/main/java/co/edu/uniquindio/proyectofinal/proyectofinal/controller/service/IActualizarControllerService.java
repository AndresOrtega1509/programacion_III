package co.edu.uniquindio.proyectofinal.proyectofinal.controller.service;

public interface IActualizarControllerService {

    void actualizarUsuario(String idUsuario, String nombre, String correo, String telefono, String direccion) throws Exception;

    void registrarAcciones(String mensaje, int nivel, String accion, String usuarioAsociado);
}
