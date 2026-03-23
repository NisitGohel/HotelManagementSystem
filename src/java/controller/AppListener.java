package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Application Started...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Application Stopped...");
    }
}