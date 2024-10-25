package co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_5;

import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_5.utils.Persistencia3;
import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_5.utils.Programas_UQUtils;

import java.io.IOException;
import java.util.ArrayList;

public class ModelFactoryController3 {

    Programas_UQ programasUq;

    private static class SingletonHolder {
        private final static ModelFactoryController3 eINSTANCE = new ModelFactoryController3();
    }

    public static ModelFactoryController3 getInstance() {
        return ModelFactoryController3.SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController3() {
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

        if(programasUq == null){
            cargarDatosBase();
            guardarResourceXML();
        }

    }

    private void cargarDatosBase() {

        programasUq = Programas_UQUtils.inicializarDatosProgramas();
    }

    private void salvarDatosPrueba() {

        try {
            Persistencia3.guardarProgramas(programasUq.getListaProgramas());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void cargarDatosDesdeArchivos() {

        programasUq = new Programas_UQ();
        try {
            Persistencia3.cargarDatosArchivos(programasUq);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    private void guardarResourceXML() {

        Persistencia3.guardarRecursoProgramaXML(programasUq);
    }

    private void cargarResourceXML() {

        programasUq = Persistencia3.cargarRecursoProgramaXML();
    }


    public void crearPrograma(String codigo, String nombre, String modalidad) throws Exception {
        programasUq.crearPrograma(codigo, nombre, modalidad);
        salvarDatosPrueba();
        guardarResourceXML();

    }

    public Programas_UQ buscarPrograma(String codigo) {
        ArrayList<Programas_UQ> programas = new ArrayList<>();
        try {
            programas = Persistencia3.cargarProgramas();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Programas_UQ prog : programas) {
            if (prog.getCodigo().equals(codigo)) {
                return prog;
            }
        }
        return null;
    }
}
