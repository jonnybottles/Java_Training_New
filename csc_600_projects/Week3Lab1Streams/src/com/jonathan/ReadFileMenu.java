package com.jonathan;


public class ReadFileMenu extends MainMenu {

    public ReadFileMenu(MainMenu parentMenu, String menuName) {
        this.parentMenu = parentMenu;
        this.menuName = menuName;
    }


    @Override
    public void start() {
        getString("Please enter path of file to read: ");
        this.parentMenu.start();
    }


}