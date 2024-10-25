package co.edu.uniquindio.parcial2.parcial2.punto1;

import java.io.Serializable;

public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;

    private String Id;
    private String nombre;
    private String apellido;
    private String IdDepartamento;

    public Empleado() {
    }

    public Empleado(String id, String nombre, String apellido, String idDepartamento) {
        Id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        IdDepartamento = idDepartamento;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdDepartamento() {
        return IdDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        IdDepartamento = idDepartamento;
    }
}
