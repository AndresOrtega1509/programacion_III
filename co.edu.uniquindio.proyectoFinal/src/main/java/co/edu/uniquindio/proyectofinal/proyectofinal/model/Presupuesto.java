package co.edu.uniquindio.proyectofinal.proyectofinal.model;

public class Presupuesto {

    private String idPresupuesto;
    private String nombre;
    private float montoAsignado;
    private float montoGastado;
    private Categoria categoria;

    public Presupuesto() {
    }

    public Presupuesto(String idPresupuesto, String nombre, float montoAsignado, float montoGastado, Categoria categoria) {
        this.idPresupuesto = idPresupuesto;
        this.nombre = nombre;
        this.montoAsignado = montoAsignado;
        this.montoGastado = montoGastado;
        this.categoria = categoria;
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
}
