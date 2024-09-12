package co.edu.uniquindio.preParcial;

public class Parqueadero {

    public static String[][] parqueadero = {
            {  "L",     "",   "L",    "D",       "R1",             "L",           ""},
            {  "L",     "",   "L",  "Carro",      "",              "L",           ""},
            {  "",      "",   "",   "Carro",      "",              "",            ""},
            {"carro",   "",   "",   "Carro", "discapacitado",  "discapacitado",   ""},
            {"carro",   "",   "",     "",        "L",              "L",           ""},
            {"carro",   "",  "Carro", "",        "L",              "L",           ""},
            {"carro",   "",  "Carro", "",      "carro",          "carrro",        ""},
            {  "",      "",  "Carro", "",        "",               "",            ""},
            {"carro",   "",  "Carro", "",      "carro",            "",          "carro"},
            {"carro",   "",   "R",    "",      "carro",            "",           "R"},
            {  "",      "",   "R",    "",      "carro",          "carro",        "R"},
            {"entrada", "",   "R",    "",        "",               "",           "R2"},

    };

    public static void main(String[] args) {

        Parqueadero p = new Parqueadero();
        int repeticiones = 1;
        p.resuelve(11, 0, repeticiones);

    }

    private void resuelve(int x, int y, int repeticiones) {

        if (repeticiones > 2) {
            System.out.println("Parqueo exitoso");
        }else {
            paso(x, y);
            parqueadero[x][y] = "entrada";
            imprimirParqueadero(0,0);
            limpiarCamino(0,0);
            resuelve(x, y, repeticiones + 1);
        }

    }

    private boolean paso(int x, int y) {

        // Verificar límites
        if (x < 0 || x >= parqueadero.length || y < 0 || y >= parqueadero[x].length) {
            return false;
        }

        if (parqueadero[x][y].equals("R1")) {
            parqueadero[x][y] = "Carro 1, parqueado en R1";
            return true;
        }

        if (parqueadero[x][y].equals("R2")) {
            parqueadero[x][y] = "Carro 2, parqueado en R2";
            return true;
        }

        // Si ya ha sido visitado o es un obstáculo, no avanzar
        if (parqueadero[x][y].equals("carro") || parqueadero[x][y].equals("R") || parqueadero[x][y].equals("L") ||
                parqueadero[x][y].equals("discapacitado") || parqueadero[x][y].equals("+") ||
                parqueadero[x][y].equals("Carro 2, parqueado en R2") ||
                parqueadero[x][y].equals("Carro 1, parqueado en R1")) {

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

    private void limpiarCamino(int i, int j) {

        if (i <= parqueadero.length - 1) {

            if (j <= parqueadero[i].length - 1) {

                if (parqueadero[i][j].equals("+")) {
                    parqueadero[i][j] = "";

                }

                if (j == parqueadero[i].length - 1) {
                    j = 0;
                    i++;
                    System.out.println();
                } else {
                    j++;
                }
                limpiarCamino(i, j);
            }
        }

    }

    private static void imprimirParqueadero(int i, int j) {
        if (i <= parqueadero.length - 1) {

            if (j <= parqueadero[i].length - 1) {

                System.out.printf("%-25s", parqueadero[i][j] + "  ");

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