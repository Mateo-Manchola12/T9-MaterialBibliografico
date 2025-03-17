package app;

import app.controllers.MenuController;

public class App {
    public static void main(String[] args) {
        MenuController menu = new MenuController();
        menu.start();
    }
}