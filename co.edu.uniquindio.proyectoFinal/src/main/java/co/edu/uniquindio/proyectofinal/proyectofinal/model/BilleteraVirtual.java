package co.edu.uniquindio.proyectofinal.proyectofinal.model;

import java.util.ArrayList;

public class BilleteraVirtual {

    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Cuenta> listaCuentas;

    public BilleteraVirtual() {
        listaUsuarios = new ArrayList<>();
        listaCuentas = new ArrayList<>();
    }

    public void crearUsuario(String idUsuario, String nombre, String correoElectronico, String numeroTelefono, String direccion) throws Exception {

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

}
