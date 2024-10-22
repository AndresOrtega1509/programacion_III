package co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4;

import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4.utils.Persistencia2;
import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4.utils.RestauranteUtils;
import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_1.utils.ArchivoUtil;

import java.io.IOException;

public class ModelFactoryController2 {

    Restaurante restaurante;

    private static class SingletonHolder {
        private final static ModelFactoryController2 eINSTANCE = new ModelFactoryController2();
    }

    public static ModelFactoryController2 getInstance() {
        return ModelFactoryController2.SingletonHolder.eINSTANCE;
    }

    private ModelFactoryController2() {

        //1. inicializar datos y luego guardarlo en archivos
        System.out.println("invocación clase singleton");
        cargarDatosBase();
        salvarDatosPrueba();

        //2. Cargar los datos de los archivos
        //cargarDatosDesdeArchivos();

        //3. Guardar y Cargar el recurso serializable binario
        //cargarResourceBinario();
        //guardarResourceBinario();

        //4. Guardar y Cargar el recurso serializable XML
        //guardarResourceXML();
        //cargarResourceXML();

        //Siempre se debe verificar si la raiz del recurso es null

        if(restaurante == null){
            cargarDatosBase();
            //guardarResourceXML();
        }
    }

    private void cargarDatosBase() {

        restaurante = RestauranteUtils.inicializarDatos();
    }

    private void salvarDatosPrueba() {

        try {
            Persistencia2.guardarClientes(restaurante.getClientes());
            Persistencia2.guardarProductos(restaurante.getProductos());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void cargarDatosDesdeArchivos() {

        restaurante = new Restaurante();
        try {
            Persistencia2.cargarDatosArchivos(restaurante);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verificarInicioSesion(String usuario, String contrasenia) throws IOException {

        return ArchivoUtil.inicioSesionArchivoPropiedades(usuario, contrasenia);
    }
}