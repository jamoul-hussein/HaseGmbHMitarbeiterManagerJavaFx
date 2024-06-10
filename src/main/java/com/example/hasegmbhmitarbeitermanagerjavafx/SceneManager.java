package com.example.hasegmbhmitarbeitermanagerjavafx;

import com.example.hasegmbhmitarbeitermanagerjavafx.pages.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class SceneManager {

    public Stage orchestrateStage(Stage primaryStage) throws FileNotFoundException {
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

        primaryStage.setScene(scene1);

        return primaryStage;

    }
}
