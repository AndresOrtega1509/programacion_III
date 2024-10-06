package co.edu.uniquindio.proyectofinal.proyectofinal.utils;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.BilleteraVirtual;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Cuenta;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.Usuario;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoCuenta;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Persistencia {

    //bancoUq/src/main/resources/persistencia/archivoClientes.txt
    public static final String RUTA_ARCHIVO_USUARIOS = "src/main/resources/persistencia/archivoUsuarios.txt";
    public static final String RUTA_ARCHIVO_CUENTAS = "src/main/resources/persistencia/archivoCuentas.txt";
    public static final String RUTA_ARCHIVO_LOG = "src/main/resources/persistencia/log/billeteraVirtualLog.txt";
    public static final String RUTA_ARCHIVO_OBJETOS = "src/main/resources/persistencia/archivoObjetos.txt";
    public static final String RUTA_ARCHIVO_MODELO_BILLETERA_VIRTUAL_BINARIO = "src/main/resources/persistencia/model.dat";
    public static final String RUTA_ARCHIVO_MODELO_BILLETERA_VIRTUAL_XML = "src/main/resources/persistencia/model.xml";
//	C:\td\persistencia



    public static void cargarDatosArchivos(BilleteraVirtual billeteraVirtual) throws FileNotFoundException, IOException {
        // Cargar archivo de usuarios y manejarlo como un Map
        Map<String, Usuario> usuariosCargadosMap = cargarUsuarios();
        if (!usuariosCargadosMap.isEmpty()) {
            billeteraVirtual.getListaUsuarios().addAll(usuariosCargadosMap.values());
        }

        // Cargar archivo de cuentas
        ArrayList<Cuenta> cuentasCargadas = cargarCuentas();
        if (cuentasCargadas.size() > 0) {
            for (Cuenta cuenta : cuentasCargadas) {
                // Buscar el usuario correspondiente en el Map utilizando el idUsuario
                Usuario usuario = usuariosCargadosMap.get(cuenta.getUsuario().getIdUsuario());
                if (usuario != null) {
                    cuenta.setUsuario(usuario); // Asocia la cuenta con el usuario
                    usuario.getListaCuentas().add(cuenta); // Agrega la cuenta a la lista de cuentas del usuario
                }
            }
            billeteraVirtual.getListaCuentas().addAll(cuentasCargadas);
        }
    }

    /**
     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
     * @param
     * @param
     * @throws IOException
     */
    public static void guardarUsuarios(ArrayList<Usuario> listaUsuarios) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";
        for(Usuario usuario:listaUsuarios)
        {
            contenido+= usuario.getNombre()+","+usuario.getIdUsuario()+","+usuario.getCorreoElectronico()+","+usuario.getNumeroTelefono()
                    +","+usuario.getDireccion()+","+usuario.isTieneCuenta()+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_USUARIOS, contenido, false);
    }


    public static void guardarCuentas(ArrayList<Cuenta> listaCuentas) throws IOException {
        String contenido = "";
        for(Cuenta cuenta:listaCuentas)
        {
            contenido+= cuenta.getNumeroCuenta()+
                    ","+cuenta.getIdCuenta()+
                    ","+cuenta.getNombreBanco()+
                    ","+cuenta.getSaldo()+
                    ","+cuenta.getTipoCuenta()+
                    ","+cuenta.getUsuario().getIdUsuario()+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_CUENTAS, contenido, false);
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

    public static Map<String, Usuario> cargarUsuarios() throws IOException {
        Map<String, Usuario> mapaUsuarios = new HashMap<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_USUARIOS);

        for (String linea : contenido) {
            String[] datos = linea.split(",");
            Usuario usuario = new Usuario();
            usuario.setNombre(datos[0]);
            usuario.setIdUsuario(datos[1]);
            usuario.setCorreoElectronico(datos[2]);
            usuario.setNumeroTelefono(datos[3]);
            usuario.setDireccion(datos[4]);
            usuario.setTieneCuenta(Boolean.parseBoolean(datos[5]));

            mapaUsuarios.put(usuario.getIdUsuario(), usuario);
        }
        return mapaUsuarios;
    }


    public static ArrayList<Cuenta> cargarCuentas() throws IOException {
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_CUENTAS);
        Map<String, Usuario> mapaUsuarios = cargarUsuarios(); // Carga usuarios en un mapa

        for (String linea : contenido) {
            String[] datos = linea.split(",");
            Cuenta cuenta = new Cuenta();
            cuenta.setNumeroCuenta(datos[0]);
            cuenta.setIdCuenta(datos[1]);
            cuenta.setNombreBanco(datos[2]);
            cuenta.setSaldo(Double.valueOf(datos[3]));
            cuenta.setTipoCuenta(TipoCuenta.valueOf(datos[4]));

            // Encuentra el usuario usando el idUsuario y lo asigna a la cuenta
            String idUsuario = datos[5];
            Usuario usuario = mapaUsuarios.get(idUsuario);
            cuenta.setUsuario(usuario);

            cuentas.add(cuenta);
        }
        return cuentas;
    }


    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
    {
        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }


    //------------------------------------SERIALIZACIÓN  y XML


    public static BilleteraVirtual cargarRecursoBilleteraVirtualBinario() {

        BilleteraVirtual billeteraVirtual = null;

        try {
            billeteraVirtual = (BilleteraVirtual) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_BILLETERA_VIRTUAL_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return billeteraVirtual;
    }

    public static void guardarRecursoBilleteraVirtualBinario(BilleteraVirtual billeteraVirtual) {
        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_BILLETERA_VIRTUAL_BINARIO, billeteraVirtual);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static BilleteraVirtual cargarRecursoBilleteraVirtualXML() {

        BilleteraVirtual billeteraVirtual = null;

        try {
            billeteraVirtual = (BilleteraVirtual) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_BILLETERA_VIRTUAL_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return billeteraVirtual;

    }



    public static void guardarRecursoBilleteraVirtualXML(BilleteraVirtual billeteraVirtual) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_BILLETERA_VIRTUAL_XML, billeteraVirtual);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
