package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class profileSearch {
    static void show(BorderPane rt, String search_text) {
        // sub-pane declare korlam

        HBox hb=new HBox();
        VBox vb=new VBox();
        ScrollPane sp = new ScrollPane();
        Pane spacer = new Pane();

        //main buttons
        Button profileButton= new javafx.scene.control.Button("প্রোফাইল");
        Button home= new javafx.scene.control.Button("হোম");
        Button settingsBtn = new javafx.scene.control.Button("সেটিংস");

        // height-width
        hb.setMinHeight(100);
        // hb.minWidthProperty().bind(rt.widthProperty());
        hb.prefHeightProperty().bind(rt.heightProperty().divide(6.0));
        HBox.setHgrow(spacer, Priority.ALWAYS);


        // styles add korlam
        hb.getStylesheets().add("style.css");
        hb.getStyleClass().add("hb");
        vb.getStylesheets().add("style.css");
        vb.getStyleClass().add("vb");
        sp.getStylesheets().add("style.css");
        sp.getStyleClass().add("sp");

        // profile search
        javafx.scene.control.TextField searchBar= new javafx.scene.control.TextField();
        searchBar.setPromptText("Search Profile");

        //background stuffs
        ImageView img=new ImageView("algo-corner.png");
        img.fitHeightProperty().bind(hb.heightProperty());
        img.setPreserveRatio(true);
        hb.getChildren().add(img);
        hb.getChildren().addAll(spacer);
        hb.getChildren().add(searchBar);
        Double proportion=img.getBoundsInParent().getWidth()/img.getBoundsInParent().getHeight();
        vb.prefWidthProperty().bind(hb.heightProperty().multiply ( proportion ));

        // button style
        profileButton.getStyleClass().add("button");
        home.getStyleClass().add("button");
        settingsBtn.getStyleClass().add("button");
        searchBar.getStyleClass().add("text-field");

        //allignment

        HBox.setMargin(searchBar, new Insets( 60,30,10,10));
        settingsBtn.setMinWidth(170);
        profileButton.setPrefWidth(170);
        home.setMinWidth(170);
        settingsBtn.setMinHeight(100);
        profileButton.setMinHeight(100);
        home.setMinHeight(100);
        vb.getChildren().add(profileButton);
        vb.getChildren().add(settingsBtn);
        vb.getChildren().add(home);
        vb.setSpacing(50);
        vb.setAlignment(Pos.BASELINE_CENTER);

        System.out.println("alive");

        // merge
        rt.setTop(hb);
        rt.setLeft(vb);
        rt.setCenter(sp);



        Button addPost = new Button("নতুন পোস্ট");
        addPost.getStyleClass().add(".button");
        vb.getChildren().add(addPost);
        addPost.setMinHeight(100);
        addPost.setMinWidth(170);


        //css
        settingsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("hi");

                settings.show(rt);
            }
        });


        profileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                profile.show(rt);
            }
        });

        home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //  home.show(rt);
            }
        });
        addPost.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                AddPost.show(rt);
            }
        });


        //new added
        Connect cn=new Connect();
        try {
            Connection con = cn.getConnection();
            Statement stmt = con.createStatement();
            String userName = Main.currentUser;

            String q = "select * from users WHERE  username = '" + search_text + "'";
            ResultSet rs= stmt.executeQuery(q);

            if(rs.next())
            {
                Label nameLbl= new Label("User name : "+ rs.getString(2) );
                Label fullNameLbl= new Label("Full name : "+ rs.getString(3) );
                Label mailLbl= new Label("User name : "+ rs.getString(4) );
                Label instituteLbl= new Label("User name : "+ rs.getString(6) );

                nameLbl.getStyleClass().add("lbl");

                fullNameLbl.getStyleClass().add("lbl");
                mailLbl.getStyleClass().add("lbl");
                instituteLbl.getStyleClass().add("lbl");


                VBox labels= new VBox();
                labels.getStyleClass().add("sp");
                labels.setAlignment(Pos.BASELINE_CENTER);

                labels.prefWidthProperty().bind(sp.widthProperty());
                labels.getChildren().addAll(nameLbl,fullNameLbl,mailLbl,instituteLbl);
                sp.setContent(labels);



            }

        }
        catch (SQLException ex) {
            Alert.display("Oops", "error connecting with database");
        }




    }
}
