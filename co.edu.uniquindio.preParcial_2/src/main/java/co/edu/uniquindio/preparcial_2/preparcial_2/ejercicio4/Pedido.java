package co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDate fecha;
    private double total;
    private Cliente cliente;
    private ArrayList<Producto> productos;

    public Pedido() {
    }

    public Pedido(LocalDate fecha, double total, Cliente cliente, ArrayList<Producto> productos) {
        this.fecha = fecha;
        this.total = total;
        this.cliente = cliente;
        this.productos = productos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "fecha=" + fecha +
                ", total=" + total +
                ", cliente=" + cliente +
                ", productos=" + productos +
                '}';
    }
}
