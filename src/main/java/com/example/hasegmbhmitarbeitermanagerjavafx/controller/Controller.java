package com.example.hasegmbhmitarbeitermanagerjavafx.controller;

/**
 * This interface is just for holding instances of different controllers classes
 * under the same base. 
 */
public interface Controller {
    /**
     * <p> 
     * If you need to initialize the controller attributes 
     * or call certain methods you can do it here.
     * This method is currently only called once the controller is being created.
     * With this method, the constructor of a Controller might induce side effects.
     * </p>
     * 
     * <p><b> If you dont need it, don't implement it </b></p>
     */
    public void init();
}
