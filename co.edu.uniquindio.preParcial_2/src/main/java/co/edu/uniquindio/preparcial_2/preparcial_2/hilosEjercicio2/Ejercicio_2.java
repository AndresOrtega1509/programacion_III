package co.edu.uniquindio.preparcial_2.preparcial_2.hilosEjercicio2;

public class Ejercicio_2 {

    public static void main(String[] args) {
        int n = 10;
        String palabra = "otorrinolaringologia";

        //Crear las instancias de los hilos
        T1 t1 = new T1(n);
        T2 t2 = new T2(palabra);

        //Iniciar los hilos
        t1.start();
        t2.start();

        try {
            // Esperar a que terminen los hilos t1 y t2
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        int s2 = t1.getResultadoSuma();
        int s3 = t2.getCantidadVocales();

        int s4 = s2 * s3;

        System.out.println(s4);

    }
}
