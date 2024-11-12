package co.edu.uniquindio.preparcial_3.preparcial_3.productorConsumidorHilos.ejercicio2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Consumidor extends Thread {

    private final Tuberia tuberia;
    private final char[] palabraFormada;
    private final ArrayList<Character> letrasSobrantes;
    private static final String PALABRA_OBJETIVO = "universid@d#2024-2%";
    private final boolean[] posicionesLlenas;
    static String fechaSistema = "";

    public Consumidor(Tuberia tuberia) {
        this.tuberia = tuberia;
        this.palabraFormada = new char[PALABRA_OBJETIVO.length()];
        this.letrasSobrantes = new ArrayList<>();
        this.posicionesLlenas = new boolean[PALABRA_OBJETIVO.length()];  // Mantiene registro de las posiciones llenas
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Verifica si la palabra ya está completamente formada
                if (new String(palabraFormada).equals(PALABRA_OBJETIVO)) {
                    break;
                }

                // Recoge dos caracteres de la tubería
                char c1 = tuberia.recoger();
                char c2 = tuberia.recoger();

                // Coloca los caracteres en la posición correcta o los agrega a letrasSobrantes
                colocarCaracter(c1);
                colocarCaracter(c2);

                // Imprime el progreso actual
                System.out.println("Progreso de palabra: " + new String(palabraFormada));

                // Simula la espera de 500 milisegundos
                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

        mostrarResultados();  // Muestra los resultados cuando la palabra esté completa
        guardarLetrasSobrantes();
        guardarRegistroLog("palabra armada", "colocarCaracter", "src/main/resources/co/edu/uniquindio/preparcial_3/preparcial_3/archivos/registroLog.txt");
    }

    private void colocarCaracter(char c) {
        // Busca si el carácter está en la palabra objetivo y en una posición aún no llena
        for (int i = 0; i < PALABRA_OBJETIVO.length(); i++) {
            if (PALABRA_OBJETIVO.charAt(i) == c && !posicionesLlenas[i]) {
                palabraFormada[i] = c;  // Coloca el carácter en la posición correspondiente
                posicionesLlenas[i] = true;  // Marca esta posición como completa
                return;  // Indica que el carácter fue colocado en la palabra
            }
        }
        // Si no se coloca en la palabra, se guarda en letras sobrantes
        letrasSobrantes.add(c);
    }

    private void mostrarResultados() {
        System.out.println("Palabra formada: " + new String(palabraFormada));
        System.out.println("Letras sobrantes: " + letrasSobrantes);
    }

    private void guardarLetrasSobrantes() {
        try (FileWriter writer = new FileWriter("src/main/resources/co/edu/uniquindio/preparcial_3/preparcial_3/archivos/letrasSobrantes.txt")) {
            for (Character c : letrasSobrantes) {
                writer.write(c);
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarRegistroLog(String mensajeLog, String accion,String rutaArchivo)
    {
        String log = "";
        Logger LOGGER = Logger.getLogger(accion);
        FileHandler fileHandler =  null;
        cargarFechaSistema();
        try {
            fileHandler = new FileHandler(rutaArchivo,true);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);

            LOGGER.log(Level.INFO,accion+","+mensajeLog+","+fechaSistema) ;


        } catch (SecurityException e) {

            LOGGER.log(Level.SEVERE,e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            LOGGER.log(Level.SEVERE,e.getMessage());
            e.printStackTrace();
        }
        finally {

            fileHandler.close();
        }
    }

    private static void cargarFechaSistema() {

        String diaN = "";
        String mesN = "";
        String añoN = "";

        Calendar cal1 = Calendar.getInstance();


        int  dia = cal1.get(Calendar.DATE);
        int mes = cal1.get(Calendar.MONTH)+1;
        int año = cal1.get(Calendar.YEAR);
        int hora = cal1.get(Calendar.HOUR);
        int minuto = cal1.get(Calendar.MINUTE);


        if(dia < 10){
            diaN+="0"+dia;
        }
        else{
            diaN+=""+dia;
        }
        if(mes < 10){
            mesN+="0"+mes;
        }
        else{
            mesN+=""+mes;
        }

        //		fecha_Actual+= año+"-"+mesN+"-"+ diaN;
        //		fechaSistema = año+"-"+mesN+"-"+diaN+"-"+hora+"-"+minuto;
        fechaSistema = año+"-"+mesN+"-"+diaN;
        //		horaFechaSistema = hora+"-"+minuto;
    }
}
