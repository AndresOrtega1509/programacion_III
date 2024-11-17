package co.edu.uniquindio.proyectofinal.proyectofinal.model;

import java.io.Serializable;

public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    private String idCategoria;
    private String nombreCategoria;
    private String descripcionCategoria;
    private Transaccion transaccion;
    private Presupuesto presupuesto;

    public Categoria() {
    }

    public Categoria(String idCategoria, String nombreCategoria, String descripcionCategoria, Transaccion transaccion, Presupuesto presupuesto) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
        this.transaccion = transaccion;
        this.presupuesto = presupuesto;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria='" + idCategoria + '\'' +
                ", nombreCategoria='" + nombreCategoria + '\'' +
                ", descripcionCategoria='" + descripcionCategoria + '\'' +
                '}';
    }
}
