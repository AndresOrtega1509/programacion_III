package co.edu.uniquindio.proyectofinal.proyectofinal.model;

import java.util.List;

public class Cuenta {

    private String idCuenta;
    private String nombreBanco;
    private String numeroCuenta;
    private String saldo;
    private Usuario usuario;
    private List<Transaccion> listaTransacciones;

    public Cuenta() {
    }

    public Cuenta(String idCuenta, String nombreBanco, String numeroCuenta, String saldo, Usuario usuario, List<Transaccion> listaTransacciones) {
        this.idCuenta = idCuenta;
        this.nombreBanco = nombreBanco;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.usuario = usuario;
        this.listaTransacciones = listaTransacciones;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(List<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }
}
