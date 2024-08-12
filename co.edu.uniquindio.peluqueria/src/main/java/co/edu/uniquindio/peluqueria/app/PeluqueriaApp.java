package co.edu.uniquindio.peluqueria.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class PeluqueriaApp extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(PeluqueriaApp.class.getResource("/co.edu.uniquindio.peluqueria/peluqueriaView.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Peluqueria");
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch(PeluqueriaApp.class, args);
    }
}
