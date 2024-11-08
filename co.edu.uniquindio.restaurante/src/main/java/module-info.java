module co.edu.uniquindio.restaurante.restaurante {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.rabbitmq.client;
    requires java.desktop;


    opens co.edu.uniquindio.restaurante.restaurante to javafx.fxml;
    exports co.edu.uniquindio.restaurante.restaurante;

    exports co.edu.uniquindio.restaurante.restaurante.config;
    opens co.edu.uniquindio.restaurante.restaurante.config;

    exports co.edu.uniquindio.restaurante.restaurante.controller;
    opens co.edu.uniquindio.restaurante.restaurante.controller;

    exports co.edu.uniquindio.restaurante.restaurante.util;
    opens co.edu.uniquindio.restaurante.restaurante.util;



}