package com.example.hasegmbhmitarbeitermanagerjavafx.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.hasegmbhmitarbeitermanagerjavafx.view.AddEmployeePage;
import com.example.hasegmbhmitarbeitermanagerjavafx.view.ChooseFunctionPage;
import com.example.hasegmbhmitarbeitermanagerjavafx.view.EmployeeManagementPage;
import com.example.hasegmbhmitarbeitermanagerjavafx.view.LoginPage;
import com.example.hasegmbhmitarbeitermanagerjavafx.view.Page;
import com.example.hasegmbhmitarbeitermanagerjavafx.view.RegisterPage;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        
        //Create pages
        LoginPage loginPage = new LoginPage();
        RegisterPage registerPage = new RegisterPage();
        ChooseFunctionPage chooseFunctionPage = new ChooseFunctionPage();
        EmployeeManagementPage employeeManagementPage = new EmployeeManagementPage();
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        
        //Add pages to list

        List<Page> pages = new ArrayList<Page>(Arrays.asList(loginPage, registerPage, chooseFunctionPage, employeeManagementPage, addEmployeePage));
        pages.forEach(page -> page.initializeScene(primaryStage));

        //Get view controller and add all pages to it.
        //With the controller, you can access it everywhere.
        //In this case, I added them statically, soooorryy

        ViewManager viewManager = ViewManager.getInstance();
        viewManager.register("loginPage", loginPage.getScene());
        viewManager.register("registerPage", registerPage.getScene());
        viewManager.register("chooseFunctionPage", chooseFunctionPage.getScene());
        viewManager.register("employeeManagementPage", employeeManagementPage.getScene());
        viewManager.register("addEmployeePage", addEmployeePage.getScene());
        
        //After registering all the pages, register all the buttons
        
        pages.forEach(page -> page.registerButtons());

        primaryStage.setTitle("Hase GmbH");
        primaryStage.setScene(viewManager.findScene("loginPage"));
        primaryStage.show();
    }
}