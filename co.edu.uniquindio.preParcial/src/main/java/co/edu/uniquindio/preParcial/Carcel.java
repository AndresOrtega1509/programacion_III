package co.edu.uniquindio.preParcial;

public class Carcel {
    public int cantidadPresos = 0;
    public int presosFugados = 0;
    public static char[][] carcel = {
            {' ', 'P', 'X', ' ', 'P', 'P', ' ', 'P'},
            {' ', 'P', 'P', ' ', 'P', 'P', ' ', 'P'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'P', ' ', 'P', 'P', ' ', 'P', 'P', ' '},
            {'P', ' ', 'X', 'P', ' ', 'P', 'P', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'P', 'X', 'P', ' ', 'P', 'P', ' ', 'P'},
    };


    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args) {
        Carcel c = new Carcel();
        c.carcel[5][7] = 'E';  // Cambié 'c' por 'E' como punto de destino.
        c.resuelve(0, 0);  // Iniciar desde (0, 0)
        System.out.println("La cantidad de presos es " + c.cantidadPresos);
        System.out.println("La cantidad de presos fugados es " + c.presosFugados);
        System.out.println(imprimirCarcel(0, 0));
    }


    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    public void resuelve(int x, int y) {

        paso(x, y);
        carcel[x][y] = 'S';
    }

    private boolean paso(int x, int y) {
        // Verificar límites
        if (x < 0 || x >= carcel.length || y < 0 || y >= carcel[x].length) {
            return false;
        }

        // Si ya ha sido visitado o es un obstáculo, no avanzar
        if (carcel[x][y] == '*' || carcel[x][y] == 'x' || carcel[x][y] == 'E' || carcel[x][y] == 'p') {
            return false;
        }

        // Contar fugitivos y reemplazar por 'x' para evitar contarlos dos veces
        if (carcel[x][y] == 'P') {
            cantidadPresos++;
            carcel[x][y] = 'p';  // Marcamos que ya lo contamos
        }else {
            if (carcel[x][y] == 'X') {
                cantidadPresos++;
                presosFugados++;
                carcel[x][y] = 'x';
            }
        }

        if (carcel[x][y] != 'p' && carcel[x][y] != 'x') {
            carcel[x][y] = '*';
        }

        // Explorar las cuatro direcciones
        boolean result;

        result = paso(x, y + 1);  // Derecha
        if (result) return true;

        result = paso(x + 1, y);  // Abajo
        if (result) return true;

        result = paso(x - 1, y);  // Arriba
        if (result) return true;

        result = paso(x, y - 1);  // Izquierda
        if (result) return true;

        return false;
    }

    private static String imprimirCarcel(int i, int j) {

        String salida = "";

        if (i <= carcel.length - 1) {

            if (j <= carcel[i].length - 1) {

                salida += carcel[i][j] + " ";
                System.out.print(carcel[i][j] + " ");

                if (j == carcel[i].length - 1) {
                    j = 0;
                    i++;
                    System.out.println();
                } else {
                    j++;
                }
                imprimirCarcel(i, j);
            }
        }
        return salida;
    }
}


