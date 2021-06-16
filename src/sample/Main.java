package sample;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    BorderPane root = new BorderPane();
    public static String currentUser;
    @Override
    public void start(Stage primaryStage) throws Exception{

        Scene scene = new Scene(root,1400,1000);
        scene.getStylesheets().add("style.css");
        root.minHeightProperty().bind(scene.heightProperty());
        root.minWidthProperty().bind(scene.widthProperty());
        primaryStage.setTitle("Random ");
        primaryStage.setScene(scene);
        primaryStage.show();

        homePage.load(root);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
