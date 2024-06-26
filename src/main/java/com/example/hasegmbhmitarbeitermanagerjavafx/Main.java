package com.example.hasegmbhmitarbeitermanagerjavafx;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.hasegmbhmitarbeitermanagerjavafx.controller.*;
import com.example.hasegmbhmitarbeitermanagerjavafx.view.AddEmployeePage;
import com.example.hasegmbhmitarbeitermanagerjavafx.view.ChooseFunctionPage;
import com.example.hasegmbhmitarbeitermanagerjavafx.view.EditEmployeePage;
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
        
        // Create controllers, initialize them
        EmployeeController employeeController = new EmployeeController();
        LoginController loginController = new LoginController();

        List<Controller> controllers = new ArrayList<Controller>();
        controllers.add(employeeController);
        controllers.add(loginController);

        controllers.forEach(c -> c.init());
        
        ControllerManager.getInstance().register("employeeController", employeeController);
        ControllerManager.getInstance().register("loginController", loginController);

        // ControllerManager is accessable everywhere.
        // Watch out for the scope. If you access a controller
        // before or during the intialization (during Main.start()), you might
        // get Exceptions, because not all controller instances exist yet
        
        //Create pages
        LoginPage loginPage = new LoginPage();
        RegisterPage registerPage = new RegisterPage();
        ChooseFunctionPage chooseFunctionPage = new ChooseFunctionPage();
        EmployeeManagementPage employeeManagementPage = new EmployeeManagementPage();
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        EditEmployeePage editEmployeePage = new EditEmployeePage();
        
        //Add pages to list

        List<Page> pages = new ArrayList<Page>(Arrays.asList(loginPage, registerPage, chooseFunctionPage, employeeManagementPage, addEmployeePage, editEmployeePage));
        pages.forEach(page -> page.initializeScene(primaryStage));

        //Get view controller and add all pages to it.
        //With the controller, you can access it everywhere.
        //In this case, I added them statically, soooorryy

        PageManager pageManager = PageManager.getInstance();
        pageManager.register("loginPage", loginPage);
        pageManager.register("registerPage", registerPage);
        pageManager.register("chooseFunctionPage", chooseFunctionPage);
        pageManager.register("employeeManagementPage", employeeManagementPage);
        pageManager.register("addEmployeePage", addEmployeePage);
        pageManager.register("editEmployeePage", editEmployeePage);
        
        //After registering all the pages, register all the buttons
        pages.forEach(page -> page.registerButtons());

        primaryStage.setTitle("Hase GmbH");
        primaryStage.setScene(pageManager.findPage("loginPage").getScene());
        primaryStage.show();
    }
}