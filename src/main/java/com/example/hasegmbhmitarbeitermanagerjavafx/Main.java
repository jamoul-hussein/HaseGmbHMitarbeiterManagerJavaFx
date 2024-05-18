package com.example.hasegmbhmitarbeitermanagerjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {

        LoginPage loginPage = new LoginPage();
        Scene scene1 = loginPage.loginPageScene(primaryStage);

        RegisterPage registerPage = new RegisterPage();
        Scene scene2 = registerPage.registerPageScene(primaryStage);

        // Button click actions
        loginPage.getRegisterButton().setOnAction(e -> primaryStage.setScene(scene2));

        primaryStage.setTitle("Hase GmbH");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
}
