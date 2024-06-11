package com.example.hasegmbhmitarbeitermanagerjavafx.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.hasegmbhmitarbeitermanagerjavafx.model.Employee;

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

    /**
     * Update employees, null values keep the old values
     */
    public boolean updateEmployee(int id, String firstName, String lastName, String email, String telephone) {
        
        if(!doesEmployeeExist(id)) {
            System.err.println(String.format("Employee with id: %d was not found", id));
            return false;
        }

        Employee oldEmployee = getEmployee(id); 
        Employee updatedEmployee = new Employee(id, 
                                                firstName == null ? oldEmployee.getFirstName() : firstName, 
                                                lastName == null ? oldEmployee.getLastName() : lastName, 
                                                email == null ? oldEmployee.getEmail() : email, 
                                                telephone == null ? oldEmployee.getTelephone() : telephone
        );

        getAllEmployees().set(getAllEmployees().indexOf(oldEmployee), updatedEmployee);
        return true;
    }

    public boolean removeEmployee(int id) {
        
        if(!doesEmployeeExist(id)) {
            System.err.println(String.format("Employee with id: %d does not exist", id));
            return false;
        }

        Employee employee = employees.stream().filter(emp -> emp.getNumber()==id).toList().get(0);
        employees.remove(employee);
        
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
