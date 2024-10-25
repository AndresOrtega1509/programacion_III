package co.edu.uniquindio.parcial2.parcial2.punto1.utils;

import co.edu.uniquindio.parcial2.parcial2.punto1.Departamento;
import co.edu.uniquindio.parcial2.parcial2.punto1.Empleado;
import co.edu.uniquindio.parcial2.parcial2.punto1.Proyecto;
import co.edu.uniquindio.parcial2.parcial2.punto1.RecursoHumano;

public class RecursoHumanoUtils  {

    public static RecursoHumano inicializarDatos() {

        RecursoHumano recursoHumano = new RecursoHumano();

        Empleado empleado1 = new Empleado();
        empleado1.setId("123");
        empleado1.setNombre("Oscar");
        empleado1.setApellido("Martinez");
        empleado1.setIdDepartamento("103");

        Empleado empleado2 = new Empleado();
        empleado2.setId("457");
        empleado2.setNombre("Sara");
        empleado2.setApellido("Ospina");
        empleado2.setIdDepartamento("222");

        Empleado empleado3 = new Empleado();
        empleado3.setId("635");
        empleado3.setNombre("Santiago");
        empleado3.setApellido("Rodas");
        empleado3.setIdDepartamento("333");

        Proyecto proyecto1 = new Proyecto();
        proyecto1.setId("103");
        proyecto1.setNombreProyecto("avanzar");
        proyecto1.setIdDepartamentoResponsable("Tecnologia");

        Proyecto proyecto2 = new Proyecto();
        proyecto2.setId("457");
        proyecto2.setNombreProyecto("innovacion");
        proyecto2.setIdDepartamentoResponsable("Marketing");

        Proyecto proyecto3 = new Proyecto();
        proyecto3.setId("635");
        proyecto3.setNombreProyecto("mejorar");
        proyecto3.setIdDepartamentoResponsable("Financiero");

        Departamento departamento1 = new Departamento();
        departamento1.setId("103");
        departamento1.setNombreDepartamento("Tecnologia");
        departamento1.setDescripcion("avanzar con tecnologia");
        departamento1.setUbicacion("Armenia");

        Departamento departamento2 = new Departamento();
        departamento2.setId("457");
        departamento2.setNombreDepartamento("innovacion");
        departamento2.setDescripcion("Crear nuevas oportunidades");
        departamento2.setUbicacion("Pereira");

        Departamento departamento3 = new Departamento();
        departamento3.setId("635");
        departamento3.setNombreDepartamento("mejorar");
        departamento3.setDescripcion("mejorar los recursos");
        departamento3.setUbicacion("Calarca");

        recursoHumano.getListaEmpleados().add(empleado1);
        recursoHumano.getListaEmpleados().add(empleado2);
        recursoHumano.getListaEmpleados().add(empleado3);
        recursoHumano.getListaProyectos().add(proyecto1);
        recursoHumano.getListaProyectos().add(proyecto2);
        recursoHumano.getListaProyectos().add(proyecto3);
        recursoHumano.getListaDepartamentos().add(departamento1);
        recursoHumano.getListaDepartamentos().add(departamento2);
        recursoHumano.getListaDepartamentos().add(departamento3);

        return recursoHumano;

    }


}
