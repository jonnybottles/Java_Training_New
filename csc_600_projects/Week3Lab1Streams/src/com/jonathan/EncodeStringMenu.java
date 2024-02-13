package com.jonathan;


import com.jonathan.datamodel.CryptKeeper;

public class EncodeStringMenu extends MainMenu {

    public EncodeStringMenu(MainMenu parentMenu, String menuName, CryptKeeper theCryptKeeper) {
        this.parentMenu = parentMenu;
        this.menuName = menuName;
        this.theCryptKeeper = theCryptKeeper;
    }


    @Override
    public void start() {
        String fileName = getString("Please enter a file name to save your encoded string to");
        String theStringToEncrypt = getString("Please enter a string to encode and write to file: ");
        theCryptKeeper.setEncryptedData(theStringToEncrypt);
        theCryptKeeper.writeEncryptedDataToFile(fileName);
        this.parentMenu.start();
    }


}