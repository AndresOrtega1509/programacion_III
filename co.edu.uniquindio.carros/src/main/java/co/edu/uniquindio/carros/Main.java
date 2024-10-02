package co.edu.uniquindio.carros;

import co.edu.uniquindio.carros.utils.ArchivoUtils;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ArchivoUtils.leerArchivo("C:/Users/ANDRES ORTEGA/OneDrive/Documentos/Programación_III/programacion_III/co.edu.uniquindio.carros/src/main/java/persistencia/archivoCarros.txt");

        //ArchivoUtils.escribirArchivo("C:/Users/ANDRES ORTEGA/OneDrive/Documentos/Programación_III/programacion_III/co.edu.uniquindio.carros/src/main/java/persistencia/archivoCarros.txt",
                //"Lamborghini;Aventador SVJ;Verde; 6.5L V12, 770 hp);

        ArchivoUtils.adicionarCarro("C:/Users/ANDRES ORTEGA/OneDrive/Documentos/Programación_III/programacion_III/co.edu.uniquindio.carros/src/main/java/persistencia/archivoCarros.txt",
                "Ferrari;488;Rojo;3.9L V8 Turbo");
    }
}