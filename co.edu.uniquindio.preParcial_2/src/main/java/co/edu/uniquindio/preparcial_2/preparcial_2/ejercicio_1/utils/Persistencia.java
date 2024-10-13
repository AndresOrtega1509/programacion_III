package co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_1.utils;

import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_1.Estudiante;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {

    public static final String RUTA_ARCHIVO_ESTUDIANTES = "src/main/resources/persistencia/archivoEstudiantes.txt";
    public static final String RUTA_ARCHIVO_LOG = "src/main/resources/persistencia/log/EstudianteLog.txt";
    public static final String RUTA_ARCHIVO_MODELO_ESTUDIANTE_BINARIO = "src/main/resources/persistencia/model.dat";
    public static final String RUTA_ARCHIVO_MODELO_ESTUDIANTE_XML = "src/main/resources/persistencia/model.xml";



    public static void cargarDatosArchivos(Estudiante estudiante) throws FileNotFoundException, IOException {
        //cargar archivo de clientes
        ArrayList<Estudiante> estudiantesCargados = cargarEstudiantes();
        if(estudiantesCargados.size() > 0)
            estudiante.getEstudiantes().addAll(estudiantesCargados);

    }

    /**
     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
     * @param
     * @param
     * @throws IOException
     */
    public static void guardarEstudiantes(ArrayList<Estudiante> listaEstudiantes) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";
        for(Estudiante estudiante:listaEstudiantes)
        {
            contenido+= estudiante.getCodigo()+","+estudiante.getNombre()+","+estudiante.getNota1()+","+estudiante.getNota2()
                    +","+estudiante.getNota3()+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ESTUDIANTES, contenido, false);
    }



//	----------------------LOADS------------------------

    /**
     *
     * @param
     * @param
     * @return un Arraylist de personas con los datos obtenidos del archivo de texto indicado
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList<Estudiante> cargarEstudiantes() throws FileNotFoundException, IOException
    {
        ArrayList<Estudiante> estudiantes =new ArrayList<Estudiante>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ESTUDIANTES);
        String linea="";
        for (int i = 0; i < contenido.size(); i++)
        {
            linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
            Estudiante estudiante = new Estudiante();
            estudiante.setCodigo(linea.split(",")[0]);
            estudiante.setNombre(linea.split(",")[1]);
            estudiante.setNota1(Double.parseDouble(linea.split(",")[2]));
            estudiante.setNota2(Double.parseDouble(linea.split(",")[3]));
            estudiante.setNota3(Double.parseDouble(linea.split(",")[4]));
            estudiantes.add(estudiante);
        }
        return estudiantes;
    }


    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
    {
        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }



    //------------------------------------SERIALIZACIÓN  y XML


    public static Estudiante cargarRecursoEstudianteBinario() {

        Estudiante estudiante = null;

        try {
            estudiante = (Estudiante) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_ESTUDIANTE_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return estudiante;
    }

    public static void guardarRecursoEstudianteBinario(Estudiante estudiante) {
        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_ESTUDIANTE_BINARIO, estudiante);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static Estudiante cargarRecursoEstudianteXML() {

        Estudiante estudiante= null;

        try {
            estudiante = (Estudiante) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_ESTUDIANTE_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return estudiante;

    }



    public static void guardarRecursoEstudianteXML(Estudiante estudiante) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_ESTUDIANTE_XML, estudiante);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
