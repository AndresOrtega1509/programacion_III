package co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_5.utils;

import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_5.Programas_UQ;

public class Programas_UQUtils {

    public static Programas_UQ inicializarDatosProgramas() {

        Programas_UQ programasUq = new Programas_UQ();

        Programas_UQ programaUq1 = new Programas_UQ();

        programaUq1.setCodigo("111");
        programaUq1.setNombre("Medicina");
        programaUq1.setModalidad("Presencial");

        Programas_UQ programaUq2 = new Programas_UQ();

        programaUq2.setCodigo("222");
        programaUq2.setNombre("Periodismo");
        programaUq2.setModalidad("Distancia");

        Programas_UQ programaUq3 = new Programas_UQ();

        programaUq3.setCodigo("333");
        programaUq3.setNombre("Ing. Sistemas");
        programaUq3.setModalidad("Presencial");


        programasUq.getListaProgramas().add(programaUq1);
        programasUq.getListaProgramas().add(programaUq2);
        programasUq.getListaProgramas().add(programaUq3);

        System.out.println(programaUq1);
        System.out.println(programaUq2);
        System.out.println(programaUq3);

        return programasUq;

    }


}
