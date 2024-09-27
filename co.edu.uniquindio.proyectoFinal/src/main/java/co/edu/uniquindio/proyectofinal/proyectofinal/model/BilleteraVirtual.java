package co.edu.uniquindio.proyectofinal.proyectofinal.model;

import java.util.ArrayList;

public class BilleteraVirtual {

    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Cuenta> listaCuentas;

    public BilleteraVirtual() {
        listaUsuarios = new ArrayList<>();
        listaCuentas = new ArrayList<>();
    }
}
