package sample;

import javafx.animation.FadeTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;


public class homePage {
    static  void load(BorderPane root){
        BorderPane hPage= new BorderPane();
        root.setCenter(hPage);
        ImageView img=new ImageView("algosecond.png");
        img.fitHeightProperty().bind(hPage.heightProperty());
        img.fitWidthProperty().bind(hPage.widthProperty());
        hPage.getChildren().add(img);
        hPage.getStylesheets().add("style.css");
        FadeTransition fadeOut = new FadeTransition(Duration.millis(6000),img);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setCycleCount(1);
        fadeOut.play();
        fadeOut.setOnFinished((e) ->{
            hPage.getChildren().remove(img);

            logInRegister.show(root);
        });
        hPage.getStyleClass().add("hPage");
    }
}
