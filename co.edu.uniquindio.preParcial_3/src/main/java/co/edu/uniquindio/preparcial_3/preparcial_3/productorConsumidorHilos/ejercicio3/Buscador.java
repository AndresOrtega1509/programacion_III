package co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Buscador extends Thread{

    private String palabra;
    private String rutaDirectorio;
    private int cantidadArchivos;

    public Buscador(String palabra, String rutaDirectorio) {
        this.palabra = palabra;
        this.rutaDirectorio = rutaDirectorio;
    }

    @Override
    public void run() {
        File directorio = new File(rutaDirectorio);
        if (directorio.exists() && directorio.isDirectory()) {
            File[] archivos = directorio.listFiles((dir, name) -> name.endsWith(".txt"));
            if (archivos != null) {
                for (File archivo : archivos) {
                    buscarEnArchivo(archivo);
                }
            }
        } else {
            System.out.println("El directorio no existe.");
        }

        // Imprimir el resultado cuando termina la búsqueda en todos los archivos
        System.out.println("La palabra '" + palabra + "' se encontró en " + cantidadArchivos + " archivos.");
    }

    private void buscarEnArchivo(File archivo) {

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.contains(palabra)) {
                    // Si la palabra está en la línea, incrementamos el contador
                    cantidadArchivos++;
                    break;  // Salir del bucle, ya que la palabra ya está encontrada en este archivo
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
