package co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4;

import java.util.ArrayList;

public class Restaurante {

    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos;
    private ArrayList<Pedido> pedidos;

    public Restaurante() {
    }

    public Restaurante(ArrayList<Cliente> clientes, ArrayList<Producto> productos, ArrayList<Pedido> pedidos) {
        this.clientes = clientes;
        this.productos = productos;
        this.pedidos = pedidos;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
