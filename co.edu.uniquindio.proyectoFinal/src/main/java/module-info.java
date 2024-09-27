module co.edu.uniquindio.proyectofinal.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mapstruct;


    opens co.edu.uniquindio.proyectofinal.proyectofinal to javafx.fxml;
    exports co.edu.uniquindio.proyectofinal.proyectofinal;

    opens co.edu.uniquindio.proyectofinal.proyectofinal.viewController;
    exports co.edu.uniquindio.proyectofinal.proyectofinal.viewController;

    exports co.edu.uniquindio.proyectofinal.proyectofinal.mapping.dto;

    exports co.edu.uniquindio.proyectofinal.proyectofinal.model;

    exports co.edu.uniquindio.proyectofinal.proyectofinal.mapping.mappers;
}