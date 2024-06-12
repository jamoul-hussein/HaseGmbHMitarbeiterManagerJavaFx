package com.example.hasegmbhmitarbeitermanagerjavafx.controller;

import java.util.HashMap;

public class ControllerManager {
    
    private static ControllerManager instance;
    private HashMap<String,Controller> controllers;

    /**
     * Just for initialization
     */
    private ControllerManager() {
        this.controllers = new HashMap<String,Controller>();
    }

    /**
     * Only return one instance
     * @return ControllerManager instance
     */
    public static ControllerManager getInstance() {
        return instance == null ? instance = new ControllerManager() : instance;
    }
    
    /**
     * Register a controller to a given name. Cannot add controller more than once under the same name.
     * @param controllerName name the given controller should be registered on
     * @param controller instance of the controller
     * @return true when scene was successfully added, false when not
     */
    public boolean register(String controllerName, Controller controller) {
        if(controllers.containsKey(controllerName)) {
            System.err.println("Already contains controller");
            return false;
        }
        this.controllers.put(controllerName, controller);
        return true;
    }
    
    /**
     * Searches and returns the controller instance found by the controller name parameter.
     * @param controllerName
     * @return instance of Controller
     */
    public Controller findController(String controllerName) {
        if(!doesSceneExist(controllerName)) {
            System.err.println(String.format("Controller under name %s not found", controllerName));
            return null;
        }
        return this.controllers.get(controllerName);
    }

    /**
     * Does the scene exist under given name?
     * @param controllerName
     * @return true, when scene exists.
     */
    private boolean doesSceneExist(String controllerName) {
        return this.controllers.containsKey(controllerName);
    }

}
