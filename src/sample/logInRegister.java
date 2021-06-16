package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class logInRegister {
    static void show(BorderPane layout){
        TabPane tb= new TabPane();
        tb.tabMinWidthProperty().bind(tb.widthProperty().subtract(18).divide(2));
        HBox cardLogIn=new HBox();
        HBox cardReg=new HBox();
        prepareLogIn(cardLogIn,layout);
        prepareReg(cardReg, layout);
        Tab tbLogIn=new Tab("লগ ইন",cardLogIn);
        Tab tbReg=new Tab("রেজিস্ট্রেশন",cardReg);
        tbLogIn.getStyleClass().add("tab");
        tbReg.getStyleClass().add("tab");
        tb.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        tb.getTabs().add(tbLogIn);
        tb.getTabs().add(tbReg);
        layout.setCenter(tb);

    }
    static void prepareLogIn(HBox card, BorderPane borderPane){
        VBox lft=new VBox(20);
        VBox rht=new VBox(20);
        card.getChildren().add(lft);
        card.getChildren().add(rht);
        rht.getStyleClass().add("padd");
        lft.getStyleClass().add("padd");
        lft.prefWidthProperty().bind(card.widthProperty().divide(2));
        lft.prefHeightProperty().bind(card.heightProperty());
        rht.prefWidthProperty().bind(card.widthProperty().divide(2));
        rht.prefHeightProperty().bind(card.heightProperty());
        rht.getStyleClass().add("loginRht");
        lft.getStyleClass().add("loginLft");
        Label logInLbl=new Label("ই মেইল");
        Label psdLbl= new Label("পাসওয়ার্ড");
        logInLbl.getStyleClass().add("formLabel");
        psdLbl.getStyleClass().add("formLabel");
        TextField logInField = new TextField();
        TextField psdField = new TextField();
        prepareField(rht,logInField,logInLbl);
        prepareField(rht,psdField,psdLbl);
        Button logInBtn=new Button("লগ ইন");
        logInBtn.getStyleClass().add("btn");
        rht.getChildren().add(logInBtn);
        logInBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(logInField.getText().length()<1)
                {
                    Alert.display("warning","UserName can't be empty");
                    return ;
                }
                if(psdField.getText().length()<3){
                    Alert.display("warning", "Pasword must be at least 3 length");
                    return ;
                }
                Connect cn=new Connect();
                try {
                    String mail=logInField.getText();
                    String Password=psdField.getText();
                    Connection con=cn.getConnection();
                    Statement stmt = con.createStatement();
                    String q = "select * from users WHERE email = '" + mail +
                            "' AND password = '" + Password + "'";
                    ResultSet rs= stmt.executeQuery(q);
                    if(rs.next()){
                        Main.currentUser= rs.getString(2);
                        blogList.show(borderPane);
                    }
                    else{
                        Alert.display("dhuru ", "user not found");
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                    Alert.display("warning", "Error connection database");
                }
            }

        });

    }
    static void prepareReg(HBox card, BorderPane borderPane){
        VBox lft=new VBox();
        VBox rht=new VBox();
        rht.getStyleClass().add("padd");
        lft.getStyleClass().add("padd");
        card.getChildren().add(rht);
        card.getChildren().add(lft);
        lft.prefWidthProperty().bind(card.widthProperty().divide(2));
        lft.prefHeightProperty().bind(card.heightProperty());
        rht.prefWidthProperty().bind(card.widthProperty().divide(2));
        rht.prefHeightProperty().bind(card.heightProperty());
        rht.getStyleClass().add("loginRht");
        lft.getStyleClass().add("loginLft");
        Label userNameLbl=new Label("ব্যবহারকারীর নাম");
        Label fullNameLbl = new Label("Full name");
        Label instituteLbl=new Label("Institute");
        Label psdLbl= new Label("পাসওয়ার্ড");
        Label emailLbl = new Label("ই মেইল");
        Label confirmPsdLbl = new Label("কনফার্ম পাসওয়ার্ড");

        userNameLbl.getStyleClass().add("formLabel");
        psdLbl.getStyleClass().add("formLabel");
        confirmPsdLbl.getStyleClass().add("formLabel");
        emailLbl.getStyleClass().add("formLabel");
        fullNameLbl.getStyleClass().add("formLabel");
        instituteLbl.getStyleClass().add("formLabel");
        TextField userNameField = new TextField();
        TextField fullNameField = new TextField();
        TextField emailField = new TextField();
        TextField instituteField = new TextField();
        PasswordField psdField = new PasswordField();
        PasswordField confirmPsdField = new PasswordField();
        prepareField(rht,userNameField,userNameLbl);
        prepareField(rht,fullNameField,fullNameLbl);
        prepareField(rht,emailField,emailLbl);
        prepareField(rht,instituteField,instituteLbl);
        prepareField(rht,psdField,psdLbl);
        prepareField(rht,confirmPsdField,confirmPsdLbl);
        Button regBtn=new Button("সাইন আপ");
        rht.getChildren().add(regBtn);
        VBox.setMargin(regBtn, new Insets(40, 0, 0, 0));
        regBtn.getStyleClass().add("btn");
        regBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Connect cn=new Connect();
                try {
                    Connection con=cn.getConnection();
                    Statement stmt = con.createStatement();
                    String userName=userNameField.getText();
                    String fullName = fullNameField.getText();
                    String email=emailField.getText();
                    String password=psdField.getText();
                    String confirmPassword=confirmPsdField.getText();
                    String institute=instituteField.getText();

                    System.out.println(institute);
                    if(userName.length()<1){
                        Alert.display("Warning", "User name can't be empty");
                        return ;
                    }

                    if(fullName.length()<1){
                        Alert.display("Warning", "Full name can't be empty");
                        return ;
                    }

                    if(email.length()<1){
                        Alert.display("Warning", "Email can't be empty");
                        return ;
                    }

                    if(password.length()<3){
                        Alert.display("Warning", "Password must be atleast 3 length");
                        return ;
                    }
                    if(!password.equals(confirmPassword)){
                        Alert.display("Warning", "Email can't be empty");
                        return ;
                    }
                    if(institute.length()<1){
                        Alert.display("Warning", "institute can't be empty");
                        return ;
                    }
                    String q = "select * from users WHERE  username = '" + userName + "'";
                    ResultSet rs= stmt.executeQuery(q);
                    if(rs.next()){
                        Alert.display("Sorry", "User Name already taken");
                        return ;
                    }
                    q = "select * from users WHERE  email = '" + email + "'";
                    rs= stmt.executeQuery(q);
                    if(rs.next()){
                        Alert.display("Sorry", "Email already used");
                        return ;
                    }
                    int rnd=(int) (Math.random()*1000000);
                    String code=Integer.toString(rnd+168473); // string. diye to
                    SendEmail.send(email,code);


                    Label verificationLbl=new Label("Enter verification code sent to your mail");
                    TextField verificationField= new TextField();
                    Button verificationBtn = new Button("verify");
                    verificationBtn.getStyleClass().add("btn");
                    verificationLbl.getStyleClass().add("formLabel");

                    rht.getChildren().setAll(verificationLbl,verificationField,verificationBtn);
                    verificationBtn.setOnAction(new EventHandler<ActionEvent> (){
                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("input code "+-567981);
                            if(verificationField.getText().toString().equals(code)){
                                try {
                                    String q="INSERT INTO users (username, fullname, email, password,institute) VALUES ('"+userName+"', '"+fullName+"', '"+ email+"', '"+password+"', '"+institute+"')";
                                    stmt.executeUpdate(q);
                                    blogList.show(borderPane);
                                } catch (SQLException ex) {
                                    Logger.getLogger(logInRegister.class.getName()).log(Level.SEVERE, null, ex);
                                    Alert.display("Oops", "connection error");
                                    show(borderPane);
                                }

                            }
                            else{
                                show(borderPane);
                                Alert.display("Oops", "Code didn't match");
                            }
                        }
                    });
                } catch (SQLException ex) {
                    Alert.display("Oops", "error connecting with database");
                }
            }
        });

    }
    static void prepareField(VBox root,TextField fld,Label lbl){
        FlowPane container=new FlowPane();
        FlowPane lblContainer=new FlowPane();
        lblContainer.minWidthProperty().bind(container.widthProperty().divide(2));
        fld.setMinWidth(280);
        lblContainer.getChildren().add(lbl);
        container.getChildren().add(lblContainer);
        container.getChildren().add(fld);
        root.getChildren().add(container);
    }
    static void prepareField(VBox root,PasswordField fld,Label lbl){
        FlowPane container=new FlowPane();
        FlowPane lblContainer=new FlowPane();
        lblContainer.minWidthProperty().bind(container.widthProperty().divide(2));
        fld.setMinWidth(280);
        lblContainer.getChildren().add(lbl);
        container.getChildren().add(lblContainer);
        container.getChildren().add(fld);
        root.getChildren().add(container);
    }
}