package co.edu.uniquindio.peluqueriataller.peluqueriaapp.utils;

import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Cliente;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Empleado;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Peluqueria;

public class PeluqueriaUtils {

    public static Peluqueria inicializarDatos() {

        Peluqueria peluqueria = new Peluqueria();

        Cliente cliente = new Cliente();
        cliente.setNombre("Luiz");
        cliente.setApellido("Ortiz");
        cliente.setCedula("1039435843");
        cliente.setCorreo("luisOr@gmail.com");
        cliente.setCelular("3132334323");

        cliente = new Cliente();
        cliente.setNombre("Sara");
        cliente.setApellido("Sanchez");
        cliente.setCedula("1028435493");
        cliente.setCorreo("saraSan@gmail.com");
        cliente.setCelular("3103948593");

        peluqueria.getListaClientes().add(cliente);

        Empleado empleado = new Empleado();
        empleado.setNombre("Ana");
        empleado.setApellido("Rodriguez");
        empleado.setCedula("1093283364");
        empleado.setCorreo("anaRod@gmail.com");
        empleado.setCelular("3178384847");

        empleado = new Empleado();
        empleado.setNombre("Santiago");
        empleado.setApellido("Cardona");
        empleado.setCedula("1043837483");
        empleado.setCorreo("santiagoCard@gmail.com");
        empleado.setCelular("3148594394");

        peluqueria.getListaEmpleados().add(empleado);

        return peluqueria;

    }

}
