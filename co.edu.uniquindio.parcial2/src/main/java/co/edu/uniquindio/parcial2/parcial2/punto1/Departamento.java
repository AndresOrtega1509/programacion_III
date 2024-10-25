package co.edu.uniquindio.parcial2.parcial2.punto1;

import java.io.Serializable;

public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String nombreDepartamento;
    private String descripcion;
    private String ubicacion;

    public Departamento() {
    }

    public Departamento(String id, String nombreDepartamento, String descripcion, String ubicacion) {
        this.id = id;
        this.nombreDepartamento = nombreDepartamento;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
