package com.example.hasegmbhmitarbeitermanagerjavafx.model;

public class Account {
    
    private String name;

    //NEVER EVER SAVE THE PASSWORD DIRECTLY!
    private String password;

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}