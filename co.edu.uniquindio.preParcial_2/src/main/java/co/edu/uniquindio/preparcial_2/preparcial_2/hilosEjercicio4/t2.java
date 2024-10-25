package co.edu.uniquindio.preparcial_2.preparcial_2.hilosEjercicio4;

public class t2 extends Thread{

    private int factorial;
    private int resultado;

    public t2(int factorial) {

        this.factorial = factorial;
    }

    @Override
    public void run() {
        resultado = calcularFactorial(factorial);
    }

    private int calcularFactorial(int factorial) {
        if (factorial == 1){
            return 1;
        }else {
            return factorial *calcularFactorial(factorial-1);
        }
    }

    public int getResultado() {
        return resultado;
    }
}
