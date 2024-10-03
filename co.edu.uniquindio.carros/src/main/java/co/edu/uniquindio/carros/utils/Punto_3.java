package co.edu.uniquindio.carros.utils;

import java.io.*;
import java.util.Properties;

public class Punto_3 {

    public static void main(String[] args) {

        String rutaArchivoPropiedades = "/persistencia/baseDatos.properties";

        Properties properties = new Properties();
        try (InputStream inputStream = Punto_3.class.getResourceAsStream(rutaArchivoPropiedades)) {

            if (inputStream != null) {
                // Cargar las propiedades del archivo
                properties.load(inputStream);

                // Mostrar las propiedades leídas
                System.out.println("Usuario: " + properties.getProperty("usuario"));
                System.out.println("Password: " + properties.getProperty("password"));
                System.out.println("Puerto: " + properties.getProperty("puerto"));
                System.out.println("Host1: " + properties.getProperty("host1"));
                System.out.println("Host2: " + properties.getProperty("host2"));
                System.out.println("Endpoint1: " + properties.getProperty("endpoint1"));
                System.out.println("Endpoint2: " + properties.getProperty("endpoint2"));

                // Ruta para el archivo separado por '@'
                String rutaArchivoSeparado = "src/main/resources/persistencia/baseDatos_separadoPorArroba.txt";

                // Guardar las propiedades en un archivo separado por '@'
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivoSeparado))) {
                    for (String clave : properties.stringPropertyNames()) {
                        String valor = properties.getProperty(clave);
                        // Escribir cada propiedad en formato clave@valor
                        writer.write(clave + "@" + valor);
                        writer.newLine();
                    }
                    // Guardar los datos
                    writer.flush();
                    System.out.println("Archivo guardado correctamente en: " + rutaArchivoSeparado);

                } catch (IOException e) {
                    System.out.println("Error al escribir el archivo separado: " + e.getMessage());
                }
            } else {
                System.out.println("No se pudo encontrar el archivo de propiedades en la ruta: " + rutaArchivoPropiedades);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo de propiedades: " + e.getMessage());
        }
    }
}
