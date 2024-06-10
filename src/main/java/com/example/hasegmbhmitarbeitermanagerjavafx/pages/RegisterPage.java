package com.example.hasegmbhmitarbeitermanagerjavafx.pages;

import com.example.hasegmbhmitarbeitermanagerjavafx.Styles;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class RegisterPage {
    private Button backToLoginButton;

    public Scene registerPageScene(Stage primaryStage) {

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        double screenWidth = bounds.getWidth();


        Text textHeader = new Text();
        textHeader.setText("REGISTRIEREN");
        textHeader.setFont(Font.font("Inter", 60));
        textHeader.setStyle(Styles.headerStyle);

        HBox headerContainer = new HBox();
        headerContainer.setPadding(new Insets(100, 0, 0, 140));
        headerContainer.getChildren().add(textHeader);

        //==========================================================

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


        //==========================================================

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


        //==========================================================
        Label passwordRepeatLabel = new Label("PASSWORT wiederholen");
        passwordRepeatLabel.setStyle(Styles.labelStyle);
        passwordRepeatLabel.setFont(Font.font("Inter", 22));
        passwordRepeatLabel.setPrefWidth(200);
        passwordRepeatLabel.setWrapText(true);

        PasswordField passwordRepeatField = new PasswordField();
        passwordRepeatField.setStyle(Styles.inputFieldStyle);
        passwordRepeatField.setPrefWidth(500);


        HBox passwordRepeatHbox = new HBox();
        passwordRepeatHbox.setPadding(new Insets(100, 0, 0, 140));
        passwordRepeatHbox.getChildren().addAll(passwordRepeatLabel, passwordRepeatField);
        passwordRepeatHbox.setSpacing(30);


        VBox vBox = new VBox();
        vBox.getChildren().addAll(usernameHbox, passwordHbox, passwordRepeatHbox);

        Button registerButton = new Button();
        registerButton.setText("REGISTRIEREN");
        registerButton.setStyle("-fx-background-color: #52321D;" +
                "-fx-text-fill: #ffffff; " +
                "-fx-font-size: 20px; " +
                "-fx-border-radius: 0px; ");
        registerButton.setPrefWidth(screenWidth / 2);
        registerButton.setPrefHeight(100);

        this.backToLoginButton = new Button();
        this.backToLoginButton.setStyle("-fx-background-color: #C3C3C3;" +
                "-fx-text-fill: #ffffff; " +
                "-fx-font-size: 20px; " +
                "-fx-border-radius: 0px;" +
                "-fx-text-fill: #52321D;");

        this.backToLoginButton.setText("ZURÜCK ZU LOGIN");
        this.backToLoginButton.setPrefWidth(screenWidth / 2);
        this.backToLoginButton.setPrefHeight(100);


        HBox footerHbox = new HBox();
        footerHbox.getChildren().addAll(registerButton, this.backToLoginButton);

        // root
        BorderPane root = new BorderPane();
        root.setTop(headerContainer);
        root.setCenter(vBox);
        root.setBottom(footerHbox);
        root.setStyle("-fx-background-color: " + Styles.backgroundColor);


        Scene scene = new Scene(root, 1024, 768);
        return scene;
    }

    public Button getBackToLoginBtn() {
        return this.backToLoginButton;
    }
}
