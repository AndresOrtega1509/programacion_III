package co.edu.uniquindio.proyectofinal.proyectofinal.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        // Recorremos las categorías existentes
        for (Categoria c : listaCategorias) {
            Categoria categoria = new Categoria();
            if (c.getNombreCategoria().equals(nombreCategoria)) {
                categoria.setIdCategoria(c.getIdCategoria());
            } else {
                categoria.setIdCategoria(idCategoria);
            }
            categoria.setNombreCategoria(nombreCategoria);
            categoria.setDescripcionCategoria(descripcion);
            listaCategorias.add(categoria);
            if (transaccion != null) {
                transaccion.setCategoria(categoria);
            }
            return categoria; // Retornamos la categoría creada o asociada
        }

        // Si la lista está vacía o no se ejecutó el bucle, creamos una nueva categoría
        Categoria nuevaCategoria = new Categoria();
        nuevaCategoria.setIdCategoria(idCategoria);
        nuevaCategoria.setNombreCategoria(nombreCategoria);
        nuevaCategoria.setDescripcionCategoria(descripcion);
        listaCategorias.add(nuevaCategoria);
        if (transaccion != null) {
            transaccion.setCategoria(nuevaCategoria);
        }
        return nuevaCategoria; // Retornamos la categoría nueva
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

    /**
     * Metodo que obtiene solo una categoria por el nombre para permitir que el usuario seleccione la
     * categoria a la cual quiere asignarle el presupuesto
     * @return List<Categoria>
     */
    public List<Categoria> obtenerCategoriasUnicas() {
        // Usamos un mapa para filtrar las categorías basándonos en el nombre.
        Map<String, Categoria> categoriasUnicas = new HashMap<>();

        for (Categoria categoria : listaCategorias) {
            // Si no existe una categoría con este nombre, la agregamos.
            if (!categoriasUnicas.containsKey(categoria.getNombreCategoria())) {
                categoriasUnicas.put(categoria.getNombreCategoria(), categoria);
            }
        }

        // Retornamos las categorías como una lista.
        return new ArrayList<>(categoriasUnicas.values());
    }
}
