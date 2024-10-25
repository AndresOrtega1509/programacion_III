module co.edu.uniquindio.parcial2.parcial2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;


    opens co.edu.uniquindio.parcial2.parcial2 to javafx.fxml;
    exports co.edu.uniquindio.parcial2.parcial2;

    opens co.edu.uniquindio.parcial2.parcial2.punto1;
    exports co.edu.uniquindio.parcial2.parcial2.punto1;
}