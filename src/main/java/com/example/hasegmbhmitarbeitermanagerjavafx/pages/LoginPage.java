package com.example.hasegmbhmitarbeitermanagerjavafx.pages;

import com.example.hasegmbhmitarbeitermanagerjavafx.Styles;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class LoginPage {

    private Button registerButton;
    private Button loginButton;

    public Scene loginPageScene(Stage primaryStage) {

        Screen screen = Screen.getPrimary();
        // Get the visual bounds of the primary screen
        Rectangle2D bounds = screen.getVisualBounds();
        // Get the width of the screen
        double screenWidth = bounds.getWidth();


        Text textHeader = new Text();
        textHeader.setText("LOGIN");
        textHeader.setFont(Font.font("Inter", 60));
        textHeader.setStyle(Styles.headerStyle);

        HBox headerContainer = new HBox();
        headerContainer.setPadding(new Insets(100, 0, 0, 140));
        headerContainer.getChildren().add(textHeader);

        Label usernameLabel = new Label("BENUTZERNAME");
        usernameLabel.setStyle(Styles.labelStyle);
        usernameLabel.setFont(Font.font("Inter", 22));
        usernameLabel.setPrefWidth(200);

        TextField textField = new TextField();
        textField.setStyle(Styles.inputFieldStyle);
        textField.setPrefWidth(500);


        HBox usernameHbox = new HBox();
        usernameHbox.setPadding(new Insets(100, 0, 0, 140));
        usernameHbox.getChildren().addAll(usernameLabel, textField);
        usernameHbox.setSpacing(30);


        Label passwordLabel = new Label("PASSWORT");
        passwordLabel.setStyle(Styles.labelStyle);
        passwordLabel.setFont(Font.font("Inter", 22));
        passwordLabel.setPrefWidth(200);

        PasswordField passwordField = new PasswordField();
        passwordField.setStyle(Styles.inputFieldStyle);
        passwordField.setPrefWidth(500);

        HBox passwordHbox = new HBox();
        passwordHbox.setPadding(new Insets(100, 0, 0, 140));
        passwordHbox.getChildren().addAll(passwordLabel, passwordField);
        passwordHbox.setSpacing(30);


        Hyperlink passwordForgetLink = new Hyperlink("PASSWORT vergessen?");
        passwordForgetLink.setFont(Font.font("Inter", 22));
        passwordForgetLink.setStyle(Styles.labelStyle);
        passwordForgetLink.setPadding(new Insets(100, 0, 0, 620));

        VBox vBox = new VBox();
        vBox.getChildren().addAll(usernameHbox, passwordHbox,passwordForgetLink);

        this.registerButton = new Button();
        this.registerButton.setText("REGISTRIEREN");
        this.registerButton.setStyle("-fx-background-color: #C3C3C3; " +
                "-fx-text-fill: #ffffff; " +
                "-fx-font-size: 20px; " +
                "-fx-border-radius: 0px; ");
        this.registerButton.setPrefWidth(screenWidth / 2);
        this.registerButton.setPrefHeight(100);

        this.loginButton = new Button();
        this.loginButton.setStyle("-fx-background-color: #52321D;" +
                "-fx-text-fill: #ffffff; " +
                "-fx-font-size: 20px; " +
                "-fx-border-radius: 0px; ");

        this.loginButton.setText("LOGIN");
        this.loginButton.setPrefWidth(screenWidth / 2);
        this.loginButton.setPrefHeight(100);


        HBox footerHbox = new HBox();
        footerHbox.getChildren().addAll(registerButton, loginButton);

        // root
        BorderPane root = new BorderPane();
        root.setTop(headerContainer);
        root.setCenter(vBox);
        root.setBottom(footerHbox);
        root.setStyle("-fx-background-color: " + Styles.backgroundColor);

        Scene scene = new Scene(root, 1024, 768);

        return scene;
    }

    public Button getRegisterButton() {
        return this.registerButton;
    }
    public Button getLoginButton() {
        return this.loginButton;
    }
}
