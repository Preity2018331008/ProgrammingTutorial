package sample;
//
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class blogList {
    static void show(BorderPane rt) {
        // sub-pane declare korlam

        HBox hb=new HBox();
        VBox vb=new VBox();
        ScrollPane sp = new ScrollPane();
        VBox sh=new VBox(25);
        sp.setContent(sh);
        sh.prefWidthProperty().bind(sp.widthProperty());
        Pane spacer = new Pane();
//ami kichu bolbo? dekhte de :'(

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

        loadAll(rt,sh);
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
                System.out.println("hi");

                AddPost.show(rt);
            }
        });
    }
    public static void loadAll(BorderPane rt,VBox sh){
        Connect cn=new Connect();
        try {

            Connection con=cn.getConnection();
            Statement stmt = con.createStatement();
            String q = "select * from blogs ";
            ResultSet rs= stmt.executeQuery(q);
            try {

                while (rs.next()) {
                    String blogId = rs.getString(1);
                    String blogName = rs.getString(2);
                    String body = rs.getString(3);
                    String author = rs.getString(4);
                    loadSingle(rt,sh,blogId,blogName,body,author);
                }
            } finally {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(blogList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void loadSingle(BorderPane rt,VBox sh,String blogId,String blogName,String body,String author){
        VBox vb=new VBox(15);
        HBox hb1=new HBox();
        HBox hb2=new HBox();
        vb.setCursor(Cursor.HAND);
        Label title= new Label(blogName);
        Label  authroLbl =new Label(author);
        hb1.getChildren().add(title);
        title.getStyleClass().add("blogbody2");
        hb2.getChildren().add(authroLbl);
        hb2.setAlignment(Pos.CENTER_RIGHT);
        vb.getChildren().addAll(hb1,hb2);
        sh.getChildren().add(vb);
        vb.prefWidthProperty().bind(sh.widthProperty());
        vb.setBackground(new Background(new BackgroundFill(Color.rgb(130, 160,200), CornerRadii.EMPTY, Insets.EMPTY)));
        vb.setOnMouseClicked(event ->  {
            blogSingle.show2(rt,blogId,blogName,author);
            //Call a fucntion here to load a single blog with perameter of blogid,blogtitle,blogtext,author
        });
    }
}
