package com.example.hasegmbhmitarbeitermanagerjavafx;

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

public class AddEmployeePage {
	private Button backToLoginButton;

	public Scene addEmployeePageScene(Stage primaryStage) {

		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		double screenWidth = bounds.getWidth();

		Text textHeader = new Text();
		textHeader.setText("MITARBEITER HINZUFÜGEN");
		textHeader.setFont(Font.font("Inter", 60));
		textHeader.setStyle(Styles.headerStyle);

		HBox headerContainer = new HBox();
		headerContainer.setPadding(new Insets(100, 0, 0, 140));
		headerContainer.getChildren().add(textHeader);

		// ==========================================================

		Label firstnameLabel = new Label("VORNAME");
		firstnameLabel.setStyle(Styles.labelStyle);
		firstnameLabel.setFont(Font.font("Inter", 22));
		firstnameLabel.setPrefWidth(200);

		TextField textField = new TextField();
		textField.setStyle(Styles.inputFieldStyle);
		textField.setPrefWidth(500);

		HBox firstnameHbox = new HBox();
		firstnameHbox.setPadding(new Insets(60, 0, 0, 140));
		firstnameHbox.getChildren().addAll(firstnameLabel, textField);
		firstnameHbox.setSpacing(30);

		// ==========================================================

		Label lastnameLabel = new Label("NACHNAME");
		lastnameLabel.setStyle(Styles.labelStyle);
		lastnameLabel.setFont(Font.font("Inter", 22));
		lastnameLabel.setPrefWidth(200);

		TextField lastnameTextfield = new TextField();
		lastnameTextfield.setStyle(Styles.inputFieldStyle);
		lastnameTextfield.setPrefWidth(500);

		HBox lastNameHbox = new HBox();
		lastNameHbox.setPadding(new Insets(60, 0, 0, 140));
		lastNameHbox.getChildren().addAll(lastnameLabel, lastnameTextfield);
		lastNameHbox.setSpacing(30);

		// ==========================================================
		Label emailLabel = new Label("EMAIL");
		emailLabel.setStyle(Styles.labelStyle);
		emailLabel.setFont(Font.font("Inter", 22));
		emailLabel.setPrefWidth(200);
		emailLabel.setWrapText(true);

		TextField emailTextfield = new TextField();
		emailTextfield.setStyle(Styles.inputFieldStyle);
		emailTextfield.setPrefWidth(500);

		HBox emailHbox = new HBox();
		emailHbox.setPadding(new Insets(60, 0, 0, 140));
		emailHbox.getChildren().addAll(emailLabel, emailTextfield);
		emailHbox.setSpacing(30);

		// ==========================================================
		Label telefonLabel = new Label("TELEFON");
		telefonLabel.setStyle(Styles.labelStyle);
		telefonLabel.setFont(Font.font("Inter", 22));
		telefonLabel.setPrefWidth(200);
		telefonLabel.setWrapText(true);

		TextField telefonTextfield = new TextField();
		telefonTextfield.setStyle(Styles.inputFieldStyle);
		telefonTextfield.setPrefWidth(500);

		HBox telefonHbox = new HBox();
		telefonHbox.setPadding(new Insets(60, 0, 0, 140));
		telefonHbox.getChildren().addAll(telefonLabel, telefonTextfield);
		telefonHbox.setSpacing(30);

		// ==========================================================
		Hyperlink gobackLink = new Hyperlink("<< zurück");
		gobackLink.setFont(Font.font("Inter", 22));
		gobackLink.setStyle(Styles.labelStyle);
		gobackLink.setPrefWidth(200);
		
		Button saveButton = new Button();
		saveButton.setText("SPEICHERN");
		saveButton.setFont(Font.font("Inter", 22));
		saveButton.setPrefWidth(500);
		saveButton.setStyle("-fx-background-color: #52321D;" + "-fx-text-fill: #ffffff; " + "-fx-font-size: 20px; "
				+ "-fx-border-radius: 0px; ");
		
		
		HBox buttonsHbox = new HBox();
		buttonsHbox.setPadding(new Insets(60, 0, 0, 140));
		buttonsHbox.getChildren().addAll(gobackLink, saveButton);
		buttonsHbox.setSpacing(30);
		

		VBox vBox = new VBox();
		vBox.getChildren().addAll(firstnameHbox, lastNameHbox, emailHbox, telefonHbox, buttonsHbox);

		

		// root
		BorderPane root = new BorderPane();
		root.setTop(headerContainer);
		root.setCenter(vBox);
		root.setStyle("-fx-background-color: " + Styles.backgroundColor);

		Scene scene = new Scene(root, 1024, 768);
		return scene;
	}

	public Button getBackToLoginBtn() {
		return this.backToLoginButton;
	}
}
