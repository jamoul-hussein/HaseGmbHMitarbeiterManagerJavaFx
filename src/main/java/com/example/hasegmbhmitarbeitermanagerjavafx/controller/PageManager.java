package com.example.hasegmbhmitarbeitermanagerjavafx.controller;

import java.util.HashMap;

import com.example.hasegmbhmitarbeitermanagerjavafx.view.Page;

public class PageManager {
    
    private static PageManager instance;
    private HashMap<String,Page> pages;

    /**
     * Just for initialization
     */
    private PageManager() {
        this.pages = new HashMap<String,Page>();
    }

    /**
     * Only return one instance
     * @return PageManager instance
     */
    public static PageManager getInstance() {
        return instance == null ? instance = new PageManager() : instance;
    }
    
    /**
     * Register a page to a given name. Cannot add page more than once under the same name.
     * @param pageName name the given page should be registered on
     * @param page instance of the page
     * @return true when page was successfully added, false when not
     */
    public boolean register(String pageName, Page page) {
        if(pages.containsKey(pageName)) {
            System.err.println("Already contains page");
            return false;
        }
        this.pages.put(pageName, page);
        return true;
    }
    
    /**
     * Searches and returns the page instance found by the page name parameter.
     * @param pageName
     * @return instance of Page
     */
    public Page findPage(String pageName) {
        if(!doesPageExist(pageName)) {
            System.err.println(String.format("Page under name %s not found", pageName));
            return null;
        }
        return this.pages.get(pageName);
    }

    /**
     * Does the page exist under given name?
     * @param pageName
     * @return true, when page exists.
     */
    private boolean doesPageExist(String pageName) {
        return this.pages.containsKey(pageName);
    }
}
