package co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_5;

import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_1.Estudiante;

import java.util.ArrayList;

public class Programas_UQ {

    private String codigo;
    private String nombre;
    private String modalidad;
    private ArrayList<Programas_UQ> listaProgramas  = new ArrayList<Programas_UQ>();

    public Programas_UQ() {
    }

    public Programas_UQ(String codigo, String nombre, String modalidad, ArrayList<Programas_UQ> listaProgramas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.modalidad = modalidad;
        this.listaProgramas = listaProgramas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public ArrayList<Programas_UQ> getListaProgramas() {
        return listaProgramas;
    }

    public void setListaProgramas(ArrayList<Programas_UQ> listaProgramas) {
        this.listaProgramas = listaProgramas;
    }

    public void crearPrograma(String codigo, String nombre, String modalidad)  {

            Programas_UQ programasUq = new Programas_UQ();
            programasUq.setCodigo(codigo);
            programasUq.setNombre(nombre);
            programasUq.setModalidad(modalidad);
            listaProgramas.add(programasUq);
    }

    @Override
    public String toString() {
        return "Programas_UQ{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", modalidad='" + modalidad + '\'' +
                '}';
    }
}
