package co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto;

import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Cliente;
import co.edu.uniquindio.peluqueriataller.peluqueriaapp.model.Empleado;

import java.time.LocalDate;

public record CitaDto(String cliente,
                      String empleado,
                      LocalDate fecha,
                      String hora) {
}
