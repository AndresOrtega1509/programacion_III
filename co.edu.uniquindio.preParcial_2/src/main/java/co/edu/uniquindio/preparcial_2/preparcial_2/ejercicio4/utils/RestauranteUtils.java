package co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4.utils;


import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4.Cliente;
import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4.Pedido;
import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4.Producto;
import co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4.Restaurante;

import java.time.LocalDate;


public class RestauranteUtils {

    public static Restaurante inicializarDatos() {

        Restaurante restaurante = new Restaurante();

        Cliente cliente1 = new Cliente();
        cliente1.setCodigo("123");
        cliente1.setCedula("1016");
        cliente1.setTipoIdentificacion("C.C");
        cliente1.setNombre("Oscar");
        cliente1.setApellido("Martinez");
        cliente1.setTelefono("123456");

        Cliente cliente2 = new Cliente();
        cliente2.setCodigo("111");
        cliente2.setCedula("1084");
        cliente2.setTipoIdentificacion("T.I");
        cliente2.setNombre("Sara");
        cliente2.setApellido("Ortiz");
        cliente2.setTelefono("9467566");

        restaurante.getClientes().add(cliente1);
        restaurante.getClientes().add(cliente2);

        Producto producto1 = new Producto();
        producto1.setCodigo("986");
        producto1.setNombre("Bandeja paisa");
        producto1.setPrecio(30.000);

        Producto producto2 = new Producto();
        producto2.setCodigo("852");
        producto2.setNombre("Sancocho");
        producto2.setPrecio(20.000);

        Pedido pedido1 = new Pedido();
        pedido1.setCliente(cliente1);
        pedido1.setFecha(LocalDate.now());
        pedido1.setTotal(30.000);
        pedido1.setProductos(restaurante.getProductos());

        restaurante.getProductos().add(producto1);
        restaurante.getProductos().add(producto2);
        restaurante.getPedidos().add(pedido1);

        System.out.println(cliente1);
        System.out.println(cliente2);
        System.out.println(producto1);
        System.out.println(producto2);
        System.out.println(pedido1);

        return restaurante;

    }

}
