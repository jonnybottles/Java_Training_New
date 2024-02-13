package com.jonathan;


import com.jonathan.datamodel.CryptKeeper;

public class ReadFileMenu extends MainMenu {

    public ReadFileMenu(MainMenu parentMenu, String menuName, CryptKeeper theCryptKeeper) {
        this.parentMenu = parentMenu;
        this.menuName = menuName;
        this.theCryptKeeper = theCryptKeeper;
    }


    @Override
    public void start() {
        String filePath = getString("Please enter path of file to read: ");
        System.out.println("1");
        theCryptKeeper.setFilePath(filePath);
        System.out.println("2");
        String theFileData = theCryptKeeper.readFile();
        System.out.println("1");
        this.parentMenu.setCustomContent(theFileData);
        this.parentMenu.start();
    }


}