package co.edu.uniquindio.parcial2.parcial2.punto1.utils;

import co.edu.uniquindio.parcial2.parcial2.punto1.Departamento;
import co.edu.uniquindio.parcial2.parcial2.punto1.Empleado;
import co.edu.uniquindio.parcial2.parcial2.punto1.Proyecto;
import co.edu.uniquindio.parcial2.parcial2.punto1.RecursoHumano;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class Persistencia {


    public static void cargarDatosArchivos(RecursoHumano recursoHumano) throws FileNotFoundException, IOException {
        //cargar archivo de clientes
        ArrayList<Empleado> empleadosCargados = cargarEmpleados();
        if(empleadosCargados.size() > 0)
            recursoHumano.getListaEmpleados().addAll(empleadosCargados);

        ArrayList<Proyecto> proyectosCargados = cargarProyectos();
        if (proyectosCargados.size() > 0)
            recursoHumano.getListaProyectos().addAll(proyectosCargados);

        ArrayList<Departamento> departamentosCargados = cargarDepartamentos();
        if (departamentosCargados.size() > 0)
            recursoHumano.getListaDepartamentos().addAll(departamentosCargados);

    }

    private static ArrayList<Empleado> cargarEmpleados() {

        Properties loginProperties = new Properties();
        ArrayList<Empleado> empleados =new ArrayList<Empleado>();

        try (FileInputStream fis = new FileInputStream("src/main/resources/persistencia/config.properties")) {
            loginProperties.load(fis);

            // Obtener las credenciales del archivo de propiedades
            String ruta = loginProperties.getProperty("rutaEmpleados");

            ArrayList<String> contenido = ArchivoUtils.leerArchivo(ruta);
            String linea="";
            for (int i = 0; i < contenido.size(); i++)
            {
                linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
                Empleado empleado = new Empleado();
                empleado.setId(linea.split("SS")[0]);
                empleado.setNombre(linea.split("SS")[1]);
                empleado.setApellido(linea.split("SS")[2]);
                empleado.setIdDepartamento(linea.split("SS")[3]);
                empleados.add(empleado);

            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        return empleados;

    }

    private static ArrayList<Proyecto> cargarProyectos() {

        Properties loginProperties = new Properties();
        ArrayList<Proyecto> proyectos =new ArrayList<Proyecto>();

        try (FileInputStream fis = new FileInputStream("src/main/resources/persistencia/config.properties")) {
            loginProperties.load(fis);

            // Obtener las credenciales del archivo de propiedades
            String ruta = loginProperties.getProperty("rutaProyectos");

            ArrayList<String> contenido = ArchivoUtils.leerArchivo(ruta);
            String linea="";
            for (int i = 0; i < contenido.size(); i++)
            {
                linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
                Proyecto proyecto = new Proyecto();
                proyecto.setId(linea.split("SS")[0]);
                proyecto.setNombreProyecto(linea.split("SS")[1]);
                proyecto.setIdDepartamentoResponsable(linea.split("SS")[2]);

            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        return proyectos;
    }

    private static ArrayList<Departamento> cargarDepartamentos() {

        Properties loginProperties = new Properties();
        ArrayList<Departamento> departamentos =new ArrayList<Departamento>();

        try (FileInputStream fis = new FileInputStream("src/main/resources/persistencia/config.properties")) {
            loginProperties.load(fis);

            // Obtener las credenciales del archivo de propiedades
            String ruta = loginProperties.getProperty("rutaDepartamentos");

            ArrayList<String> contenido = ArchivoUtils.leerArchivo(ruta);
            String linea="";
            for (int i = 0; i < contenido.size(); i++)
            {
                linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
                Departamento departamento = new Departamento();
                departamento.setId(linea.split("SS")[0]);
                departamento.setNombreDepartamento(linea.split("SS")[1]);
                departamento.setDescripcion(linea.split("SS")[2]);
                departamento.setUbicacion(linea.split("SS")[3]);

            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        return departamentos;
    }

    public static void guardarEmpleados(ArrayList<Empleado> listaEmpleados) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";
        for(Empleado empleado:listaEmpleados)
        {
            contenido+= empleado.getId()+"SS"+empleado.getNombre()+"SS"+empleado.getApellido()+"SS"+empleado.getIdDepartamento() +"\n";
        }
        Properties loginProperties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/persistencia/config.properties")) {
            loginProperties.load(fis);

            String ruta = loginProperties.getProperty("rutaEmpleados");
            ArchivoUtils.guardarArchivo(ruta, contenido, false);
        }
    }

    public static void guardarProyectos(ArrayList<Proyecto> listaProyectos) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";
        for(Proyecto proyecto:listaProyectos)
        {
            contenido+= proyecto.getId()+"SS"+proyecto.getNombreProyecto()+"SS"+proyecto.getIdDepartamentoResponsable()+"\n";
        }
        Properties loginProperties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/persistencia/config.properties")) {
            loginProperties.load(fis);

            String ruta = loginProperties.getProperty("rutaProyectos");
            ArchivoUtils.guardarArchivo(ruta, contenido, false);
        }
    }

    public static void guardarDepartamentos(ArrayList<Departamento> listaDepartamentos) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";
        for(Departamento departamento:listaDepartamentos)
        {
            contenido+= departamento.getId()+"SS"+departamento.getNombreDepartamento()+"SS"+departamento.getDescripcion()+"SS"+departamento.getUbicacion()+"\n";
        }
        Properties loginProperties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/persistencia/config.properties")) {
            loginProperties.load(fis);

            String ruta = loginProperties.getProperty("rutaDepartamentos");
            ArchivoUtils.guardarArchivo(ruta, contenido, false);
        }
    }

    public static RecursoHumano cargarRecursoXML() {

        RecursoHumano recursoHumano= null;
        Properties loginProperties = new Properties();

        try {
            try (FileInputStream fis = new FileInputStream("src/main/resources/persistencia/config.properties")) {
                loginProperties.load(fis);

                String ruta = loginProperties.getProperty("rutaXml");
                recursoHumano  = (RecursoHumano) ArchivoUtils.cargarRecursoSerializadoXML(ruta);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return recursoHumano;

    }

    public static void guardarRecursoEstudianteXML(RecursoHumano recursoHumano) {

        try {
            Properties loginProperties = new Properties();

            try (FileInputStream fis = new FileInputStream("src/main/resources/persistencia/config.properties")) {
                loginProperties.load(fis);

                String ruta = loginProperties.getProperty("rutaXml");
                ArchivoUtils.salvarRecursoSerializadoXML(ruta, recursoHumano);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static RecursoHumano cargarRecursoBinario() {

        RecursoHumano recursoHumano = null;
        Properties loginProperties = new Properties();

        try {
            try (FileInputStream fis = new FileInputStream("src/main/resources/persistencia/config.properties")) {
                loginProperties.load(fis);

                String ruta = loginProperties.getProperty("rutaBinario");
                recursoHumano = (RecursoHumano) ArchivoUtils.cargarRecursoSerializado(ruta);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return recursoHumano;
    }

    public static void guardarRecursoBinario(RecursoHumano recursoHumano) {

        Properties loginProperties = new Properties();

        try (FileInputStream fis = new FileInputStream("src/main/resources/persistencia/config.properties")) {
            loginProperties.load(fis);

            String ruta = loginProperties.getProperty("rutaBinario");
            ArchivoUtils.salvarRecursoSerializado(ruta, recursoHumano);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
