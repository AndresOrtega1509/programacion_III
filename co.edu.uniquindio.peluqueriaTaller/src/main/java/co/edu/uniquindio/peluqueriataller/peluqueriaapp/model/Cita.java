package co.edu.uniquindio.peluqueriataller.peluqueriaapp.model;

import java.time.LocalDate;
public class Cita {

    private Cliente cliente;
    private Empleado empleado;
    private LocalDate fecha;

    public Cita() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
