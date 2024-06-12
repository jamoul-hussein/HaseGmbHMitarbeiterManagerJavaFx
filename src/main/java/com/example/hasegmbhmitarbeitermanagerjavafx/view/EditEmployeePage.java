package com.example.hasegmbhmitarbeitermanagerjavafx.view;

import com.example.hasegmbhmitarbeitermanagerjavafx.controller.ControllerManager;
import com.example.hasegmbhmitarbeitermanagerjavafx.controller.EmployeeController;
import com.example.hasegmbhmitarbeitermanagerjavafx.controller.PageManager;
import com.example.hasegmbhmitarbeitermanagerjavafx.model.Employee;
import com.example.hasegmbhmitarbeitermanagerjavafx.view.Error.ErrorPage;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class EditEmployeePage implements Page{
	
	private Hyperlink gobackLink;
	private Button saveButton;

	private TextField firstnameField;
	private TextField lastnameField;
	private TextField emailField;
	private TextField telephoneField;

	private Scene scene;
	private Stage stage;

	@Override
	public void initializeScene(Stage stage) {

		this.stage = stage;

		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		double screenWidth = bounds.getWidth();

		Text textHeader = new Text();
		textHeader.setText("MITARBEITER EDITIEREN");
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

		firstnameField = new TextField();
		firstnameField.setStyle(Styles.inputFieldStyle);
		firstnameField.setPrefWidth(500);

		HBox firstnameHbox = new HBox();
		firstnameHbox.setPadding(new Insets(60, 0, 0, 140));
		firstnameHbox.getChildren().addAll(firstnameLabel, firstnameField);
		firstnameHbox.setSpacing(30);

		// ==========================================================

		Label lastnameLabel = new Label("NACHNAME");
		lastnameLabel.setStyle(Styles.labelStyle);
		lastnameLabel.setFont(Font.font("Inter", 22));
		lastnameLabel.setPrefWidth(200);

		lastnameField = new TextField();
		lastnameField.setStyle(Styles.inputFieldStyle);
		lastnameField.setPrefWidth(500);

		HBox lastNameHbox = new HBox();
		lastNameHbox.setPadding(new Insets(60, 0, 0, 140));
		lastNameHbox.getChildren().addAll(lastnameLabel, lastnameField);
		lastNameHbox.setSpacing(30);

		// ==========================================================
		Label emailLabel = new Label("EMAIL");
		emailLabel.setStyle(Styles.labelStyle);
		emailLabel.setFont(Font.font("Inter", 22));
		emailLabel.setPrefWidth(200);
		emailLabel.setWrapText(true);

		emailField = new TextField();
		emailField.setStyle(Styles.inputFieldStyle);
		emailField.setPrefWidth(500);

		HBox emailHbox = new HBox();
		emailHbox.setPadding(new Insets(60, 0, 0, 140));
		emailHbox.getChildren().addAll(emailLabel, emailField);
		emailHbox.setSpacing(30);

		// ==========================================================
		Label telefonLabel = new Label("TELEFON");
		telefonLabel.setStyle(Styles.labelStyle);
		telefonLabel.setFont(Font.font("Inter", 22));
		telefonLabel.setPrefWidth(200);
		telefonLabel.setWrapText(true);

		telephoneField = new TextField();
		telephoneField.setStyle(Styles.inputFieldStyle);
		telephoneField.setPrefWidth(500);

		HBox telefonHbox = new HBox();
		telefonHbox.setPadding(new Insets(60, 0, 0, 140));
		telefonHbox.getChildren().addAll(telefonLabel, telephoneField);
		telefonHbox.setSpacing(30);

		// ==========================================================
		this.gobackLink = new Hyperlink("<< zurück");
		this.gobackLink.setFont(Font.font("Inter", 22));
		this.gobackLink.setStyle(Styles.labelStyle);
		this.gobackLink.setPrefWidth(200);
		
		this.saveButton = new Button();
		this.saveButton.setText("SPEICHERN");
		this.saveButton.setFont(Font.font("Inter", 22));
		this.saveButton.setPrefWidth(500);
		this.saveButton.setStyle("-fx-background-color: #52321D;" + "-fx-text-fill: #ffffff; " + "-fx-font-size: 20px; "
				+ "-fx-border-radius: 0px; ");
		
		
		HBox buttonsHbox = new HBox();
		buttonsHbox.setPadding(new Insets(60, 0, 0, 140));
		buttonsHbox.getChildren().addAll(this.gobackLink, this.saveButton);
		buttonsHbox.setSpacing(30);
		

		VBox vBox = new VBox();
		vBox.getChildren().addAll(firstnameHbox, lastNameHbox, emailHbox, telefonHbox, buttonsHbox);

		// root
		BorderPane root = new BorderPane();
		root.setTop(headerContainer);
		root.setCenter(vBox);
		root.setStyle("-fx-background-color: " + Styles.backgroundColor);

		this.scene = new Scene(root, 1024, 768);
	}
	
	@Override
	public Scene getScene() {
		return scene;
	}

	// TODO
	// when deleting objects, basing the new id on the list size may result in id-conflicts


	@Override
	public void registerButtons() {
		PageManager pageManager = PageManager.getInstance();
		gobackLink.setOnAction(e -> stage.setScene(pageManager.findPage("employeeManagementPage").getScene()));

		saveButton.setOnAction(e -> 
			{
				
				EmployeeController employeeController = (EmployeeController) ControllerManager.getInstance().findController("employeeController");

				if(employeeController.getSelectedEmployee() == null) {
					stage.setScene(PageManager.getInstance().findPage("employeeManagementPage").getScene());
					new ErrorPage().showError("Error", "Not selected");
					return;
				}

				employeeController.updateEmployee(employeeController.getSelectedEmployee().getNumber(), firstnameField.getText(), lastnameField.getText(), emailField.getText(), telephoneField.getText());
				
				stage.setScene(pageManager.findPage("employeeManagementPage").getScene());
				((EmployeeManagementPage) pageManager.findPage("employeeManagementPage")).refreshTable();
			} 
		);
	}

	public boolean refresh() {
		EmployeeController employeeController = (EmployeeController) ControllerManager.getInstance().findController("employeeController");

		Employee employee = employeeController.getSelectedEmployee();
		firstnameField.setText(employee.getFirstName());
		lastnameField.setText(employee.getLastName());
		emailField.setText(employee.getEmail());
		telephoneField.setText(employee.getTelephone());

		System.out.println(String.format("Numb: %d First %s Last %s Tele %s Email %s", employee.getNumber(), employee.getFirstName(), employee.getLastName(), employee.getTelephone(), employee.getEmail()));
		
		return true;
	}
}