package com.example.hasegmbhmitarbeitermanagerjavafx.employees;

public class Employee {
    private int number;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;

    public Employee(int number, String firstName, String lastName, String email, String telephone) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
    }

    public int getNumber() {
        return number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }
}
