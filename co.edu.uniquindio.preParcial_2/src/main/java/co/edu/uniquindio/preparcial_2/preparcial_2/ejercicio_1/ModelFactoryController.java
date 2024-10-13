package co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_1;

import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_1.utils.EstudianteUtils;
import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_1.utils.Persistencia;

import java.io.IOException;
import java.util.ArrayList;

public class ModelFactoryController {

    Estudiante estudiante;

    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        //1. inicializar datos y luego guardarlo en archivos
        System.out.println("invocación clase singleton");
        //cargarDatosBase();
       //salvarDatosPrueba();

        //2. Cargar los datos de los archivos
        //cargarDatosDesdeArchivos();

        //3. Guardar y Cargar el recurso serializable binario
        //cargarResourceBinario();
        //guardarResourceBinario();

        //4. Guardar y Cargar el recurso serializable XML
        //guardarResourceXML();
        cargarResourceXML();

        //Siempre se debe verificar si la raiz del recurso es null

        if(estudiante == null){
            cargarDatosBase();
            guardarResourceXML();
        }
        registrarAccionesSistema("Inicio de la aplicacion", 1, "inicioSistema");
    }

    private void cargarDatosBase() {

        estudiante = EstudianteUtils.inicializarDatos();
    }

    private void salvarDatosPrueba() {

        try {
            Persistencia.guardarEstudiantes(estudiante.getEstudiantes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void cargarDatosDesdeArchivos() {

        estudiante = new Estudiante();
        try {
            Persistencia.cargarDatosArchivos(estudiante);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void cargarResourceBinario() {

        estudiante = Persistencia.cargarRecursoEstudianteBinario();
    }

    private void guardarResourceBinario() {

        Persistencia.guardarRecursoEstudianteBinario(estudiante);
    }

    private void guardarResourceXML() {

        Persistencia.guardarRecursoEstudianteXML(estudiante);
    }

    private void cargarResourceXML() {

        estudiante = Persistencia.cargarRecursoEstudianteXML();
    }

    public void registrarAccionesSistema(String mensaje, int nivel, String accion) {

        Persistencia.guardaRegistroLog(mensaje, nivel, accion);
    }

    public void crearEstudiante(String codigo, String nombre, double nota1, double nota2, double nota3) throws Exception {
        estudiante.crearEstudiante(codigo, nombre, nota1, nota2, nota3);
        salvarDatosPrueba();
        guardarResourceBinario();
        guardarResourceXML();

    }

    public Estudiante buscarEstudiantePorCodigo(String codigo) {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        try {
            estudiantes = Persistencia.cargarEstudiantes();
        } catch (IOException e) {
            e.printStackTrace();
            registrarAccionesSistema("Error al cargar estudiantes", 3, "buscarEstudiante");
        }

        for (Estudiante est : estudiantes) {
            if (est.getCodigo().equals(codigo)) {
                return est;
            }
        }
        return null; // Retorna null si no encuentra el estudiante
    }

}