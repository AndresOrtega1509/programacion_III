package co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4.utils;

import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4.Cliente;
import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4.Pedido;
import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4.Producto;
import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4.Restaurante;
import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_1.utils.ArchivoUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Persistencia2 {

    public static final String RUTA_ARCHIVO_CLIENTES = "src/main/resources/persistencia/archivoClientes.txt";
    public static final String RUTA_ARCHIVO_PRODUCTOS = "src/main/resources/persistencia/archivoProductos.txt";
    public static final String RUTA_ARCHIVO_PEDIDOS = "src/main/resources/persistencia/archivoPedidos.txt";
    public static final String RUTA_ARCHIVO_MODELO_PEDIDOS_XML = "src/main/resources/persistencia/modelPedidos.xml";
    public static final String RUTA_ARCHIVO_MODELO_PEDIDO_BINARIO = "src/main/resources/persistencia/modelPedido.dat";



    public static void cargarDatosArchivos(Restaurante restaurante) throws FileNotFoundException, IOException {
        //cargar archivo de clientes
        ArrayList<Cliente> clientesCargados = cargarClientes();
        if(clientesCargados.size() > 0)
            restaurante.getClientes().addAll(clientesCargados);

        ArrayList<Producto> productosCargados = cargarProductos();
        if (productosCargados.size() > 0)
            restaurante.getProductos().addAll(productosCargados);

        ArrayList<Pedido> pedidosCargados = cargarPedidos(restaurante);
        if (productosCargados.size() > 0)
            restaurante.getPedidos().addAll(pedidosCargados);

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
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_CLIENTES, contenido, false);
    }

    public static void guardarProductos(ArrayList<Producto> listaProductos) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";
        for(Producto producto:listaProductos)
        {
            contenido+= producto.getCodigo()+"#"+producto.getNombre()+"#"+producto.getPrecio()+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PRODUCTOS, contenido, false);
    }
    public static void guardarPedidos(ArrayList<Pedido> listaPedidos) throws IOException {
        // Crear un StringBuilder para contener todos los pedidos
        StringBuilder contenido = new StringBuilder();

        // Recorrer la lista de pedidos y construir el contenido para cada pedido
        for (Pedido pedido : listaPedidos) {
            // Obtener la fecha y el total
            String linea = pedido.getFecha().toString() + "," + pedido.getTotal();

            // Obtener el código del cliente asociado
            String codigoCliente = pedido.getCliente().getCodigo();
            linea += "," + codigoCliente;

            // Obtener los códigos de los productos asociados al pedido
            ArrayList<Producto> productos = pedido.getProductos();
            StringBuilder codigosProductos = new StringBuilder();
            for (Producto producto : productos) {
                codigosProductos.append(producto.getCodigo()).append(",");
            }
            // Eliminar el último delimitador '#'
            if (codigosProductos.length() > 0) {
                codigosProductos.setLength(codigosProductos.length() - 1);
            }

            // Agregar los códigos de productos al final de la línea
            linea += "," + codigosProductos.toString();

            // Agregar esta línea al contenido general
            contenido.append(linea).append("\n");
        }

        // Guardar el contenido en el archivo de pedidos
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PEDIDOS, contenido.toString(), false);
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
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_CLIENTES);
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
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PRODUCTOS);
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

    private static ArrayList<Pedido> cargarPedidos(Restaurante restaurante) throws IOException {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PEDIDOS);
        String linea = "";

        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i);

            // Crear un nuevo objeto Pedido
            Pedido pedido = new Pedido();

            // Parsear la fecha y el total del pedido
            pedido.setFecha(LocalDate.parse(linea.split(",")[0]));
            pedido.setTotal(Double.parseDouble(linea.split(",")[1]));

            // Obtener el código del cliente y buscarlo en la lista de clientes cargados
            String codigoCliente = linea.split(",")[2];
            Cliente cliente = buscarClientePorCodigo(restaurante.getClientes(), codigoCliente);
            if (cliente != null) {
                pedido.setCliente(cliente);  // Asignar el cliente al pedido
            } else {
                System.out.println("Cliente con código " + codigoCliente + " no encontrado.");
            }

            // Obtener los códigos de los productos, separarlos y buscar los productos en la lista cargada
            String[] codigosProductos = linea.split(",")[3].split("#");
            ArrayList<Producto> productosPedido = new ArrayList<>();
            for (String codigoProducto : codigosProductos) {
                Producto producto = buscarProductoPorCodigo(restaurante.getProductos(), codigoProducto);
                if (producto != null) {
                    productosPedido.add(producto);  // Agregar el producto a la lista de productos del pedido
                } else {
                    System.out.println("Producto con código " + codigoProducto + " no encontrado.");
                }
            }
            pedido.setProductos(productosPedido);  // Asignar la lista de productos al pedido

            // Agregar el pedido a la lista de pedidos
            pedidos.add(pedido);
        }
        return pedidos;
    }

    // Método para buscar un cliente por código en la lista de clientes
    private static Cliente buscarClientePorCodigo(ArrayList<Cliente> clientes, String codigo) {
        for (Cliente cliente : clientes) {
            if (cliente.getCodigo().equals(codigo)) {
                return cliente;
            }
        }
        return null;  // Retorna null si no se encuentra el cliente
    }

    // Método para buscar un producto por código en la lista de productos
    private static Producto buscarProductoPorCodigo(ArrayList<Producto> productos, String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;  // Retorna null si no se encuentra el producto
    }




    //------------------------------------SERIALIZACIÓN  y XML



    public static Pedido cargarRecursoPedidoXML() {

        Pedido pedido= null;

        try {
            pedido = (Pedido) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_PEDIDOS_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return pedido;

    }



    public static void guardarRecursoPedidoXML(Pedido pedido)  {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_PEDIDOS_XML, pedido);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Pedido cargarRecursoPedidoBinario() {

        Pedido pedido = null;

        try {
            pedido = (Pedido) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_PEDIDO_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return pedido;
    }

    public static void guardarRecursoPedidoBinario(Pedido pedido)  {
        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_PEDIDO_BINARIO, pedido);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
