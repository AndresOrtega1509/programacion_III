package co.edu.uniquindio.proyectofinal.proyectofinal.model;

/**
 * Clase que representa la instancia de sesion, la cual guarda al usuario y la cuenta de ahorros
 */
public class Sesion {


    public static Sesion INSTANCIA;

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    private Sesion() {
    }


    public static Sesion getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new Sesion();
        }
        return INSTANCIA;
    }

    /**
     * Metodo que se encarga de volver nulo al usuario al momento de cerrar sesion
     */
    public void cerrarSesion() {
        usuario = null;
    }
}
