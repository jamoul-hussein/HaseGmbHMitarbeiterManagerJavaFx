package com.example.hasegmbhmitarbeitermanagerjavafx.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ErrorPage {
	
	
	public void showError(String title, String message) {
	Alert alert =  new Alert(AlertType.ERROR);
	alert.setTitle(title);
	alert.setContentText(message);
	
	alert.showAndWait();
	}

}
