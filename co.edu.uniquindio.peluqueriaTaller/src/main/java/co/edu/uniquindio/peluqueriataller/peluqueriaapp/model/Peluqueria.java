package co.edu.uniquindio.peluqueriataller.peluqueriaapp.model;

import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.services.IPeluqueriaService;
import lombok.Getter;
import lombok.Setter;

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
    public Cita crearCita(Cliente cliente, Empleado empleado, LocalDate fecha, String hora)  {

        Cita nuevaCita = new Cita();
        nuevaCita.setCliente(cliente);
        nuevaCita.setEmpleado(empleado);
        nuevaCita.setFecha(fecha);
        nuevaCita.setHora(hora);
        getListaCitas().add(nuevaCita);

        return nuevaCita;
    }

    @Override
    public Empleado obtenerEmpleado(String cedula) {

        Empleado empleadoEncontrado = null;
        for (Empleado empleado : getListaEmpleados()) {
            if(empleado.getCedula().equalsIgnoreCase(cedula)){
                empleadoEncontrado = empleado;
                break;
            }
        }
        return empleadoEncontrado;
    }

    @Override
    public ArrayList<Empleado> obtenerEmpleados() {
        return listaEmpleados;
    }

    @Override
    public void agregarEmpleado(Empleado nuevoEmpleado) throws Exception{
        getListaEmpleados().add(nuevoEmpleado);
    }

    @Override
    public void agregarCita(Cita nuevaCita) throws Exception{
        getListaCitas().add(nuevaCita);
    }

    @Override
    public void agregarCliente(Cliente nuevoCliente) throws Exception{
        getListaClientes().add(nuevoCliente);
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

    @Override
    public Cliente obtenerClienteCedula(String cedula) throws Exception{

        for (Cliente cliente : listaClientes){
            if (cliente.getCedula().equalsIgnoreCase(cedula)){
                return  cliente;
            }
        }
        throw new Exception("El cliente con cedula: "+ cedula + " no existe");
    }

    @Override
    public Empleado obtenerEmpleadoCedula(String cedula) throws Exception {

        for (Empleado empleado : listaEmpleados){
            if (empleado.getCedula().equalsIgnoreCase(cedula)){
                return empleado;
            }
        }
        throw new Exception("El empleado con cedula: "+ cedula + " no existe");
    }

    @Override
    public boolean actualizarCliente(String cedulaActual, Cliente cliente) throws Exception {
        Cliente clienteActual = obtenerClienteCedula(cedulaActual);
        if(clienteActual == null)
            throw new Exception("El cliente a actualizar no existe");
        else{
            clienteActual.setNombre(cliente.getNombre());
            clienteActual.setApellido(cliente.getApellido());
            clienteActual.setCedula(cliente.getCedula());
            clienteActual.setCorreo(cliente.getCorreo());
            clienteActual.setCelular(cliente.getCelular());

            return true;
        }

    }

    @Override
    public boolean actualizarEmpleado(String cedulaActual, Empleado empleado) throws Exception {
        Empleado empleadoActual = obtenerEmpleado(cedulaActual);
        if(empleadoActual == null)
            throw new Exception("El empleado a actualizar no existe");
        else{
            empleadoActual.setNombre(empleado.getNombre());
            empleadoActual.setApellido(empleado.getApellido());
            empleadoActual.setCedula(empleado.getCedula());
            empleadoActual.setCorreo(empleado.getCorreo());
            empleadoActual.setCelular(empleado.getCelular());
            return true;
        }
    }
    @Override
    public boolean eliminarCliente(String cedula) throws Exception {

        Cliente cliente;
        boolean flagExiste = false;
        cliente = obtenerClienteCedula(cedula);
        if(cliente == null)
            throw new Exception("El cliente a eliminar no existe");
        else{
            getListaClientes().remove(cliente);
            flagExiste = true;
        }
        return flagExiste;
    }

    @Override
    public Boolean eliminarEmpleado(String cedula) throws Exception {
        Empleado empleado;
        boolean flagExiste = false;
        empleado = obtenerEmpleado(cedula);
        if(empleado == null)
            throw new Exception("El empleado a eliminar no existe");
        else{
            getListaEmpleados().remove(empleado);
            flagExiste = true;
        }
        return flagExiste;
    }
}
