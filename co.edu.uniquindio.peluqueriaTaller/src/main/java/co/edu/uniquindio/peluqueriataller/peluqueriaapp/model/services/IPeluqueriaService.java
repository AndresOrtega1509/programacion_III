package co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.services;

import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Cita;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Cliente;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Empleado;

import java.time.LocalDate;

public interface IPeluqueriaService {

    Cliente crearCliente (String nombre, String apellido, String cedula, String correo,
                           String celular) throws Exception;
    Empleado crearEmpleado (String nombre, String apellido, String cedula, String correo,
                                   String celular) throws Exception;
    Cita crearCita (Cliente cliente, Empleado empleado, LocalDate fecha) throws Exception;
    boolean  verificarClienteExistente(String cedula) throws Exception;
    boolean  verificarEmpleadoExistente(String cedula) throws Exception;
}
