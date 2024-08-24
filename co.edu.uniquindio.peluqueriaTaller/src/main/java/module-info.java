module co.edu.uniquindio.peluqueriataller.peluqueriaapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires org.mapstruct;


    opens co.edu.uniquindio.peluqueriataller.peluqueriaapp to javafx.fxml;
    exports co.edu.uniquindio.peluqueriataller.peluqueriaapp;

    opens co.edu.uniquindio.peluqueriataller.peluqueriaapp.viewController;
    exports co.edu.uniquindio.peluqueriataller.peluqueriaapp.viewController;

    exports co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.dto;
    exports co.edu.uniquindio.peluqueriataller.peluqueriaapp.mapping.mappers;
}