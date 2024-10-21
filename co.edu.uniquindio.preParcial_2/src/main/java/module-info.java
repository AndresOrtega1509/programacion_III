module co.edu.uniquindio.preparcial_2.preparcial_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;


    opens co.edu.uniquindio.preparcial_2.preparcial_2 to javafx.fxml;
    exports co.edu.uniquindio.preparcial_2.preparcial_2;

    opens co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_1;
    exports co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio_1;

    opens co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4;
    exports co.edu.uniquindio.preparcial_2.preparcial_2.ejercicio4;
}