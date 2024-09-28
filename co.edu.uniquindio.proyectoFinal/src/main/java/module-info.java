module co.edu.uniquindio.proyectofinal.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mapstruct;
    requires static lombok;


    opens co.edu.uniquindio.proyectofinal.proyectofinal to javafx.fxml;
    exports co.edu.uniquindio.proyectofinal.proyectofinal;

    opens co.edu.uniquindio.proyectofinal.proyectofinal.viewController;
    exports co.edu.uniquindio.proyectofinal.proyectofinal.viewController;

    opens co.edu.uniquindio.proyectofinal.proyectofinal.controller;
    exports co.edu.uniquindio.proyectofinal.proyectofinal.controller;

    exports co.edu.uniquindio.proyectofinal.proyectofinal.mapping.dto;

    exports co.edu.uniquindio.proyectofinal.proyectofinal.mapping.mappers;

    exports co.edu.uniquindio.proyectofinal.proyectofinal.model;
}