package com.example.hasegmbhmitarbeitermanagerjavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EmployeeManagementPage
{

    private Button registerButton;

    public Scene loginPageScene(Stage primaryStage) throws FileNotFoundException {

        Screen screen = Screen.getPrimary();
        // Get the visual bounds of the primary screen
        Rectangle2D bounds = screen.getVisualBounds();
        // Get the width of the screen
        double screenWidth = bounds.getWidth();


        Text textHeader = new Text();
        textHeader.setText("LOGIN");
        textHeader.setFont(Font.font("Inter", 40));
        textHeader.setStyle(Styles.headerStyle);

        HBox headerContainer = new HBox();
        headerContainer.setPadding(new Insets(80, 0, 0, 140));
        headerContainer.getChildren().add(textHeader);


        // SVG content
/*
        String svgContent = "M256,64C150.13,64,64,150.13,64,256s86.13,192,192,192,192-86.13,192-192S361.87,64,256,64Zm80,294.63-54.15-54.15a88.08,88.08,0,1,1,22.63-22.63L358.63,336Z";

        // Create an SVGPath object and set its content
        SVGPath svgPath = new SVGPath();
        svgPath.setContent(svgContent);
        svgPath.setStyle("-fx-scale-x: 0.1; -fx-scale-y: 0.1;");
*/

        TextField textField = new TextField();
        textField.setStyle(Styles.inputFieldStyle);
        textField.setPrefWidth(500);

        Button searchButton = new Button();
        searchButton.setStyle("-fx-background-color: #52321D;" +
                "-fx-text-fill: #ffffff; " +
                "-fx-font-size: 20px; " +
                "-fx-border-radius: 0px; ");

        searchButton.setText("SEARCH");
        searchButton.setPrefWidth(20);
        searchButton.setPrefHeight(20);

        HBox searchAndAddEmployeeSection = new HBox();

        searchAndAddEmployeeSection.getChildren().addAll(searchButton, textField);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(searchAndAddEmployeeSection);


        // root
        BorderPane root = new BorderPane();
        root.setTop(headerContainer);
        root.setCenter(vBox);
        root.setStyle("-fx-background-color: " + Styles.backgroundColor);

        Scene scene = new Scene(root, 1024, 768);

        return scene;
    }
    private String loadSVGFile(String filePath) {
        try {
            // Read SVG file content as a string
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public Button getRegisterButton() {
        return this.registerButton;
    }

}
