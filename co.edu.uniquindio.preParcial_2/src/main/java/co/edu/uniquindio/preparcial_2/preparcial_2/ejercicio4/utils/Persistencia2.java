package co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4.utils;

import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4.Cliente;
import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4.Pedido;
import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4.Producto;
import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4.Restaurante;
import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_1.Estudiante;
import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_1.utils.ArchivoUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia2 {

    public static final String RUTA_ARCHIVO_CLIENTES = "src/main/resources/persistencia/archivoClientes.txt";
    public static final String RUTA_ARCHIVO_PRODUCTOS = "src/main/resources/persistencia/archivoProductos.txt";

    public static final String RUTA_ARCHIVO_MODELO_PEDIDOS_XML = "src/main/resources/persistencia/modelPedidos.xml";



    public static void cargarDatosArchivos(Restaurante restaurante) throws FileNotFoundException, IOException {
        //cargar archivo de clientes
        ArrayList<Cliente> clientesCargados = cargarClientes();
        if(clientesCargados.size() > 0)
            restaurante.getClientes().addAll(clientesCargados);

        ArrayList<Producto> productosCargados = cargarProductos();
        if (productosCargados.size() > 0)
            restaurante.getProductos().addAll(productosCargados);

    }

    /**
     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
     * @param
     * @param
     * @throws IOException
     */
    public static void guardarClientes(ArrayList<Cliente> listaClientes) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";
        for(Cliente cliente:listaClientes)
        {
            contenido+= cliente.getCodigo()+"@"+cliente.getCedula()+"@"+cliente.getTipoIdentificacion()+"@"+cliente.getNombre()
                    +"@"+cliente.getApellido()+"@"+ cliente.getTelefono() +"\n";
        }
        ArchivoUtil2.guardarArchivo(RUTA_ARCHIVO_CLIENTES, contenido, false);
    }

    public static void guardarProductos(ArrayList<Producto> listaProductos) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";
        for(Producto producto:listaProductos)
        {
            contenido+= producto.getCodigo()+"#"+producto.getNombre()+"#"+producto.getPrecio()+"#"+"\n";
        }
        ArchivoUtil2.guardarArchivo(RUTA_ARCHIVO_CLIENTES, contenido, false);
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
    public static ArrayList<Cliente> cargarClientes() throws FileNotFoundException, IOException
    {
        ArrayList<Cliente> clientes =new ArrayList<Cliente>();
        ArrayList<String> contenido = ArchivoUtil2.leerArchivo(RUTA_ARCHIVO_CLIENTES);
        String linea="";
        for (int i = 0; i < contenido.size(); i++)
        {
            linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
            Cliente cliente = new Cliente();
            cliente.setCodigo(linea.split("@")[0]);
            cliente.setCedula(linea.split("@")[1]);
            cliente.setTipoIdentificacion(linea.split("@")[2]);
            cliente.setNombre(linea.split("@")[3]);
            cliente.setApellido(linea.split("@")[4]);
            cliente.setTelefono(linea.split("@")[5]);
            clientes.add(cliente);

        }
        return clientes;
    }

    public static ArrayList<Producto> cargarProductos() throws FileNotFoundException, IOException
    {
        ArrayList<Producto> productos =new ArrayList<Producto>();
        ArrayList<String> contenido = ArchivoUtil2.leerArchivo(RUTA_ARCHIVO_PRODUCTOS);
        String linea="";
        for (int i = 0; i < contenido.size(); i++)
        {
            linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
            Producto producto = new Producto();
            producto.setCodigo(linea.split("#")[0]);
            producto.setNombre(linea.split("#")[1]);
            producto.setPrecio(Double.parseDouble(linea.split("#")[2]));
            productos.add(producto);

        }
        return productos;
    }




    //------------------------------------SERIALIZACIÓN  y XML



    public static Pedido cargarRecursoPedidoXML() {

        Pedido pedido= null;

        try {
            pedido = (Pedido) ArchivoUtil2.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_PEDIDOS_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return pedido;

    }



    public static void guardarRecursoEstudianteXML(Pedido pedido) throws IOException {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_PEDIDOS_XML, pedido);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
