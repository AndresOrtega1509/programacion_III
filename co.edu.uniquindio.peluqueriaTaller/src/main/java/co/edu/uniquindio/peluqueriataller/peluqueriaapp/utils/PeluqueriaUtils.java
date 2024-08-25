package co.edu.uniquindio.peluqueriataller.peluqueriaapp.utils;

import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Cliente;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Empleado;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Peluqueria;

public class PeluqueriaUtils {

    public static Peluqueria inicializarDatos() {

        Peluqueria peluqueria = new Peluqueria();

        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Luiz");
        cliente1.setApellido("Ortiz");
        cliente1.setCedula("1039435843");
        cliente1.setCorreo("luisOr@gmail.com");
        cliente1.setCelular("3132334323");

        Cliente cliente2 = new Cliente();
        cliente2.setNombre("Sara");
        cliente2.setApellido("Sanchez");
        cliente2.setCedula("1028435493");
        cliente2.setCorreo("saraSan@gmail.com");
        cliente2.setCelular("3103948593");

        peluqueria.getListaClientes().add(cliente1);
        peluqueria.getListaClientes().add(cliente2);

        Empleado empleado1 = new Empleado();
        empleado1.setNombre("Ana");
        empleado1.setApellido("Rodriguez");
        empleado1.setCedula("1093283364");
        empleado1.setCorreo("anaRod@gmail.com");
        empleado1.setCelular("3178384847");

        Empleado empleado2 = new Empleado();
        empleado2.setNombre("Santiago");
        empleado2.setApellido("Cardona");
        empleado2.setCedula("1043837483");
        empleado2.setCorreo("santiagoCard@gmail.com");
        empleado2.setCelular("3148594394");

        peluqueria.getListaEmpleados().add(empleado1);
        peluqueria.getListaEmpleados().add(empleado2);

        return peluqueria;

    }

}
