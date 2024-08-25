package co.edu.uniquindio.peluqueriataller.peluqueriaapp.model;

public class Cliente extends Persona{

    public Cliente() {
    }

    @Override
    public String toString() {
        return "Cliente:" + "\n"+
                "nombre= " + getNombre() + "\n"+
                "apellido= " + getApellido() + "\n"+
                "cedula= " + getCedula() + "\n"+
                "correo= " + getCorreo() + "\n"+
                "celular= " + getCelular() + "\n";
    }
}
