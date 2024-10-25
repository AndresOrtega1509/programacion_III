package co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_5.utils;

import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_1.utils.ArchivoUtil;
import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_5.Programas_UQ;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia3 {

    public static final String RUTA_ARCHIVO_PROGRAMAS= "src/main/resources/persistencia/archivoProgramas.txt";
    public static final String RUTA_ARCHIVO_MODELO_PROGRAMAS_XML = "src/main/resources/persistencia/model.xml";



    public static void cargarDatosArchivos(Programas_UQ programasUq) throws FileNotFoundException, IOException {
        //cargar archivo de clientes
        ArrayList<Programas_UQ> programasCargados = cargarProgramas();
        if(programasCargados.size() > 0)
            programasUq.getListaProgramas().addAll(programasCargados);

    }

    public static ArrayList<Programas_UQ> cargarProgramas() throws IOException {

        ArrayList<Programas_UQ> programas =new ArrayList<Programas_UQ>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PROGRAMAS);
        String linea="";
        for (int i = 0; i < contenido.size(); i++)
        {
            linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
            Programas_UQ programa = new Programas_UQ();
            programa.setCodigo(linea.split(",")[0]);
            programa.setNombre(linea.split(",")[1]);
            programa.setModalidad(linea.split(",")[2]);
            programas.add(programa);
        }
        return programas;
    }

    public static void guardarProgramas(ArrayList<Programas_UQ> listaProgramas) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";
        for(Programas_UQ programa:listaProgramas)
        {
            contenido+= programa.getCodigo()+","+programa.getNombre()+","+programa.getModalidad()+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PROGRAMAS, contenido, false);
    }

    public static Programas_UQ cargarRecursoProgramaXML() {

        Programas_UQ programasUq= null;

        try {
            programasUq = (Programas_UQ) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_PROGRAMAS_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return programasUq;

    }



    public static void guardarRecursoProgramaXML(Programas_UQ programasUq) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_PROGRAMAS_XML, programasUq);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
