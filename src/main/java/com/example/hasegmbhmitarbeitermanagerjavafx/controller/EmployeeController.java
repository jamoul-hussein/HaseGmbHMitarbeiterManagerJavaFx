package com.example.hasegmbhmitarbeitermanagerjavafx.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.hasegmbhmitarbeitermanagerjavafx.model.Employee;

public class EmployeeController implements Controller {

    private List<Employee> employees;
    private Employee selectedEmployee;
    private int availableId = 1;

    @Override
    public void init() {
        employees = new ArrayList<>();
    }

    public boolean addEmployee(String firstName, String lastName, String email, String telephone) {
        
        //In optimal case, this should never be run.
        if(doesEmployeeExist(availableId)){
            System.err.println(String.format("Employee with id: %d already exists", availableId));
            return false;
        }

        employees.add(new Employee(availableId, firstName, lastName, email, telephone));
        availableId++; //Always increment by one
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

        return employees.stream().filter(employee -> employee.getNumber() == id).toList().get(0);
    }

    public boolean doesEmployeeExist(int id) {
        return employees.stream().anyMatch(employee -> employee.getNumber() == id);
    }

    public Employee getSelectedEmployee() {
        return selectedEmployee;
    }

    public void setSelectedEmployee(Employee selectedEmployee) {
        this.selectedEmployee = selectedEmployee;
    }

}
