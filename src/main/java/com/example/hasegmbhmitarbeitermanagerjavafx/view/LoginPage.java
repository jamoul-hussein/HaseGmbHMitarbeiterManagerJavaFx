package com.example.hasegmbhmitarbeitermanagerjavafx.view;

import com.example.hasegmbhmitarbeitermanagerjavafx.controller.ControllerManager;
import com.example.hasegmbhmitarbeitermanagerjavafx.controller.LoginController;
import com.example.hasegmbhmitarbeitermanagerjavafx.controller.PageManager;
import com.example.hasegmbhmitarbeitermanagerjavafx.view.Error.ErrorPage;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
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

public class LoginPage implements Page {

    private Button registerButton;
    private Button loginButton;

    private TextField usernameField;
    private TextField passwordField;
    private Hyperlink passwordForgetLink;

    private Scene scene;
    private Stage stage;

    @Override
    public void initializeScene(Stage stage) {

        this.stage = stage;

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

        usernameField = new TextField();
        usernameField.setStyle(Styles.inputFieldStyle);
        usernameField.setPrefWidth(500);


        HBox usernameHbox = new HBox();
        usernameHbox.setPadding(new Insets(100, 0, 0, 140));
        usernameHbox.getChildren().addAll(usernameLabel, usernameField);
        usernameHbox.setSpacing(30);


        Label passwordLabel = new Label("PASSWORT");
        passwordLabel.setStyle(Styles.labelStyle);
        passwordLabel.setFont(Font.font("Inter", 22));
        passwordLabel.setPrefWidth(200);

        passwordField = new PasswordField();
        passwordField.setStyle(Styles.inputFieldStyle);
        passwordField.setPrefWidth(500);

        HBox passwordHbox = new HBox();
        passwordHbox.setPadding(new Insets(100, 0, 0, 140));
        passwordHbox.getChildren().addAll(passwordLabel, passwordField);
        passwordHbox.setSpacing(30);


        passwordForgetLink = new Hyperlink("PASSWORT vergessen?");
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

        this.scene = new Scene(root, 1024, 768);
    }

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public void registerButtons() {
        PageManager controller = PageManager.getInstance();
        registerButton.setOnAction(e -> stage.setScene(controller.findPage("registerPage").getScene()));
        
        loginButton.setOnAction(e -> 
            {
                boolean isAuthenticated = authenticate(usernameField.getText(), passwordField.getText());
                if(isAuthenticated) {
                    stage.setScene(controller.findPage("chooseFunctionPage").getScene());
                }
                else {
                    new ErrorPage().showError("Error", "Error with username or password");
                }
            }
        );
        
        passwordForgetLink.setOnAction(e -> new ErrorPage().showError("Ha!", "Sounds like a you problem 😎"));

    }

    /**
     * Check if user is authenticated.
     * @param name
     * @param password
     * @return true, when name and password matches.
     */
    private boolean authenticate(String name, String password) {

        LoginController loginController = (LoginController) ControllerManager.getInstance().findController("loginController");
        
        //Get users
        if(!loginController.doesAccountExist(name)){
            return false;
        }
        
        return loginController.getAllAccounts()
                              .stream()
                              .anyMatch(user -> user.getName().equals(name) && user.getPassword().equals(password));
    }
}