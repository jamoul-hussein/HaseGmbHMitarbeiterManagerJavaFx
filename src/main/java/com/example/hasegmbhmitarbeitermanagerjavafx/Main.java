package com.example.hasegmbhmitarbeitermanagerjavafx;

import com.example.hasegmbhmitarbeitermanagerjavafx.pages.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        SceneManager sceneManager = new SceneManager();

        primaryStage = sceneManager.orchestrateStage(primaryStage);

        primaryStage.setTitle("Hase GmbH");
        primaryStage.show();
    }
}
