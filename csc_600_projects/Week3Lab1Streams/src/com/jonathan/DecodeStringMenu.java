package com.jonathan;

public class DecodeStringMenu extends MainMenu {

    public DecodeStringMenu(MainMenu parentMenu, String menuName) {
        this.parentMenu = parentMenu;
        this.menuName = menuName;
    }


    @Override
    public void start() {
        getString("Please enter the filename containing the string to decode: ");
        this.parentMenu.start();
    }


}