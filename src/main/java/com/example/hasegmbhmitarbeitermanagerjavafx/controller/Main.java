package com.example.hasegmbhmitarbeitermanagerjavafx.controller;

import java.io.FileNotFoundException;

import com.example.hasegmbhmitarbeitermanagerjavafx.view.AddEmployeePage;
import com.example.hasegmbhmitarbeitermanagerjavafx.view.ChooseFunctionPage;
import com.example.hasegmbhmitarbeitermanagerjavafx.view.EmployeeManagementPage;
import com.example.hasegmbhmitarbeitermanagerjavafx.view.LoginPage;
import com.example.hasegmbhmitarbeitermanagerjavafx.view.RegisterPage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        
        LoginPage loginPage = new LoginPage();
        Scene scene1 = loginPage.loginPageScene(primaryStage);

        RegisterPage registerPage = new RegisterPage();
        Scene scene2 = registerPage.registerPageScene(primaryStage);

        ChooseFunctionPage chooseFunctionPage = new ChooseFunctionPage();
        Scene scene3 = chooseFunctionPage.chooseFunctionScene(primaryStage);

        EmployeeManagementPage employeeManagementPage = new EmployeeManagementPage();
        Scene scene4 = employeeManagementPage.employeeManagementPageScene(primaryStage);
        
        AddEmployeePage addEmployee = new AddEmployeePage();
        Scene scene5 = addEmployee.addEmployeePageScene(primaryStage);

        // Button click actions
        loginPage.getRegisterButton().setOnAction(e -> primaryStage.setScene(scene2));

        registerPage.getBackToLoginBtn().setOnAction(e -> primaryStage.setScene(scene1));

        loginPage.getLoginButton().setOnAction(e -> primaryStage.setScene(scene3));

        chooseFunctionPage.getEmployeemgmtButton().setOnAction(e -> primaryStage.setScene(scene4));

        employeeManagementPage.getAddEmployeeLink().setOnAction(e -> primaryStage.setScene(scene5));

        addEmployee.getGobackToTableLink().setOnAction(e -> primaryStage.setScene(scene4));

        addEmployee.getSaveButton().setOnAction(e -> primaryStage.setScene(scene4));

        primaryStage.setTitle("Hase GmbH");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
}
