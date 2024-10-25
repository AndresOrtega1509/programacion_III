package co.edu.uniquindio.parcial2.parcial2.punto2;

public class main {

    public static void main(String[] args) {

        int[][] matriz = {{1,2,3},
                    {4,5,6},
                    {7,8,9},
                    {10,11,12}};

        T1 t1 = new T1(matriz);
        T2 t2 = new T2(matriz);

        t1.start();
        t2.start();

        try {
            //Esperar que terminen los hilos 1 y 2
            t1.join();
            t2.join();

        }catch (InterruptedException e){
            e.printStackTrace();
        }

        int s1 = t1.getNumeroMenor();
        int a = s1;
        double s2 = t2.getPromedio();
        double b = s2;
        double c;


        if (b != 0){
            c = a/b;
            System.out.println("El valor de C es igual a: " + c);
        }else {
            System.out.println("No se puede hacer division por 0");
        }

    }

}
