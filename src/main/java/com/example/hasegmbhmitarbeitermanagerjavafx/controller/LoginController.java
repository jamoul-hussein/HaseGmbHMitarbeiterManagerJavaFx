package com.example.hasegmbhmitarbeitermanagerjavafx.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.hasegmbhmitarbeitermanagerjavafx.model.Account;

public class LoginController implements Controller {

    private List<Account> accounts;

    @Override
    public void init() {
        accounts = new ArrayList<>();
    }

    public boolean addAccount(String name, String password) {
        
        if(doesAccountExist(name)){
            System.err.println(String.format("Account with name: %s already exists", name));
            return false;
        }

        accounts.add(new Account(name, password));
        return true;
    }

    public List<Account> getAllAccounts() {
        return accounts;
    }

    public Account getAccount(String name) {
        if(!doesAccountExist(name)) {
            System.err.println(String.format("Account with name: %s does not exist", name));
            return null;
        }

        return accounts.stream().filter(acc -> acc.getName().equals(name)).toList().get(0);
    }

    public boolean doesAccountExist(String name) {
        return accounts.stream().anyMatch(acc -> acc.getName().equals(name));
    }
}