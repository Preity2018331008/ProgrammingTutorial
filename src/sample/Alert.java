package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Alert {
    public static void display(String title,String txt)
    {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Label label = new Label();
        label.setText(txt);

        Button btn = new Button("Okay");
        btn.setOnAction(e->window.close());

        VBox layout2 = new VBox(10);
        layout2.getChildren().addAll(label,btn);

        Scene scene = new Scene(layout2, 350, 100);
        window.setScene(scene);
        window.showAndWait();
        //window.show();
    }
}