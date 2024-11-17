package co.edu.uniquindio.proyectofinal.proyectofinal.controller;

import co.edu.uniquindio.proyectofinal.proyectofinal.controller.service.IModelFactoryService;
import co.edu.uniquindio.proyectofinal.proyectofinal.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectofinal.proyectofinal.mapping.mappers.BilleteraVirtualMapper;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.*;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoCuenta;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoTransaccion;
import co.edu.uniquindio.proyectofinal.proyectofinal.utils.BancoUtils;
import co.edu.uniquindio.proyectofinal.proyectofinal.utils.Persistencia;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

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
        //1. inicializar datos y luego guardarlo en archivos
        System.out.println("invocación clase singleton");
         //cargarDatosBase();
         //salvarDatosPrueba();

        //2. Cargar los datos de los archivos
		//cargarDatosDesdeArchivos();

        //3. Guardar y Cargar el recurso serializable binario
		//cargarResourceBinario();
        //guardarResourceBinario();

        //4. Guardar y Cargar el recurso serializable XML
        //guardarResourceXML();
        cargarResourceXML();

        //Siempre se debe verificar si la raiz del recurso es null

        if(billeteraVirtual == null){
            cargarDatosBase();
            guardarResourceXML();
        }
        registrarAccionesSistema("Inicio de la aplicacion", 1, "inicioSistema", "");
    }

    public void registrarAccionesSistema(String mensaje, int nivel, String accion, String usuarioAsociado) {
        Persistencia.guardaRegistroLog(mensaje, nivel, accion, usuarioAsociado);
    }

    private void cargarResourceXML() {

        billeteraVirtual = Persistencia.cargarRecursoBilleteraVirtualXML();
    }

    public void guardarResourceXML() {
        
        Persistencia.guardarRecursoBilleteraVirtualXML(billeteraVirtual);
    }

    private void guardarResourceBinario() {
        Persistencia.guardarRecursoBilleteraVirtualBinario(billeteraVirtual);
    }

    private void cargarResourceBinario() {
        billeteraVirtual = Persistencia.cargarRecursoBilleteraVirtualBinario();
    }

    private void cargarDatosDesdeArchivos() {

        billeteraVirtual = new BilleteraVirtual();
        try {
            Persistencia.cargarDatosArchivos(billeteraVirtual);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void salvarDatosPrueba() {

        try {
            Persistencia.guardarUsuarios(billeteraVirtual.getListaUsuarios());
            Persistencia.guardarCuentas(billeteraVirtual.getListaCuentas());
            Persistencia.guardarTransacciones(billeteraVirtual.getListaTransacciones());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean agregarUsuario(UsuarioDto usuarioDto) {
        try{
            if(billeteraVirtual.obtenerUsuario(usuarioDto.idUsuario(), 0) == null) {
                Usuario usuario = mapper.usuarioDtoToUsuario(usuarioDto);
                billeteraVirtual.agregarUsuario(usuario);
                guardarResourceXML();
                salvarDatosPrueba();

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
    public Cuenta agregarCuenta(String idCuenta, String nombreBanco, Double saldo, String idUsuario, TipoCuenta tipoCuenta) throws Exception {

        Cuenta cuenta = billeteraVirtual.agregarCuenta(idCuenta, nombreBanco, saldo, idUsuario, tipoCuenta);
        guardarResourceXML();
        salvarDatosPrueba();
        return cuenta;
    }

    @Override
    public void actualizarUsuario(String idUsuario, String nombre, String correo, String telefono, String direccion) throws Exception {

        billeteraVirtual.actualizarUsuario(idUsuario, nombre, correo, telefono, direccion);

        guardarResourceXML();
        salvarDatosPrueba();
    }

    @Override
    public boolean eliminarUsuario(String idUsuario) {
        boolean flagExiste = false;
        try {
            flagExiste = billeteraVirtual.eliminarUsuario(idUsuario);
            guardarResourceXML();
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

            guardarResourceXML();
            salvarDatosPrueba();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public String consultarSaldo(String idUsuario, String idCuenta) {

        return billeteraVirtual.consultarSaldo(idUsuario, idCuenta);
    }

    @Override
    public Usuario obtenerUsuario(String idUsuario, int posicion) {
        return billeteraVirtual.obtenerUsuario(idUsuario, posicion);
    }

    @Override
    public Transaccion realizarTransaccion(String numeroCuentaOrigen, String numeroCuentaDestino, float monto, TipoTransaccion tipoTransaccion, String descripcion) throws Exception {
        Transaccion transaccion = billeteraVirtual.realizarTransaccion(numeroCuentaOrigen, numeroCuentaDestino, monto, tipoTransaccion, descripcion);
        guardarResourceXML();
        salvarDatosPrueba();

        return transaccion;
    }

    public Categoria agregarCategoria(Usuario usuario,String nombreCategoria, String descripcion, String idTransaccion) throws Exception {
        Categoria categoria = billeteraVirtual.agregarCategoria(usuario,nombreCategoria, descripcion, idTransaccion);
        guardarResourceXML();
        return categoria;
    }

    private void cargarDatosBase() {
        billeteraVirtual = BancoUtils.inicializarDatos();
    }

    public void eliminarCategoria(Usuario usuario,Categoria categoria) {
        billeteraVirtual.eliminarCategoria(usuario, categoria);
        guardarResourceXML();
    }

    public void actualizarCategoria(Usuario usuario, String idCategoria, String nombreCategoria,String descripcion) throws Exception {

        billeteraVirtual.actualizarCategoria(usuario, idCategoria, nombreCategoria, descripcion);
        guardarResourceXML();
    }

    public Presupuesto agregarPresupuesto(String idUsuario, String nombrePresupuesto, float montoAsignado,Categoria categoria) throws Exception {

        Presupuesto presupuesto = billeteraVirtual.agregarPresupuesto(idUsuario, nombrePresupuesto, montoAsignado, categoria);
        guardarResourceXML();
        return presupuesto;
    }

    public ArrayList<Presupuesto> obtenerListaPresupuestosUsuario(String idUsuario) {
        return billeteraVirtual.obtenerListaPresupuestosUsuario(idUsuario);
    }

    public void eliminarPresupuesto(Presupuesto presupuesto) throws Exception {
        billeteraVirtual.eliminarPresupuesto(presupuesto);
        guardarResourceXML();
    }
    public void actualizarPresupuesto(String idUsuario, String nombrePresupuesto, float montoAsignado, float montoGastado,
                                      String idPresupuesto) throws Exception{
        billeteraVirtual.actualizarPresupuesto(idUsuario,nombrePresupuesto,montoAsignado,montoGastado,idPresupuesto);
        guardarResourceXML();
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
