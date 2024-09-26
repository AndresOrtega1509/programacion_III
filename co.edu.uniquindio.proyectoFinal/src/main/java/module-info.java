module co.edu.uniquindio.proyectofinal.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.proyectofinal.proyectofinal to javafx.fxml;
    exports co.edu.uniquindio.proyectofinal.proyectofinal;
}