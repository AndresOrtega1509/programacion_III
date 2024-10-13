package co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_1.utils;

import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_1.Estudiante;

public class EstudianteUtils {

    public static Estudiante inicializarDatos() {

        Estudiante estudiante = new Estudiante();

        Estudiante estudiantePrueba = new Estudiante();
        estudiantePrueba.setCodigo("1016");
        estudiantePrueba.setNombre("andres");
        estudiantePrueba.setNota1(4.5);
        estudiantePrueba.setNota2(5.0);
        estudiantePrueba.setNota3(4.8);

        estudiante.getEstudiantes().add(estudiantePrueba);

        System.out.println(estudiantePrueba);

        return estudiante;

    }
}
