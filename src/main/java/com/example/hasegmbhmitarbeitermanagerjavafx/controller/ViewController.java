package com.example.hasegmbhmitarbeitermanagerjavafx.controller;

import java.util.HashMap;

import javafx.scene.Scene;

@SuppressWarnings("exports")
public class ViewController {
    
    private static ViewController instance;
    private HashMap<String,Scene> scenes;

    /**
     * Just for initialization
     */
    private ViewController() {
        this.scenes = new HashMap<String,Scene>();
    }

    /**
     * Only return one instance
     * @return ViewController instance
     */
    public static ViewController getInstance() {
        return instance == null ? instance = new ViewController() : instance;
    }
    
    /**
     * Register a scene to a given name. Cannot add scene more than once under the same name.
     * @param sceneName name the given scene should be registered on
     * @param scene instance of the scene
     * @return true when scene was successfully added, false when not
     */
    public boolean register(String sceneName, Scene scene) {
        if(scenes.containsKey(sceneName)) {
            System.err.println("Already contains scene");
            return false;
        }
        this.scenes.put(sceneName, scene);
        return true;
    }
    
    /**
     * Searches and returns the scene instance found by the scene name parameter.
     * @param sceneName
     * @return instance of Scene
     */
    public Scene findScene(String sceneName) {
        if(!doesSceneExist(sceneName)) {
            System.err.println(String.format("Scene under name %s not found", sceneName));
            return null;
        }
        return this.scenes.get(sceneName);
    }

    /**
     * Does the scene exist under given name?
     * @param sceneName
     * @return true, when scene exists.
     */
    private boolean doesSceneExist(String sceneName) {
        return this.scenes.containsKey(sceneName);
    }
}
