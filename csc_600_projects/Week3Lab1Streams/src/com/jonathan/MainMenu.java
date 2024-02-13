package com.jonathan;

import com.jonathan.datamodel.AES256;
import com.jonathan.datamodel.CryptKeeper;

import java.util.logging.FileHandler;

public class MainMenu extends Menu {


    protected CryptKeeper theCryptKeeper;

    public MainMenu() {
    }

    public MainMenu(String programName, String menuName, CryptKeeper theCryptKeeper) {
        super(programName, menuName);
        this.theCryptKeeper = theCryptKeeper;

    }

    @Override
    public void start() {
        makeASelection("Please Make a Selection");
    }


}
