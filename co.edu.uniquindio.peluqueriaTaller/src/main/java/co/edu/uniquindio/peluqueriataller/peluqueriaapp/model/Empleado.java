package co.edu.uniquindio.peluqueriataller.peluqueriaapp.model;

public class Empleado extends Persona{

    public Empleado() {
    }

    @Override
    public String toString() {
        return "Empleado:" + "\n"+
                "nombre= " + getNombre() + "\n"+
                "apellido= " + getApellido() + "\n"+
                "cedula= " + getCedula() + "\n"+
                "correo= " + getCorreo() + "\n"+
                "celular= " + getCelular() + "\n";
    }
}
