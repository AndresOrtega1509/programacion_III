package co.edu.uniquindio.peluqueriataller.peluqueriaapp.model;

import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.services.IPeluqueriaService;

import java.time.LocalDate;
import java.util.ArrayList;

public class Peluqueria implements IPeluqueriaService {

    ArrayList<Cliente> listaClientes = new ArrayList<>();
    ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    ArrayList<Cita> listaCitas = new ArrayList<>();

    public Peluqueria() {
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Cita> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(ArrayList<Cita> listaCitas) {
        this.listaCitas = listaCitas;
    }

    @Override
    public Cliente crearCliente(String nombre, String apellido, String cedula, String correo, String celular) throws Exception {
        Cliente nuevoCliente;
        boolean clienteExiste = verificarClienteExistente(cedula);
        if(clienteExiste){
            throw new Exception("El cliente con cedula: "+cedula+" ya existe");
        }else{
            nuevoCliente = new Cliente();
            nuevoCliente.setNombre(nombre);
            nuevoCliente.setApellido(apellido);
            nuevoCliente.setCedula(cedula);
            nuevoCliente.setCorreo(correo);
            nuevoCliente.setCelular(celular);
            getListaClientes().add(nuevoCliente);
        }
        return nuevoCliente;
    }

    @Override
    public Empleado crearEmpleado(String nombre, String apellido, String cedula, String correo, String celular) throws Exception {
        Empleado nuevoEmpleado;
        boolean empleadoExiste = verificarEmpleadoExistente(cedula);
        if(empleadoExiste){
            throw new Exception("El empleado con cedula: "+cedula+" ya existe");
        }else{
            nuevoEmpleado = new Empleado();
            nuevoEmpleado.setNombre(nombre);
            nuevoEmpleado.setApellido(apellido);
            nuevoEmpleado.setCedula(cedula);
            nuevoEmpleado.setCorreo(correo);
            nuevoEmpleado.setCelular(celular);
            getListaEmpleados().add(nuevoEmpleado);
        }
        return nuevoEmpleado;
    }

    @Override
    public Cita crearCita(Cliente cliente, Empleado empleado, LocalDate fecha) throws Exception {
        return null;
    }

    @Override
    public boolean verificarClienteExistente(String cedula) throws Exception {
        if(clienteExiste(cedula)){
            throw new Exception("El cliente con cedula: "+cedula+" ya existe");
        }else{
            return false;
        }
    }


    @Override
    public boolean verificarEmpleadoExistente(String cedula) throws Exception {
        if(empleadoExiste(cedula)){
            throw new Exception("El empleado con cedula: "+cedula+" ya existe");
        }else{
            return false;
        }
    }

    private boolean clienteExiste(String cedula) {

        boolean clienteEncontrado = false;
        for (Cliente cliente : getListaClientes()) {
            if(cliente.getCedula().equalsIgnoreCase(cedula)){
                clienteEncontrado = true;
                break;
            }
        }
        return clienteEncontrado;
    }

    private boolean empleadoExiste(String cedula) {

        boolean empleadoEncontrado = false;
        for (Empleado empleado : getListaEmpleados()) {
            if(empleado.getCedula().equalsIgnoreCase(cedula)){
                empleadoEncontrado = true;
                break;
            }
        }
        return empleadoEncontrado;
    }
}
