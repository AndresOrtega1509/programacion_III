package co.edu.uniquindio.carros;

import co.edu.uniquindio.carros.utils.ArchivoUtils;

import java.io.IOException;

public class Punto_1_2 {
    public static void main(String[] args) throws IOException {

        String archivoRutaAbsoluta = "C:/Users/ANDRES ORTEGA/OneDrive/Documentos/Programación_III/programacion_III/co.edu.uniquindio.carros/src/main/resources/persistencia/archivoCarros.txt";
        String archivoRutaRelativa = "src/main/resources/persistencia/archivoCarros.txt";

        ArchivoUtils.leerArchivo("C:/Users/ANDRES ORTEGA/OneDrive/Documentos/Programación_III/programacion_III/co.edu.uniquindio.carros/src/main/resources/persistencia/archivoCarros.txt");

        //ArchivoUtils.escribirArchivo("C:/Users/ANDRES ORTEGA/OneDrive/Documentos/Programación_III/programacion_III/co.edu.uniquindio.carros/src/main/resources/persistencia/archivoCarros.txt",
                //"Lamborghini;Aventador SVJ;Verde; 6.5L V12, 770 hp");

        //ArchivoUtils.adicionarCarro("C:/Users/ANDRES ORTEGA/OneDrive/Documentos/Programación_III/programacion_III/co.edu.uniquindio.carros/src/main/resources/persistencia/archivoCarros.txt",
                //"Ferrari;488;Rojo;3.9L V8 Turbo");

        ArchivoUtils.guardarArchivo(archivoRutaAbsoluta, "BMW;M5 Competition;Negro azabache;4.4L V8 Twin Turbo, 617 hp", true);
        //ArchivoUtils.guardarArchivo(archivoRutaRelativa, "BMW;M5 Competition;Negro azabache;4.4L V8 Twin Turbo, 617 hp", true);
    }
}