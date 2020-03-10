package project1;

import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project1.generator.DataGeneratorModule;
import project1.gui.IntegerGUIController;

import java.net.URISyntaxException;

public final class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        final Injector injector = Guice.createInjector(new DataGeneratorModule());
        final FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("gui.fxml"));
        loader.setController(injector.getInstance(IntegerGUIController.class));
        final Parent root = loader.load();
        stage.setTitle("Project 1 - Winning Algorithm");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) throws URISyntaxException {
        launch(args);
    }
}
