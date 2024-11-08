package co.edu.uniquindio.restaurante.restaurante;

import co.edu.uniquindio.restaurante.restaurante.controller.ModelFactoryController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static String rol;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("pedido.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Restaurante - Rol: " + rol);
        stage.setScene(scene);
        stage.show();

        ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();
        if ("consumidor".equalsIgnoreCase(rol)) {
            System.out.println("Iniciando consumidor");
            modelFactoryController.consumirMensajesServicio1();  // Solo inicializar el consumidor en esta instancia
        } else {
            System.out.println("Rol no es consumidor, no se inicia el consumidor");
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            rol = args[0];  // El primer argumento define si es productor o consumidor
        } else {
            rol = "consumidor"; // Asignar un valor predeterminado si no se pasa argumento
        }
        System.out.println("Rol asignado: " + rol);  // Verificación de rol asignado
        launch();
    }
}