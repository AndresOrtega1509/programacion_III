package co.edu.uniquindio.proyectofinal.proyectofinal.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private String idUsuario;
    private String nombre;
    private String correoElectronico;
    private String numeroTelefono;
    private String direccion;
    private boolean tieneCuenta = false;
    private List<Cuenta> listaCuentas = new ArrayList<>();

    public Usuario() {

    }

    public Usuario(String idUsuario, String nombre, String correoElectronico, String numeroTelefono, String direccion, boolean tieneCuenta,List<Cuenta> listaCuentas) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
        this.tieneCuenta = tieneCuenta;

        if (listaCuentas == null) {
            this.listaCuentas = new ArrayList<>();
        } else {
            this.listaCuentas = listaCuentas;
        }
    }

    public List<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(List<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isTieneCuenta() {
        return tieneCuenta;
    }

    public void setTieneCuenta(boolean tieneCuenta) {
        this.tieneCuenta = tieneCuenta;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario='" + idUsuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
