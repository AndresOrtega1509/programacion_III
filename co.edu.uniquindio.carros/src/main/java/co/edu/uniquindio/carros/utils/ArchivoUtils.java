package co.edu.uniquindio.carros.utils;

import java.io.*;
import java.util.ArrayList;

public class ArchivoUtils {

    public static void guardarArchivo(String ruta,String contenido, Boolean flagAnexarContenido) throws IOException {

        FileWriter fw = new FileWriter(ruta,flagAnexarContenido);
        BufferedWriter bfw = new BufferedWriter(fw);
        bfw.newLine();
        bfw.write(contenido);
        bfw.close();
        fw.close();

        System.out.println("Archivo guardado exitosamente");
    }

    public static ArrayList<String> leerArchivo(String ruta) throws IOException {

        ArrayList<String>  contenido = new ArrayList<String>();
        FileReader fr=new FileReader(ruta);
        BufferedReader bfr=new BufferedReader(fr);
        String linea="";
        while((linea = bfr.readLine())!=null)
        {
            contenido.add(linea);
        }
        bfr.close();
        fr.close();
        System.out.println(contenido);
        return contenido;
    }

    public static void escribirArchivo(String ruta, String contenido) {

        try {

            FileWriter archivo = new FileWriter(ruta);
            PrintWriter escritor = new PrintWriter(archivo);

            escritor.println(contenido);

            archivo.close();
            escritor.close();

            System.out.println(contenido);

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void adicionarCarro(String ruta, String nuevoCarro) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta, true))) {
            writer.newLine();
            writer.write(nuevoCarro);

            System.out.println(nuevoCarro);

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
