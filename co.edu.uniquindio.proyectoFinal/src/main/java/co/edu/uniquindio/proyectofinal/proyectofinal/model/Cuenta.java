package co.edu.uniquindio.proyectofinal.proyectofinal.model;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoCuenta;
import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoTransaccion;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idCuenta;
    private String nombreBanco;
    private String numeroCuenta;
    private Double saldo;
    private Usuario usuario;
    private List<Transaccion> listaTransacciones;
    private TipoCuenta tipoCuenta;

    public Cuenta() {
        this.listaTransacciones = new ArrayList<>();
    }

    public Cuenta(String idCuenta, String nombreBanco, String numeroCuenta, Double saldo, Usuario usuario,
                  TipoCuenta tipoCuenta) {
        this.idCuenta = idCuenta;
        this.nombreBanco = nombreBanco;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.usuario = usuario;
        this.tipoCuenta = tipoCuenta;
        this.listaTransacciones = new ArrayList<>();
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

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
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

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    @Override
    public String toString() {
        return
                "nombreBanco='" + nombreBanco + '\'' +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                '}';
    }

    public Transaccion transferir(float cantidad, Cuenta cuentaDestino, TipoTransaccion tipoTransaccion, String descripcion, String idTransaccion) throws Exception {

        if (saldo >= cantidad) {

            // Se realiza el retiro
            saldo -= cantidad;

            // Se crea la transacción de retiro
            Transaccion transaccion = new Transaccion();
            transaccion.setIdTransaccion(idTransaccion);
            transaccion.setFechaAsLocalDateTime(LocalDateTime.now());
            transaccion.setTipoTransaccion(TipoTransaccion.RETIRO);
            transaccion.setDescripcion(descripcion);
            transaccion.setUsuario(cuentaDestino.getUsuario());
            transaccion.setMonto(cantidad);

            // Se registra la transacción de retiro en la cuenta de origen
            listaTransacciones.add(transaccion);

            return transaccion;

        } else {
            throw new Exception("Saldo insuficiente");
        }
    }

    public Transaccion depositar(float cantidad, Usuario emisor, String descripcion, String idTransaccion) throws Exception {

        // Se realiza el depósito
        saldo += cantidad;

        // Se crea la transacción de depósito
        Transaccion transaccion = new Transaccion();
        transaccion.setIdTransaccion(idTransaccion);
        transaccion.setFechaAsLocalDateTime(LocalDateTime.now());
        transaccion.setTipoTransaccion(TipoTransaccion.DEPOSITO);
        transaccion.setDescripcion(descripcion);
        transaccion.setUsuario(emisor);
        transaccion.setMonto(cantidad);

        // Se registra la transacción de depósito
        listaTransacciones.add(transaccion);

        return transaccion;
    }

    public Transaccion retirar(float cantidad, TipoTransaccion tipoTransaccion, String descripcion) throws Exception {

        if (saldo >= cantidad) {

            // Se realiza el retiro
            saldo -= cantidad;
            String idTransaccion = UUID.randomUUID().toString();

            // Se crea la transacción de retiro
            Transaccion transaccion = new Transaccion();
            transaccion.setIdTransaccion(idTransaccion);
            transaccion.setFechaAsLocalDateTime(LocalDateTime.now());
            transaccion.setTipoTransaccion(tipoTransaccion);
            transaccion.setDescripcion(descripcion);
            transaccion.setUsuario(usuario);
            transaccion.setMonto(cantidad);

            // Se registra la transacción de retiro en la cuenta de origen
            listaTransacciones.add(transaccion);

            return transaccion;

        } else {
            throw new Exception("Saldo insuficiente");
        }

    }

}
