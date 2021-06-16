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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class settings {
    static void show(BorderPane rt) {



        VBox vbox=new VBox();
        VBox vbox2 = new VBox();
        HBox hbox = new HBox();

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
        searchBar.setPromptText("Search Profile");
        hb.getStylesheets().add("style.css");
        hb.getStyleClass().add("hb");
        bp.setLeft(vb);
        bp.setTop(hb);
        bp.setCenter(sp);
        //    rt.getChildren().add(bp);
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
        vb.prefHeightProperty().bind(rt.heightProperty());

        profileButton.getStyleClass().add("button");
        home.getStyleClass().add("button");
        settingsBtn.getStyleClass().add("button");

        HBox.setMargin(searchBar, new Insets( 60,30,10,10));

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

        Button submit= new Button("Submit");
        submit.getStylesheets().add("style.css");
        submit.getStyleClass().add(".button");

        rt.setTop(hb);

        rt.setLeft(vb);
        rt.setCenter(sp);

        TextField changeName = new TextField();
        TextField changePass = new TextField();
        TextField confirmChangePass = new TextField();
        TextField confirmPass= new TextField();
        TextField Institute = new TextField();
        TextField changeEmail = new TextField();

        Label changeNamelbl = new Label("ব্যবহারকারীর নাম");
        Label changePasslbl = new Label("নতুন পাসওয়ার্ড");
        Label confirmChangePasslbl = new Label("পাসওয়ার্ড নিশ্চিত করুন");
        Label confirmPasslbl = new Label("পুরানো পাসওয়ার্ড");
        Label Institutelbl = new Label("প্রতিষ্ঠান");
        Label changeEmaillbl = new Label("ই মেল");

        changeNamelbl.getStylesheets().add("style.css");
        changeNamelbl.getStyleClass().add("lbl");

        changePasslbl.getStylesheets().add("style.css");
        changePasslbl.getStyleClass().add("lbl");

        confirmChangePasslbl.getStylesheets().add("style.css");
        confirmChangePasslbl.getStyleClass().add("lbl");

        confirmPasslbl.getStylesheets().add("style.css");
        confirmPasslbl.getStyleClass().add("lbl");

        Institutelbl.getStylesheets().add("style.css");
        Institutelbl.getStyleClass().add("lbl");

        changeEmaillbl.getStylesheets().add("style.css");
        changeEmaillbl.getStyleClass().add("lbl");

        changeName.prefWidthProperty().bind(searchBar.heightProperty().multiply(10));
        changePass.prefWidthProperty().bind(changeName.widthProperty());
        confirmChangePass.prefWidthProperty().bind(changeName.widthProperty());
        confirmPass.prefWidthProperty().bind(changeName.widthProperty());
        Institute.prefWidthProperty().bind(changeName.widthProperty());
        changeEmail.prefWidthProperty().bind(changeName.widthProperty());

        VBox.setMargin(changeName, new Insets(40,10,0,100));
        VBox.setMargin(changePass, new Insets(40,10,0,100));
        VBox.setMargin(confirmChangePass, new Insets(40,10,0,100));
        VBox.setMargin(confirmPass, new Insets(40,10,0,100));
        VBox.setMargin(Institute, new Insets(40,10,0,100));
        VBox.setMargin(changeEmail, new Insets(40,10,0,100));





        VBox.setMargin(changeNamelbl, new Insets(50,0,0,130));
        VBox.setMargin(changePasslbl, new Insets(50,0,0,130));
        VBox.setMargin(confirmChangePasslbl, new Insets(50,0,0,130));
        VBox.setMargin(confirmPasslbl, new Insets(50,0,0,130));
        VBox.setMargin(Institutelbl, new Insets(50,0,0,130));
        VBox.setMargin(changeEmaillbl, new Insets(50,0,20,130));


        hbox.getChildren().addAll(vbox2, vbox);

        vbox2.getChildren().addAll(changeNamelbl, changePasslbl, confirmChangePasslbl, confirmPasslbl, Institutelbl);
        vbox.getChildren().addAll(changeName, changePass, confirmChangePass, confirmPass, Institute);
        sp.setContent(hbox);
        submit.setPrefWidth(170);
        submit.setPrefHeight(100);
        BorderPane.setMargin(submit, new Insets(20,10,100,700));
        rt.getStyleClass().add("rt");


        Button addPost = new Button("নতুন পোস্ট");
        addPost.getStyleClass().add(".button");
        vb.getChildren().add(addPost);
        addPost.setMinHeight(100);
        addPost.setMinWidth(170);



        String cur=Main.currentUser;
        vbox.getChildren().add(submit);
        VBox.setMargin(submit, new Insets(100, 0 , 0, 0));

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String q;
                Connect cn=new Connect();
                try {
                    Connection con = cn.getConnection();
                    Statement stmt = con.createStatement();
                    String ck= confirmPass.getText();

                    q= "SELECT * FROM users WHERE username = '"+cur+"' ";
                    ResultSet rs= stmt.executeQuery(q);
                    if(rs.next()){
                        q=rs.getString(5);
                        System.out.println(q + " " + ck);
                        if(q.equals(ck)) {
                            String fullname=changeName.getText();
                            String cngpass= changePass.getText();
                            String concngpass= confirmChangePass.getText();
                            String institute = Institute.getText();
                            if(fullname.equals( rs.getString(3) )) ;
                            else if((fullname.length()<1));
                            else {
                                String qq= "UPDATE users SET fullname= '"+fullname+"' WHERE username = '"+cur+"'";
                                System.out.println(qq);
                                stmt.executeQuery(qq);
                            }

                            if(institute.equals( rs.getString(6) ));
                            else if( institute.length()<1);
                            else {
                                q= "UPDATE users SET institute= '"+institute+"' WHERE username = '"+cur+"'";
                                System.out.println(q);
                                stmt.executeQuery(q);
                            }

                            if(cngpass.equals(concngpass) )
                            {
                                if(cngpass.length()>0)
                                q= "UPDATE users SET password= `"+cngpass+"` WHERE username = `"+cur+"`";
                                System.out.println(q);
                                stmt.executeQuery(q);
                            }
                            else ;


                        }
                    }
                    else{
                        Alert.display("NOOOO ", "password didn.t match");
                    }
                }
                catch(Exception e) {
                    System.out.println("Database unavailable");
                }

  //EIKHANE CHILAM FLAG?
                blogList.show(rt);
            }
        });


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
                blogList.show(rt);
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
}
