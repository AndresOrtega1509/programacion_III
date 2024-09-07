package co.edu.uniquindio.tallerRecursividad.Excepciones;

import java.util.ArrayList;

public class Excepciones {

    public static void main(String[] args) {

        //bloque 1
        //bloque 2
        try {
            //bloque3
            //bloque4
        } catch (ArithmeticException e) {
            //bloque 13
        } catch (NumberFormatException e) {
            //bloque 15
        }catch (Exception e){

            //bloque 5
            try {
                //bloque6
                //bloque7
            } catch (Exception e1) {
                //bloque8
            }finally {
                //bloque9
                System.out.println("finally 1");
            }
            //bloque 10
            //bloque 12
        } finally {
            //bloque 11
            System.out.println("finally 2");
        }

    }
}