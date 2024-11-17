package co.edu.uniquindio.proyectofinal.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.service.IPanelUsuarioService;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Cuenta;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Transaccion;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoTransaccion;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PanelUsuarioController implements IPanelUsuarioService {

    ModelFactoryController modelFactoryController;

    public PanelUsuarioController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }
    @Override
    public Cuenta consultarCuenta(String idUsuario, int posicion) throws Exception {
        return modelFactoryController.consultarCuenta(idUsuario,posicion);
    }

    @Override
    public boolean eliminarUsuario(String idUsuario) {
        return modelFactoryController.eliminarUsuario(idUsuario);
    }

    @Override
    public boolean eliminarCuenta(String idCuenta) throws Exception {
        return modelFactoryController.eliminarCuenta(idCuenta);
    }

    @Override
    public String consultarSaldo(String idUsuario, String idCuenta) {
        return modelFactoryController.consultarSaldo(idUsuario, idCuenta);
    }

    @Override
    public void registrarAcciones(String mensaje, int nivel, String accion, String usuarioAsociado) {
        modelFactoryController.registrarAccionesSistema(mensaje,nivel,accion, usuarioAsociado);
    }

    public ArrayList<Transaccion> listarTransaccionFecha(LocalDateTime fecha, String numeroCuentaOrigen) {
        return modelFactoryController.listarTransaccionFecha(fecha, numeroCuentaOrigen);
    }

    public ArrayList<Transaccion> listarTransaccionTipo(TipoTransaccion tipoTransaccion, String idUsuario) {
        return modelFactoryController.listarTransaccionTipo(tipoTransaccion, idUsuario);
    }

    public ArrayList<Transaccion> listarTransaccionCategoria(String categoria, String idUsuario) {
        return modelFactoryController.listarTransaccionCategoria(categoria, idUsuario);
    }
}
