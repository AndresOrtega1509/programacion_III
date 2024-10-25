package co.edu.uniquindio.preparcial_2.preparcial_2.hilosEjercicio4;

public class Ejercicio_4 {

    public static void main(String[] args) {

        int numero = 10;
        int factorial = 6;
        String palabra = "Electroencefalografista";

        t1 t1 = new t1(numero);
        t2 t2 = new t2(factorial);
        t3 t3 = new t3(palabra);

        t1.start();
        t2.start();
        t3.start();

        try {
            //Esperar que terminen los hilos 1,2 y 3
            t1.join();
            t2.join();
            t3.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        int s1 = t1.getResultadoSuma();
        int a = s1;
        int s2 = t2.getResultado();
        int b = s2;
        int s3 = t3.getResultado();
        int c = s3;
        int d;
        d = a*b;

        System.out.println("Valor de d: " +d);
        System.out.println("Cantidad de consonantes: " + c);

    }
}
