package co.edu.uniquindio.proyectofinal.proyectofinal.model;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoCuenta;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoTransaccion;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.services.IBancoService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class BilleteraVirtual implements IBancoService, Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private ArrayList<Cuenta> listaCuentas = new ArrayList<>();
    private ArrayList<Transaccion> listaTransacciones = new ArrayList<>();
    private ArrayList<Categoria> listaCategorias = new ArrayList<>();


    public BilleteraVirtual() {
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public ArrayList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(ArrayList<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    public ArrayList<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(ArrayList<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    /**
     * Método que actualiza los datos de un usuario
     *
     * @param idUsuario               número de identificación del usuario
     * @param nombre            nombre del usuario
     * @param correoElectronico correo electrónico del usuario
     * @param numeroTelefono    numero de telefono del usuario
     * @param direccion           direccion del usuario
     */
    @Override
    public void actualizarUsuario(String idUsuario, String nombre, String correoElectronico, String numeroTelefono, String direccion) throws Exception {

        if (nombre == null || nombre.isBlank()) {
            throw new Exception("El nombre es obligatorio");
        }

        if (correoElectronico == null || correoElectronico.isBlank()) {
            throw new Exception("El correo electronico es obligatorio");
        }

        if (numeroTelefono == null || numeroTelefono.isBlank()) {
            throw new Exception("La contraseña es obligatoria");
        }

        if (direccion == null || direccion.isBlank()) {
            throw new Exception("La direccion es obligatoria");
        }

        Usuario usuario = obtenerUsuario(idUsuario, 0);
        if (usuario == null) {
            throw new Exception("No existe un usuario con el número de identificación: " + idUsuario);
        }
        usuario.setNombre(nombre);
        usuario.setDireccion(direccion);
        usuario.setCorreoElectronico(correoElectronico);
        usuario.setNumeroTelefono(numeroTelefono);
    }

    @Override
    public Usuario validarInicioSesion(String nombre, String idUsuario) throws Exception {
        Usuario usuario = obtenerUsuario(idUsuario, 0);
        if (usuario != null) {
            if (usuario.getNombre().equals(nombre)) {
                return usuario;
            }
        }
        throw new Exception("Los datos del usuario no son correctos");
    }

    @Override
    public Usuario obtenerUsuario(String idUsuario, int posicion) {

        if (posicion >= listaUsuarios.size()){
            return null;
        }else {
            if (listaUsuarios.get(posicion).getIdUsuario().equals(idUsuario)) {
                return listaUsuarios.get(posicion);
            }else {
                return obtenerUsuario(idUsuario,posicion+1);
            }
        }
    }

    @Override
    public Cuenta agregarCuenta(String idCuenta, String nombreBanco, Double saldo, String idUsuario,
                                TipoCuenta tipoCuenta) throws Exception {

        Usuario propietario = obtenerUsuario(idUsuario, 0);
        Cuenta idCuentaExistente = verificarIdCuenta(idCuenta, 0);

        if (idCuentaExistente != null) {
            throw new Exception("La cuenta ya existe con el identidicador: "+ idCuentaExistente.getIdCuenta());
        }

        if (propietario != null) {
            String numeroCuenta = crearNumeroCuenta();
            Cuenta cuenta = new Cuenta(idCuenta, nombreBanco,numeroCuenta, saldo, propietario, tipoCuenta);
            listaCuentas.add(cuenta);
            propietario.getListaCuentas().add(cuenta);
            return cuenta;


        }else {
            throw new Exception("No se encontró el usuario con el número de identificación: " + idUsuario);

        }

    }

    private Cuenta verificarIdCuenta(String idCuenta, int posicion) throws Exception {

        if (posicion >= listaCuentas.size()){
            return null;
        }else {
            if (listaCuentas.get(posicion).getIdCuenta().equals(idCuenta)) {
                return listaCuentas.get(posicion);
            }else {
                return verificarIdCuenta(idCuenta,posicion+1);
            }
        }
    }

    /**
     * Método que crea un número de cuenta aleatorio y verifica que no exista en el sistema para evitar duplicados
     *
     * @return número de cuenta
     */
    private String crearNumeroCuenta() {

        String numeroCuenta = generarNumeroCuenta();

        while (obtenerCuentaBancaria(numeroCuenta, 0) != null) {
            numeroCuenta = generarNumeroCuenta();
        }

        return numeroCuenta;
    }

    private Cuenta obtenerCuentaBancaria(String numeroCuenta, int posicion) {

        if (posicion >= listaCuentas.size()){
            return null;
        }else {
            if (listaCuentas.get(posicion).getIdCuenta().equals(numeroCuenta)) {
                return listaCuentas.get(posicion);
            }else {
                return obtenerCuentaBancaria(numeroCuenta,posicion+1);
            }
        }
    }

    /**
     * Método que genera un número de cuenta aleatorio de 10 dígitos
     *
     * @return número de cuenta
     */
    private String generarNumeroCuenta() {
        StringBuilder numeroCuenta = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int numero = new Random().nextInt(10);
            numeroCuenta.append(numero);
        }

        return numeroCuenta.toString();
    }

    /**
     * Metodo que se encarga de consultar las cuentas de ahorro de un usuario de acuerdo a su numero de identificacion
     * @param idUsuario
     * @return cuenta
     */
    @Override
    public Cuenta consultarCuenta(String idUsuario, int posicion) {

        if (posicion >= listaCuentas.size()){
            return null;
        }else {
            if (listaCuentas.get(posicion).getUsuario().getIdUsuario().equals(idUsuario)) {
                return listaCuentas.get(posicion);
            }else {
                return consultarCuenta(idUsuario,posicion+1);
            }
        }
    }

    @Override
    public boolean eliminarUsuario(String idUsuario) throws Exception {

        Usuario usuario;
        boolean flagExiste = false;
        usuario = obtenerUsuario(idUsuario, 0);
        if(usuario == null)
            throw new Exception("El usuario a eliminar no existe");
        else{
            getListaUsuarios().remove(usuario);
            flagExiste = true;
        }
        return flagExiste;
    }

    @Override
    public boolean eliminarCuenta(String idCuenta) throws Exception {

        Cuenta cuenta;
        boolean flagExiste = false;
        cuenta = obtenerCuentaBancaria(idCuenta, 0);

        if(cuenta == null)
            throw new Exception("La cuenta a eliminar no existe");
        else{
            getListaCuentas().remove(cuenta);
            cuenta.getUsuario().getListaCuentas().clear();
            flagExiste = true;
        }
        return flagExiste;
    }

    @Override
    public String consultarSaldo(String idUsuario, String idCuenta) {
        String saldo = "";
        for (Cuenta cuenta : listaCuentas){
            if (cuenta.getUsuario().getIdUsuario().equals(idUsuario) && cuenta.getIdCuenta().equals(idCuenta)) {
                saldo = String.valueOf(cuenta.getSaldo());
                break;
            }

        }
        return saldo;
    }

    public Transaccion realizarTransaccion(String numeroCuentaOrigen, String numeroCuentaDestino, float monto, TipoTransaccion tipoTransaccion, String descripcion) throws Exception {
        Cuenta cuentaOrigen = obtenerCuenta(numeroCuentaOrigen);
        Cuenta cuentaDestino = obtenerCuenta(numeroCuentaDestino);
        Transaccion transaccionRetiro = null;

        if (tipoTransaccion.equals(TipoTransaccion.TRANSFERENCIA)) {
            if (cuentaOrigen != null && cuentaDestino != null) {
                String idTransaccion = UUID.randomUUID().toString();
                transaccionRetiro = cuentaOrigen.transferir(monto, cuentaDestino, tipoTransaccion, descripcion, idTransaccion);
                Transaccion transaccionDeposito = cuentaDestino.depositar(monto, cuentaOrigen.getUsuario(), descripcion, idTransaccion);
                listaTransacciones.add(transaccionRetiro);
                listaTransacciones.add(transaccionDeposito);

                return transaccionRetiro;

            } else {
                throw new Exception("Error con los números de la cuenta");
            }
        }else {
            if (cuentaOrigen != null) {
                Transaccion transaccionRetiro2 = cuentaOrigen.retirar(monto, tipoTransaccion, descripcion);
                listaTransacciones.add(transaccionRetiro2);
            }else {
                throw new Exception("Error con los números de la cuenta");
            }
        }
        return transaccionRetiro;
    }

    public Categoria agregarCategoria(Usuario usuario, String nombreCategoria, String descripcion, String idTransaccion) throws Exception {
        String idCategoria = UUID.randomUUID().toString();
        Transaccion transaccion = obtenerTransaccion(idTransaccion, 0);
        Categoria categoria = usuario.crearCategoria(nombreCategoria, descripcion, transaccion, idCategoria);

        return categoria;

    }

    private Transaccion obtenerTransaccion(String idTransaccion, int posicion) {

        if (posicion >= listaTransacciones.size()){
            return null;
        }else {
            if (listaTransacciones.get(posicion).getIdTransaccion().equals(idTransaccion)) {
                return listaTransacciones.get(posicion);
            }else {
                return obtenerTransaccion(idTransaccion,posicion+1);
            }
        }
    }

    public Cuenta obtenerCuenta(String numeroCuenta) {
        for (Cuenta cuenta : listaCuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    public void eliminarCategoria(Usuario usuario, Categoria categoria) {

        usuario.eliminarCategoria(categoria);
    }

    public void actualizarCategoria(Usuario usuario, String idCategoria, String nombreCategoria,String descripcion) throws Exception {

        if (idCategoria == null || nombreCategoria.isBlank()) {
            throw new Exception("El id es obligatorio");
        }

        if (descripcion == null || descripcion.isBlank()) {
            throw new Exception("La descripcion es obligatoria");
        }

        usuario.actualizarCategoria(idCategoria, nombreCategoria, descripcion);

    }


}
