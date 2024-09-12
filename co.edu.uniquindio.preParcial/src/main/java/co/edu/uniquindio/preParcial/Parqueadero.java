package co.edu.uniquindio.preParcial;

public class Parqueadero {

    public static String[][] parqueadero = {
            {  "L",     " ",   "L",    "D",        "R1",             "L",          " "},
            {  "L",     " ",   "L",  "Carro",      " ",              "L",          " "},
            {  " ",     " ",   " ",  "Carro",      " ",              " ",          " "},
            {"carro",   " ",   " ",  "Carro", "discapacitado",  "discapacitado",   " "},
            {"carro",   " ",   " ",    " ",        "L",              "L",          " "},
            {"carro",   " ",  "Carro", " ",        "L",              "L",          " "},
            {"carro",   " ",  "Carro", " ",      "carro",          "carrro",       " "},
            {  " ",     " ",  "Carro", " ",        " ",              " ",          " "},
            {"carro",   " ",  "Carro", " ",      "carro",            " ",         "carro"},
            {"carro",   " ",   "R",    " ",      "carro",            " ",          "R"},
            {  " ",     " ",   "R",    " ",      "carro",          "carro",        "R"},
            {"entrada", " ",   "R",    " ",        " ",              " ",          "R2"},
    };

    public static void main(String[] args) {

        Parqueadero p = new Parqueadero();
        p.resuelve(11, 0); // Iniciar desde (0, 0)
        imprimirParqueadero(0, 0);

    }

    private void resuelve(int x, int y) {

        paso(x, y);
        parqueadero[x][y] = "entrada";
    }

    private boolean paso(int x, int y) {

        // Verificar límites
        if (x < 0 || x >= parqueadero.length || y < 0 || y >= parqueadero[x].length) {
            return false;
        }

        if (parqueadero[x][y].equals("R1")) {
            return true;
        }

        // Si ya ha sido visitado o es un obstáculo, no avanzar
        if (parqueadero[x][y].equals("carro") || parqueadero[x][y].equals("R") || parqueadero[x][y].equals("L") ||
                parqueadero[x][y].equals("discapacitado") || parqueadero[x][y].equals("+")) {
            return false;
        }

        parqueadero[x][y] = "+";

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

    private static void imprimirParqueadero(int i, int j) {
        if (i <= parqueadero.length - 1) {

            if (j <= parqueadero[i].length - 1) {

                System.out.print(parqueadero[i][j] + "  ");

                if (j == parqueadero[i].length - 1) {
                    j = 0;
                    i++;
                    System.out.println();
                } else {
                    j++;
                }
                imprimirParqueadero(i, j);
            }
        }
    }
}
