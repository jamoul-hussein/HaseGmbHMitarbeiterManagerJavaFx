package com.example.hasegmbhmitarbeitermanagerjavafx.view;

import javafx.scene.Scene;
import javafx.stage.Stage;

@SuppressWarnings("exports")
public interface Page {

    /**
     * Initialize the scene. This method acts as the constructor.
     * @return instance of scene
     */
    public void initializeScene(Stage stage);

    /**
     * Get the scene instance of a page.
     * @return instance of scene
     */
    public Scene getScene();

    /**
     * Call this method for registerin the buttons. 
     * This method is called after the initializeScene() method.
     */
    public void registerButtons();
}