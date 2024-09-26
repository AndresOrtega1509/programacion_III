package co.edu.uniquindio.parcial_1;

public class LaberintoRobot {

    public char[][] laberinto = {
            {' ', ' ', 'T', 'P', ' ', ' ', ' ', 'T'},
            {'T', ' ', ' ', ' ', ' ', 'P', ' ', 'T'},
            {' ', ' ', 'T', 'P', ' ', ' ', ' ', 'T'},
            {' ', ' ', ' ', 'P', ' ', 'P', ' ', ' '},
            {' ', 'T', ' ', ' ', ' ', 'T', 'T', ' '},
            {' ', ' ', 'P', 'T', ' ', ' ', ' ', ' '},
            {'T', ' ', 'P', ' ', ' ', 'P', 'T', ' '},
            {' ', ' ', ' ', 'P', ' ', ' ', ' ', ' '},
            {' ', 'T', ' ', ' ', ' ', 'P', ' ', 'S'},
    };

    public int salidasEncontradas = 0;
    public int trampasEncontradas = 0;

    public static void main(String[] args) {
        LaberintoRobot l = new LaberintoRobot();
        l.laberinto[0][0] = 'E'; // Establecer el punto de entrada
        l.resuelve(0, 0);
        System.out.println("Total de soluciones encontradas: " + l.salidasEncontradas);
    }

    private void resuelve(int x, int y) {
        // Iniciar la búsqueda
        paso(x, y);
    }

    private boolean paso(int x, int y) {

        // Verificar límites
        if (x < 0 || x >= laberinto.length || y < 0 || y >= laberinto[x].length) {
            return false;
        }

        if (laberinto[x][y] == 'T') {
            trampasEncontradas++;
        }

        // Si es la salida
        if (laberinto[x][y] == 'S') {
            salidasEncontradas++;
            imprimirLaberinto(0, 0);
            System.out.println("Cantidad de trampas encontradas durante el camino: " + trampasEncontradas);
            trampasEncontradas = 0;
            System.out.println("------------");
            return true;
        }

        // Si ya ha sido visitado o es un obstáculo, no avanzar
        if (laberinto[x][y] == '+' || laberinto[x][y] == 'T' || laberinto[x][y] == 'P') {
            return false;
        }

        // Marcar como parte del camino actual
        char temp = laberinto[x][y];
        laberinto[x][y] = '+';

        // Explorar las cuatro direcciones
        boolean encontrado = false;

        // Derecha
        if (paso(x, y + 1)) {
            encontrado = true;
        }

        // Abajo
        if (paso(x + 1, y)) {
            encontrado = true;
        }

        // Izquierda
        if (paso(x, y - 1)) {
            encontrado = true;
        }

        // Arriba
        if (paso(x - 1, y)) {
            encontrado = true;
        }

        // Backtracking: desmarcar la posición al retroceder
        laberinto[x][y] = temp;

        return encontrado;
    }

    private void imprimirLaberinto(int i, int j) {
        if (i <= laberinto.length - 1) {

            if (j <= laberinto[i].length - 1) {

                System.out.printf(laberinto[i][j] + " ");

                if (j == laberinto[i].length - 1) {
                    j = 0;
                    i++;
                    System.out.println();
                } else {
                    j++;
                }
                imprimirLaberinto(i, j);
            }
        }
    }
}

