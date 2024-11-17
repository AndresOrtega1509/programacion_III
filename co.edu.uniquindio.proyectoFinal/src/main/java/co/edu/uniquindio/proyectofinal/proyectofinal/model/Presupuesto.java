package co.edu.uniquindio.proyectofinal.proyectofinal.model;

import java.io.Serializable;

public class Presupuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String idPresupuesto;
    private String nombre;
    private float montoAsignado;
    private float montoGastado;
    private Categoria categoria;
    private Usuario usuarioAsociado;

    public Presupuesto() {
    }

    public Presupuesto(String idPresupuesto, String nombre, float montoAsignado, float montoGastado, Categoria categoria, Usuario usuarioAsociado) {
        this.idPresupuesto = idPresupuesto;
        this.nombre = nombre;
        this.montoAsignado = montoAsignado;
        this.montoGastado = montoGastado;
        this.categoria = categoria;
        this.usuarioAsociado = usuarioAsociado;
    }

    public String getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(String idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getMontoAsignado() {
        return montoAsignado;
    }

    public void setMontoAsignado(float montoAsignado) {
        this.montoAsignado = montoAsignado;
    }

    public float getMontoGastado() {
        return montoGastado;
    }

    public void setMontoGastado(float montoGastado) {
        this.montoGastado = montoGastado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuarioAsociado() {
        return usuarioAsociado;
    }

    public void setUsuarioAsociado(Usuario usuarioAsociado) {
        this.usuarioAsociado = usuarioAsociado;
    }

    @Override
    public String toString() {
        return "Presupuesto{" +
                "idPresupuesto='" + idPresupuesto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", montoAsignado=" + montoAsignado +
                ", montoGastado=" + montoGastado +
                ", categoria=" + categoria +
                ", usuarioAsociado=" + usuarioAsociado +
                '}';
    }
}
