package com.example.hasegmbhmitarbeitermanagerjavafx.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.hasegmbhmitarbeitermanagerjavafx.model.Employee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeController implements Controller {

    private List<Employee> employees;

    @Override
    public void init() {
        employees = new ArrayList<>();
    }

    public boolean addEmployee(int id, String firstName, String lastName, String email, String telephone) {
        
        if(doesEmployeeExist(id)){
            System.err.println(String.format("Employee with id: %d already exists", id));
            return false;
        }

        employees.add(new Employee(id, firstName, lastName, email, telephone));
        return true;
    }

    public boolean removeEmployee(int id) {
        
        if(doesEmployeeExist(id)) {
            System.err.println(String.format("Employee with id: %d already exists", id));
            return false;
        }

        employees.remove(id);
        return true;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) {
        if(!doesEmployeeExist(id)) {
            System.err.println(String.format("Employee with id: %d does not exist", id));
            return null;
        }
        return employees.get(id);
    }

    public boolean doesEmployeeExist(int id) {
        return employees.stream().anyMatch(employee -> employee.getNumber() == id);
    }

}
