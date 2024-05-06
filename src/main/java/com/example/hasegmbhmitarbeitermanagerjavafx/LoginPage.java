package com.example.hasegmbhmitarbeitermanagerjavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginPage extends Application {

    protected String headerStyle = "-fx-text-fill: #bb4548; " +
            "-fx-stroke: #bb4548;" +
            " -fx-stroke-width: 1;" +
            "-fx-margin: 40px;";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        Text textHeader = new Text();
        Insets insets = new Insets(10);
        textHeader.setText("LOGIN");
        textHeader.setFont(Font.font("Inter", 40));
        textHeader.setStyle(this.headerStyle);


        // root
        BorderPane root = new BorderPane();
        root.setTop(textHeader);
/*        root.setPadding(new Insets(10)); // space between elements and window border
        root.setCenter(vbCenter);
        root.setBottom(hbBottomBar);*/

        Scene scene = new Scene(root, 1024, 768);

        primaryStage.setTitle("Hase GmbH");
        primaryStage.setScene(scene);
        primaryStage.show();


       /* // bottom respectively "button area"
        HBox hbBottomBar = new HBox();
        Button loginBtn = new Button();
        loginBtn.setText("LOGIN");
        loginBtn.setMinHeight(100);
        loginBtn.setMinWidth(primaryStage.getWidth()/2);
        loginBtn.setFont(Font.font ("Verdana", 20));
        loginBtn.setStyle("-fx-border-color: #52321D; " +
                "-fx-border-width: 5px; " +
                "-fx-background-color: #52321D; " +
                " -fx-text-fill: white;");
        loginBtn.setAlignment(Pos.BASELINE_RIGHT);


        Button registerBtn = new Button();
        registerBtn.setText("REGISTRIEREN");
        registerBtn.setMinHeight(100);
        registerBtn.setMinWidth(primaryStage.getWidth()/2);
        registerBtn.setFont(Font.font ("Verdana", 20));
        registerBtn.setStyle("-fx-border-color: #52321D; " +
                "-fx-border-width: 5px; " +
                "-fx-background-color: #C3C3C3; " +
                " -fx-text-fill: #52321D;");
        registerBtn.setAlignment(Pos.BASELINE_LEFT);

        hbBottomBar.getChildren().add(registerBtn);
        hbBottomBar.getChildren().add(loginBtn);*/


    }
}