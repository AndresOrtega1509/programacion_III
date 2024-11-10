package co.edu.uniquindio.proyectofinal.proyectofinal.model;

import co.edu.uniquindio.proyectofinal.proyectofinal.model.enums.TipoTransaccion;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;

    private String idTransaccion;
    private String fecha; // Almacena la fecha como String
    private float monto;
    private String descripcion;
    private Usuario usuario;
    private TipoTransaccion tipoTransaccion;

    public Transaccion() {
    }

    public Transaccion(String idTransaccion, LocalDateTime fecha, float monto, String descripcion, Usuario usuario, TipoTransaccion tipoTransaccion) {
        this.idTransaccion = idTransaccion;
        this.fecha = fechaToString(fecha); // Convierte LocalDateTime a String
        this.monto = monto;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public LocalDateTime getFechaAsLocalDateTime() {
        return stringToFecha(fecha); // Convierte String a LocalDateTime
    }

    public void setFechaAsLocalDateTime(LocalDateTime fecha) {
        this.fecha = fechaToString(fecha); // Convierte LocalDateTime a String
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    // Métodos de conversión entre LocalDateTime y String
    private String fechaToString(LocalDateTime fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return fecha.format(formatter);
    }

    private LocalDateTime stringToFecha(String fechaStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return LocalDateTime.parse(fechaStr, formatter);
    }
}
