package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class blogSingle {

    static void show(BorderPane rt, String caption, String blg)
    {
        Text blog = new Text();
        blog.setText(blg);
        VBox vbox=new VBox();


        Button profileButton= new Button("প্রোফাইল");
        Button home= new Button("হোম");
        Button settingsBtn = new Button("সেটিংস");
        Label lbl=new Label("HI PREITY");
        BorderPane bp=new BorderPane();
        VBox vb = new VBox();
        HBox hb = new HBox();
        ScrollPane sp = new ScrollPane();
    //    vb.setMinWidth(100);
        hb.setMinHeight(100);
        hb.prefHeightProperty().bind(rt.heightProperty().divide(6.0));

        VBox.setMargin(lbl, new Insets(100,500,100,500));
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
//        sp.setStyle("-fx-background-color: #00ff00");


        Button addPost = new Button("নতুন পোস্ট");
        addPost.getStyleClass().add(".button");
        vb.getChildren().add(addPost);
        addPost.setMinHeight(100);
        addPost.setMinWidth(170);



        lbl.getStylesheets().add("style.css");
        lbl.getStyleClass().add("lbl");
   //     lbl.setFont(new Font("Arial", 24));

        settingsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
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
                blogList.show(rt);
            }
        });


        addPost.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AddPost.show(rt);
            }
        });


        VBox blogs = new VBox();
        Label l1= new Label(caption);
        Label l3= new Label( Main.currentUser );

        blog.getStyleClass().add("blogbody");
        l1.getStyleClass().add("blogcap");
        l3.getStyleClass().add("formLabel");

        blogs.prefWidthProperty().bind(sp.widthProperty());

        blogs.setAlignment(Pos.BASELINE_CENTER);

        blogs.getChildren().addAll(l1, l3, blog);
        sp.setContent(blogs);

    }







    ///////////////////////













    static void show2(BorderPane rt, String caption, String blg, String author)
    {
        Text blog = new Text();
        blog.setText(blg);
        VBox vbox=new VBox();


        Button profileButton= new Button("প্রোফাইল");
        Button home= new Button("হোম");
        Button settingsBtn = new Button("সেটিংস");
        Label lbl=new Label("HI PREITY");
        BorderPane bp=new BorderPane();
        VBox vb = new VBox();
        HBox hb = new HBox();
        ScrollPane sp = new ScrollPane();
        //    vb.setMinWidth(100);
        hb.setMinHeight(100);
        hb.prefHeightProperty().bind(rt.heightProperty().divide(6.0));

        VBox.setMargin(lbl, new Insets(100,500,100,500));
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
//        sp.setStyle("-fx-background-color: #00ff00");


        Button addPost = new Button("নতুন পোস্ট");
        addPost.getStyleClass().add(".button");
        vb.getChildren().add(addPost);
        addPost.setMinHeight(100);
        addPost.setMinWidth(170);



        lbl.getStylesheets().add("style.css");
        lbl.getStyleClass().add("lbl");
        //     lbl.setFont(new Font("Arial", 24));

        settingsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
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
                blogList.show(rt);
            }
        });


        addPost.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AddPost.show(rt);
            }
        });

//
        VBox blogs = new VBox();
        Label l1= new Label(caption);
        Label l3= new Label( author );

        blog.getStyleClass().add("blogbody");
        l1.getStyleClass().add("blogcap");
        l3.getStyleClass().add("formLabel");

        blogs.prefWidthProperty().bind(sp.widthProperty());

        blogs.setAlignment(Pos.BASELINE_CENTER);

        blogs.getChildren().addAll(l1, l3, blog);
        sp.setContent(blogs);

    }

}
