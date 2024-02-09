package com.jonathan;


public class EncodeStringMenu extends MainMenu {

    public EncodeStringMenu(MainMenu parentMenu, String menuName) {
        this.parentMenu = parentMenu;
        this.menuName = menuName;
    }


    @Override
    public void start() {
        getString("Please enter a string to encode and write to file: ");
        this.parentMenu.start();
    }


}