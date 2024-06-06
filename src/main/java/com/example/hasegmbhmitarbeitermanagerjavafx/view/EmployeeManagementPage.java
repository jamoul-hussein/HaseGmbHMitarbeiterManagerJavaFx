package com.example.hasegmbhmitarbeitermanagerjavafx.view;

import com.example.hasegmbhmitarbeitermanagerjavafx.controller.ViewController;
import com.example.hasegmbhmitarbeitermanagerjavafx.model.Employee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class EmployeeManagementPage implements Page{

    private Hyperlink addEmployeeLink;
    private Scene scene;
    private Stage stage;

    private TableView renderTable() {
        // Create columns
        TableColumn<Employee, Integer> numberColumn = new TableColumn<>("Number");
        TableColumn<Employee, String> firstNameColumn = new TableColumn<>("First Name");
        TableColumn<Employee, String> lastNameColumn = new TableColumn<>("Last Name");
        TableColumn<Employee, String> emailColumn = new TableColumn<>("Email");
        TableColumn<Employee, String> telephoneColumn = new TableColumn<>("Telephone");

        // Set column widths (optional)
        numberColumn.setPrefWidth(100);
        numberColumn.setResizable(true);

        firstNameColumn.setPrefWidth(150);
        firstNameColumn.setResizable(true);

        lastNameColumn.setPrefWidth(150);
        lastNameColumn.setResizable(true);

        emailColumn.setPrefWidth(200);
        emailColumn.setResizable(true);

        telephoneColumn.setPrefWidth(150);
        telephoneColumn.setResizable(true);


        // Set cell value factories
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        numberColumn.setStyle("-fx-alignment: CENTER;");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("telephone"));

        // Create a TableView
        TableView<Employee> tableView = new TableView<>();
        tableView.getColumns().addAll(numberColumn, firstNameColumn, lastNameColumn, emailColumn, telephoneColumn);
        // Create sample data
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        ObservableList<Employee> data = FXCollections.observableArrayList(
                new Employee(1, "John", "Doe", "john@example.com", "1234567890"),
                new Employee(2, "Jane", "Smith", "jane@example.com", "9876543210")
        );

        tableView.setItems(data);

        return tableView;
    }

    public Hyperlink getAddEmployeeLink() {
        return this.addEmployeeLink;
    }

    @Override
    public void initializeScene(Stage stage) {

        this.stage = stage;

        Screen screen = Screen.getPrimary();
        // Get the visual bounds of the primary screen
        Rectangle2D bounds = screen.getVisualBounds();
        // Get the width of the screen
        double screenWidth = bounds.getWidth();


        Text textHeader = new Text();
        textHeader.setText("MITARBEITER VERWALTEN");
        textHeader.setFont(Font.font("Inter", 40));
        textHeader.setStyle(Styles.headerStyle);

        HBox headerContainer = new HBox();
        headerContainer.setPadding(new Insets(80, 0, 0, 140));
        headerContainer.getChildren().add(textHeader);


        // SVG content
        String svgContent = "M 21 3 C 11.6 3 4 10.6 4 20 C 4 29.4 11.6 37 21 37 C 24.354553 37 27.47104 36.01984 30.103516 34.347656 L 42.378906 46.621094 L 46.621094 42.378906 L 34.523438 30.279297 C 36.695733 27.423994 38 23.870646 38 20 C 38 10.6 30.4 3 21 3 z M 21 7 C 28.2 7 34 12.8 34 20 C 34 27.2 28.2 33 21 33 C 13.8 33 8 27.2 8 20 C 8 12.8 13.8 7 21 7 z";

        // Create an SVGPath object and set its content
        SVGPath svgPath = new SVGPath();
        svgPath.setContent(svgContent);
        svgPath.setFill(Color.WHITE); // Set the fill color to white
        svgPath.setScaleX(0.5); // Scale the SVG to desired size
        svgPath.setScaleY(0.5);

        // Create a TextField
        TextField textField = new TextField();
        textField.setStyle(Styles.inputFieldStyle);
        textField.setFont(Font.font("Inter", 20));
        textField.setPrefWidth(200);
        textField.setPadding(new Insets(27, 0, 0, 0));

        // Create a Button and set the SVGPath as its graphic
        Button searchButton = new Button();
        searchButton.setStyle("-fx-background-color: #52321D; -fx-text-fill: #ffffff; -fx-border-radius: 0px;");
        searchButton.setGraphic(svgPath); // Set the SVG as the button's graphic
        searchButton.setPrefWidth(25);
        searchButton.setPrefHeight(15);

        HBox searchSection = new HBox();
        searchSection.getChildren().addAll(searchButton, textField);
        searchSection.setSpacing(20);

        this.addEmployeeLink = new Hyperlink("+ HINZUFÜGEN");
        this.addEmployeeLink.setFont(Font.font("Inter", 22));
        this.addEmployeeLink.setStyle(Styles.labelStyle);
        this.addEmployeeLink.setPrefWidth(200);

        HBox searchAndAddEmployeeSection = new HBox();
        searchAndAddEmployeeSection.getChildren().addAll(searchSection, this.addEmployeeLink);
        searchAndAddEmployeeSection.setSpacing(300);
        searchAndAddEmployeeSection.setPadding(new Insets(80, 0, 0, 140));

        TableView tableView = this.renderTable();

        //=============================================================
        Button deleteButton = new Button();
        deleteButton.setText("LÖSCHEN");
        deleteButton.setFont(Font.font("Inter", 22));
        deleteButton.setPrefWidth(500);
        deleteButton.setStyle("-fx-background-color: #52321D;" + "-fx-text-fill: #ffffff; " + "-fx-font-size: 20px; "
                + "-fx-border-radius: 0px; ");

        Button editButton = new Button();
        editButton.setText("ÄNDERN");
        editButton.setFont(Font.font("Inter", 22));
        editButton.setPrefWidth(500);
        editButton.setStyle("-fx-background-color: #52321D;" + "-fx-text-fill: #ffffff; " + "-fx-font-size: 20px; "
                + "-fx-border-radius: 0px; ");

        HBox actionSection = new HBox(200, deleteButton, editButton);
        actionSection.setPadding(new Insets(0, 140, 0, 140));

        VBox vBox = new VBox();
        vBox.getChildren().addAll(searchAndAddEmployeeSection, tableView, actionSection);
        vBox.setSpacing(30);

        // root
        BorderPane root = new BorderPane();
        root.setTop(headerContainer);
        root.setCenter(vBox);
        root.setStyle("-fx-background-color: " + Styles.backgroundColor);

        this.scene = new Scene(root, 1024, 768);
    }

    @Override
    public Scene getScene() {
        return this.scene;
    }

    @Override
    public void registerButtons() {
        addEmployeeLink.setOnAction(e -> ViewController.getInstance().findScene("addEmployeePage"));    
    }
}
