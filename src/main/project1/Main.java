package project1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URISyntaxException;

public final class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui.fxml"));
        stage.setTitle("Project 1 - Winning Algorithm");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) throws URISyntaxException {
        launch(args);
    }
}
