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
    private List<Categoria> listaCategorias = new ArrayList<>();

    public Usuario() {

    }

    public Usuario(String idUsuario, String nombre, String correoElectronico, String numeroTelefono, String direccion, boolean tieneCuenta,
                   List<Cuenta> listaCuentas, List<Categoria> listaCategorias) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
        this.tieneCuenta = tieneCuenta;
        this.listaCategorias = listaCategorias;


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

    public List<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
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

    public Categoria crearCategoria(String nombreCategoria, String descripcion, Transaccion transaccion, String idCategoria) {

        Categoria categoria = new Categoria();
        categoria.setIdCategoria(idCategoria);
        categoria.setNombreCategoria(nombreCategoria);
        categoria.setDescripcionCategoria(descripcion);
        listaCategorias.add(categoria);

        if (transaccion != null) {
            transaccion.setCategoria(categoria);
        }

        return categoria;
    }

    public void eliminarCategoria(Categoria categoria) {
        if (categoria != null) {
            listaCategorias.remove(categoria);
        }
    }

    public void actualizarCategoria(String idCategoria, String nombreCategoria, String descripcion) throws Exception{

        Categoria categoria = obtenerCategoria(idCategoria,0);

        if (categoria != null) {
            categoria.setNombreCategoria(nombreCategoria);
            categoria.setDescripcionCategoria(descripcion);
        }else {
            throw new Exception("No existe una categoria con el id: " + idCategoria);
        }
    }

    private Categoria obtenerCategoria(String idCategoria, int posicion) {

        if (posicion >= listaCategorias.size()){
            return null;
        }else {
            if (listaCategorias.get(posicion).getIdCategoria().equals(idCategoria)) {
                return listaCategorias.get(posicion);
            }else {
                return obtenerCategoria(idUsuario,posicion+1);
            }
        }
    }
}
