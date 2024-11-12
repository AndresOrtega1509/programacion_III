module co.edu.uniquindio.preparcial_3.preparcial_3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens co.edu.uniquindio.preparcial_3.preparcial_3 to javafx.fxml;
    exports co.edu.uniquindio.preparcial_3.preparcial_3;
}