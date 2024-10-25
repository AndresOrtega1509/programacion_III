package co.edu.uniquindio.parcial2.parcial2.punto1;

import java.io.Serializable;
import java.util.ArrayList;

public class RecursoHumano implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    private ArrayList<Departamento> listaDepartamentos = new ArrayList<>();
    private ArrayList<Proyecto> listaProyectos = new ArrayList<>();

    public RecursoHumano() {
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Departamento> getListaDepartamentos() {
        return listaDepartamentos;
    }

    public void setListaDepartamentos(ArrayList<Departamento> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public ArrayList<Proyecto> getListaProyectos() {
        return listaProyectos;
    }

    public void setListaProyectos(ArrayList<Proyecto> listaProyectos) {
        this.listaProyectos = listaProyectos;
    }
}
