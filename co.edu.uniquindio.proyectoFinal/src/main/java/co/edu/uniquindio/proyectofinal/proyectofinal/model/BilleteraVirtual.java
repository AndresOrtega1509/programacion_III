package co.edu.uniquindio.proyectofinal.proyectofinal.model;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoCuenta;

import java.util.ArrayList;
import java.util.Random;

public class BilleteraVirtual {

    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Cuenta> listaCuentas;

    public BilleteraVirtual() {
        listaUsuarios = new ArrayList<>();
        listaCuentas = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public Usuario validarInicioSesion(String nombre, String idUsuario) throws Exception {
        Usuario usuario = obtenerUsuario(idUsuario, 0);
        if (usuario != null) {
            if (usuario.getNombre().equals(nombre)) {
                return usuario;
            }
        }
        throw new Exception("Los datos del usuario no son correctos");
    }

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

    public String agregarCuenta(String idCuenta, String nombreBanco, float saldo, String idUsuario, TipoCuenta tipoCuenta) throws Exception {

        Usuario propietario = obtenerUsuario(idUsuario, 0);

        if (propietario != null) {
            String numeroCuenta = crearNumeroCuenta();
            Cuenta cuenta = new Cuenta(idCuenta, nombreBanco,numeroCuenta, saldo, propietario,null, tipoCuenta);
            listaCuentas.add(cuenta);

            return numeroCuenta;
        }

        throw new Exception("No se encontró el usuario con el número de identificación: " + idUsuario);

    }

    /**
     * Método que crea un número de cuenta aleatorio y verifica que no exista en el sistema para evitar duplicados
     *
     * @return número de cuenta
     */
    private String crearNumeroCuenta() {

        String numeroCuenta = generarNumeroCuenta();

        while (obtenerCuentaAhorros(numeroCuenta, 0) != null) {
            numeroCuenta = generarNumeroCuenta();
        }

        return numeroCuenta;
    }

    private Cuenta obtenerCuentaAhorros(String numeroCuenta, int posicion) {

        if (posicion >= listaCuentas.size()){
            return null;
        }else {
            if (listaCuentas.get(posicion).getIdCuenta().equals(numeroCuenta)) {
                return listaCuentas.get(posicion);
            }else {
                return obtenerCuentaAhorros(numeroCuenta,posicion+1);
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

}
