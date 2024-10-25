package co.edu.uniquindio.preparcial_2.preparcial_2.hilosEjercicio4;

public class t1 extends Thread{

    private int n;
    private int resultadoSuma;

    public t1(int n) {
        this.n = n;
    }

    @Override
    public void run() {

        resultadoSuma = sumaRecursiva(n);

    }

    public int sumaRecursiva(int n) {

        if (n == 0){
            return 0;
        }else {
            return sumaRecursiva(n-1)+ n;
        }
    }

    public int getResultadoSuma() {
        return resultadoSuma;
    }
}
