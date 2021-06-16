package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddPost {
    static void show(BorderPane rt)
    {


        Button profileButton= new Button("প্রোফাইল");
        Button home= new Button("হোম");
        Button settingsBtn = new Button("সেটিংস");
        BorderPane bp=new BorderPane();
        VBox vb = new VBox();
        HBox hb = new HBox();
        ScrollPane sp = new ScrollPane();
        hb.setMinHeight(100);
        hb.prefHeightProperty().bind(rt.heightProperty().divide(6.0));
        vb.getStylesheets().add("style.css");
        vb.getStyleClass().add("vb");

        TextField searchBar= new TextField();
        searchBar.setPromptText("  Search Profile");
        hb.getStylesheets().add("style.css");
        hb.getStyleClass().add("hb");
        bp.setLeft(vb);
        bp.setTop(hb);
        bp.setCenter(sp);
        rt.getChildren().add(bp);
        bp.minHeightProperty().bind(rt.heightProperty());
        bp.minWidthProperty().bind(rt.widthProperty());
        sp.getStylesheets().add("style.css");
        sp.getStyleClass().add("sp");

        Pane spacer = new Pane();

        HBox.setHgrow(spacer, Priority.ALWAYS);

        ImageView img=new ImageView("algo-corner.png");
        img.fitHeightProperty().bind(hb.heightProperty());
        img.setPreserveRatio(true);
        hb.getChildren().add(img);
        hb.getChildren().addAll(spacer);
        hb.getChildren().add(searchBar);
        Double proportion=img.getBoundsInParent().getWidth()/img.getBoundsInParent().getHeight();
        vb.prefWidthProperty().bind(hb.heightProperty().multiply ( proportion ));

        profileButton.getStylesheets().add("style.css");
        profileButton.getStyleClass().add("button");

        home.getStylesheets().add("style.css");
        home.getStyleClass().add("button");

        settingsBtn.getStylesheets().add("style.css");
        settingsBtn.getStyleClass().add("button");

        HBox.setMargin(searchBar, new Insets( 60,30,10,10));

        searchBar.getStylesheets().add("style.css");
        searchBar.getStyleClass().add("text-field");
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


        rt.setTop(hb);
        rt.setLeft(vb);
        rt.setCenter(sp);

        TextArea blogPost= new TextArea();
        TextField title = new TextField();
        title.setPromptText("  Topic name goes here");
        blogPost.getStylesheets().add("style.css");
        blogPost.getStyleClass().add("text-area");
        blogPost.prefHeightProperty().bind(sp.heightProperty().divide(.9));

        blogPost.setPromptText(" Body goes here");
        blogPost.prefWidthProperty().bind(sp.widthProperty().divide(1.5));
        title.prefWidthProperty().bind(sp.widthProperty().divide(1.5));


        VBox tmp = new VBox();
        tmp.getChildren().addAll(title,blogPost);

        VBox.setMargin(blogPost, new Insets(100,0,100,200));
        VBox.setMargin(title, new Insets(100,0,0,200));
      //  tmp.setAlignment(Pos.BASELINE_CENTER);
        Button addPost = new Button("নতুন পোস্ট");
        addPost.getStyleClass().add(".button");
        vb.getChildren().add(addPost);
        addPost.setMinHeight(100);
        addPost.setMinWidth(170);


        Button submit = new Button("submit");
        VBox.setMargin(submit, new Insets(0,0,100,500));
        addPost.getStyleClass().add(".button");
        tmp.getChildren().add(submit);
        addPost.setMinHeight(100);
        addPost.setMinWidth(170);

        sp.setContent(tmp);

        title.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("hello bae");
            }
        });

        addPost.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AddPost.show(rt);
            }
        });


        settingsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                settings.show(rt);
            }
        });

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String caption = title.getText();
                String body= blogPost.getText();
                String user= Main.currentUser;

                if(caption.length()<1 || body.length() < 1) {
                    Alert.display("NO!", "Empty Bloog");
                }
                else {
                    Connect cn = new Connect();
                    try {
                        Connection con = cn.getConnection();
                        Statement stmt = con.createStatement();
                        String q = "INSERT INTO blogs (blogtitle, text, author) VALUES ('"+caption+"', '"+body+"', '"+ user+"')";
                        stmt.executeUpdate(q);
                        blogSingle.show(rt, caption, body);
                    } catch (SQLException ex) {
                        Alert.display("Oops", "error connecting with database");
                    }
                }

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
                blogList.show(rt);
            }
        });

    }
}
