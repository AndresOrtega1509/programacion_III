package co.edu.uniquindio.proyectofinal.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.service.IModelFactoryService;
import co.edu.uniquindio.proyectofinal.proyectofinal.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectofinal.proyectofinal.mapping.mappers.BilleteraVirtualMapper;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.BilleteraVirtual;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Cuenta;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Usuario;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoCuenta;
import co.edu.uniquindio.proyectofinal.proyectofinal.utils.BancoUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ModelFactoryController implements IModelFactoryService {

    BilleteraVirtual billeteraVirtual;
    BilleteraVirtualMapper mapper = BilleteraVirtualMapper.INSTANCE;

    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        this.billeteraVirtual = new BilleteraVirtual();
        cargarDatosBase();
    }

    @Override
    public boolean agregarUsuario(UsuarioDto usuarioDto) {
        try{
            if(billeteraVirtual.obtenerUsuario(usuarioDto.idUsuario(), 0) == null) {
                Usuario usuario = mapper.usuarioDtoToUsuario(usuarioDto);
                billeteraVirtual.agregarUsuario(usuario);

            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Usuario validarInicioSesion(String nombre, String idUsuario) throws Exception {

        return billeteraVirtual.validarInicioSesion(nombre,idUsuario);
    }

    @Override
    public Cuenta consultarCuenta(String idUsuario, int posicion) throws Exception {

        return billeteraVirtual.consultarCuenta(idUsuario, posicion);
    }

    @Override
    public String agregarCuenta(String idCuenta, String nombreBanco, float saldo, String idUsuario, TipoCuenta tipoCuenta) throws Exception {

         return billeteraVirtual.agregarCuenta(idCuenta, nombreBanco, saldo, idUsuario, tipoCuenta);
    }

    @Override
    public void actualizarUsuario(String idUsuario, String nombre, String correo, String telefono, String direccion) throws Exception {

        billeteraVirtual.actualizarUsuario(idUsuario, nombre, correo, telefono, direccion);
    }

    @Override
    public boolean eliminarUsuario(String idUsuario) {
        boolean flagExiste = false;
        try {
            flagExiste = billeteraVirtual.eliminarUsuario(idUsuario);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean eliminarCuenta(String idCuenta) throws Exception{
        boolean flagExiste = false;
        try {
            flagExiste = billeteraVirtual.eliminarCuenta(idCuenta);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public String consultarSaldo(String idUsuario) {

        return billeteraVirtual.consultarSaldo(idUsuario);
    }

    private void cargarDatosBase() {
        billeteraVirtual = BancoUtils.inicializarDatos();
    }

    @Override
    public void navegarVentana(String nombreArchivoFxml, String tituloVentana) {

        try {

            // Cargar la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreArchivoFxml));
            Parent root = loader.load();

            // Crear la escena
            Scene scene = new Scene(root);

            // Crear un nuevo escenario (ventana)
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(tituloVentana);

            // Mostrar la nueva ventana
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
