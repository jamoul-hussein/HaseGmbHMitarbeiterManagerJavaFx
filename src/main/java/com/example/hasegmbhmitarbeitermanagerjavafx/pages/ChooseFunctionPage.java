package com.example.hasegmbhmitarbeitermanagerjavafx.pages;


import com.example.hasegmbhmitarbeitermanagerjavafx.Styles;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class ChooseFunctionPage {

    private Button employeemgmt;

    public Scene chooseFunctionScene(Stage primaryStage) throws FileNotFoundException {

        Screen screen = Screen.getPrimary();
        // Get the visual bounds of the primary screen
        Rectangle2D bounds = screen.getVisualBounds();
        // Get the width of the screen
        double screenWidth = bounds.getWidth();
        double screenHeight = bounds.getHeight();

        Text textHeader = new Text();
        textHeader.setText("FUNKTION AUSWÄHLEN");
        textHeader.setFont(Font.font("Inter", 60));
        textHeader.setStyle(Styles.headerStyle);

        HBox headerContainer = new HBox();
        headerContainer.setPadding(new Insets(100, 0, 0, 140));
        headerContainer.getChildren().add(textHeader);

        //=================================================================================
        Button taskmgmt = new Button();
        taskmgmt.setText("Auftrags- Verwaltung");
        taskmgmt.setFont(Font.font("Inter", FontWeight.MEDIUM, 22));
        taskmgmt.setStyle("-fx-text-fill: #52321D; " +
                "-fx-stroke: #52321D;" +
                " -fx-stroke-width: 1;" +
                "-fx-background-color: #F4D8C3;" +
                "-fx-text-alignment: center");
        taskmgmt.setPrefHeight(screenHeight * 0.3);
        taskmgmt.setPrefWidth(screenWidth * 0.11);
        taskmgmt.setWrapText(true);

        Button customermgmt = new Button();
        customermgmt.setText("Kunden- Verwaltung");
        customermgmt.setFont(Font.font("Inter", FontWeight.SEMI_BOLD, 22));
        customermgmt.setStyle("-fx-text-fill: #52321D; " +
                "-fx-stroke: #52321D;" +
                " -fx-stroke-width: 1;" +
                "-fx-background-color: #EACAB5;" +
                "-fx-text-alignment: center");
        customermgmt.setPrefHeight(screenHeight * 0.3);
        customermgmt.setPrefWidth(screenWidth * 0.11);
        customermgmt.setWrapText(true);

        this.employeemgmt = new Button();
        this.employeemgmt.setText("Mitarbeiter- Verwaltung");
        this.employeemgmt.setFont(Font.font("Inter", FontWeight.SEMI_BOLD, 22));
        this.employeemgmt.setStyle("-fx-text-fill: #52321D; " +
                "-fx-stroke: #52321D;" +
                " -fx-stroke-width: 2;" +
                "-fx-background-color: #CBAB96;" +
                "-fx-text-alignment: center");
        this.employeemgmt.setPrefHeight(screenHeight * 0.3);
        this.employeemgmt.setPrefWidth(screenWidth * 0.11);
        this.employeemgmt.setWrapText(true);


        HBox buttonContainer = new HBox();
        buttonContainer.setPadding(new Insets(100, 0, 0, 140));
        buttonContainer.setSpacing(50);
        buttonContainer.getChildren().addAll(taskmgmt, customermgmt, employeemgmt);

        BorderPane root = new BorderPane();
        root.setTop(headerContainer);
        root.setCenter(buttonContainer);
        root.setStyle("-fx-background-color: " + Styles.backgroundColor);

        Scene scene = new Scene(root, 1024, 768);

        return scene;
    }

    public Button getEmployeemgmtButton(){
        return this.employeemgmt;
    }
}
