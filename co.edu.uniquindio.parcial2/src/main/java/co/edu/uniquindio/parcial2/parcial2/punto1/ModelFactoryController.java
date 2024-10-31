package co.edu.uniquindio.parcial2.parcial2.punto1;

import co.edu.uniquindio.parcial2.parcial2.punto1.utils.ArchivoUtils;
import co.edu.uniquindio.parcial2.parcial2.punto1.utils.Persistencia;
import co.edu.uniquindio.parcial2.parcial2.punto1.utils.RecursoHumanoUtils;

import java.io.IOException;

public class ModelFactoryController {

    RecursoHumano recursoHumano;

    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public boolean verificarInicioSesion(String usuario, String contrasenia) throws IOException {

        return ArchivoUtils.inicioSesionArchivoPropiedades(usuario, contrasenia);
    }

    public ModelFactoryController(){

        //1. inicializar datos y luego guardarlo en archivos
        System.out.println("invocación clase singleton");
        //cargarDatosBase();
        //salvarDatosPrueba();

        //2. Cargar los datos de los archivos
        cargarDatosDesdeArchivos();

        //3. Guardar y Cargar el recurso serializable binario
        //cargarResourceBinario();
        //guardarResourceBinario();

        //4. Guardar y Cargar el recurso serializable XML
        guardarResourceXML();
        //cargarResourceXML();


        if(recursoHumano == null){
            cargarDatosBase();
            guardarResourceXML();
        }

    }

    private void cargarResourceXML() {

        recursoHumano = Persistencia.cargarRecursoXML();
    }

    private void guardarResourceXML() {

        Persistencia.guardarRecursoEstudianteXML(recursoHumano);
    }

    private void guardarResourceBinario() {

        Persistencia.guardarRecursoBinario(recursoHumano);
    }

    private void cargarResourceBinario() {

        recursoHumano = Persistencia.cargarRecursoBinario();
    }

    private void cargarDatosDesdeArchivos() {

        recursoHumano = new RecursoHumano();
        try {
            Persistencia.cargarDatosArchivos(recursoHumano);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void salvarDatosPrueba() {

        try {
            Persistencia.guardarEmpleados(recursoHumano.getListaEmpleados());
            Persistencia.guardarProyectos(recursoHumano.getListaProyectos());
            Persistencia.guardarDepartamentos(recursoHumano.getListaDepartamentos());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void cargarDatosBase() {

        recursoHumano = RecursoHumanoUtils.inicializarDatos();
    }
}
