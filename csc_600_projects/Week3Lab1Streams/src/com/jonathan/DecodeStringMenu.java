package com.jonathan;

import com.jonathan.datamodel.CryptKeeper;

public class DecodeStringMenu extends MainMenu {

    public DecodeStringMenu(MainMenu parentMenu, String menuName, CryptKeeper theCryptKeeper) {
        this.parentMenu = parentMenu;
        this.menuName = menuName;
        this.theCryptKeeper = theCryptKeeper;
    }


    @Override
    public void start() {
        getString("Please enter the filename containing the string to decode: ");
        this.parentMenu.start();
    }


}