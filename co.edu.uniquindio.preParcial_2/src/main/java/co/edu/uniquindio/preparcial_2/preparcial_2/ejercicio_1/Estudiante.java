package co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_1;

import java.io.Serializable;
import java.util.ArrayList;

public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;

    private String codigo;
    private String nombre;
    private double nota1;
    private double nota2;
    private double nota3;
    private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();

    public Estudiante() {
    }

    public Estudiante(String codigo, String nombre, double nota1, double nota2, double nota3, ArrayList<Estudiante> estudiantes) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.estudiantes = estudiantes;
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

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void crearEstudiante(String codigo, String nombre, double nota1, double nota2, double nota3) throws Exception {

        if (estudianteExistente(codigo) == null){
            Estudiante estudiante = new Estudiante();
            estudiante.setCodigo(codigo);
            estudiante.setNombre(nombre);
            estudiante.setNota1(nota1);
            estudiante.setNota2(nota2);
            estudiante.setNota3(nota3);
            estudiantes.add(estudiante);
        }else {
            throw new Exception("El estudiante ya existe con la cedula: "+ codigo);
        }
    }

    private Estudiante estudianteExistente(String codigo) {

        Estudiante estudiante = null;

        for (Estudiante est : estudiantes) {
            if (est.getCodigo().equals(codigo)) {
                estudiante = est;
            }
        }
        return estudiante;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", nota3=" + nota3 +
                '}';
    }
}
