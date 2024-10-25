package co.edu.uniquindio.parcial2.parcial2.punto1;

import java.io.Serializable;

public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String nombreProyecto;
    private String idDepartamentoResponsable;

    public Proyecto() {
    }

    public Proyecto(String id, String nombreProyecto, String idDepartamentoResponsable) {
        this.id = id;
        this.nombreProyecto = nombreProyecto;
        this.idDepartamentoResponsable = idDepartamentoResponsable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getIdDepartamentoResponsable() {
        return idDepartamentoResponsable;
    }

    public void setIdDepartamentoResponsable(String idDepartamentoResponsable) {
        this.idDepartamentoResponsable = idDepartamentoResponsable;
    }
}
