package com.jonathan;

import com.jonathan.datamodel.AES256;
import com.jonathan.datamodel.FileHandler;

public class MainMenu extends Menu {

    FileHandler theFileHandler;
    AES256 theAES256;

    public MainMenu(String programName, String menuName) {
        super(programName, menuName);
        this.theFileHandler = new FileHandler();
        this.theAES256 = new AES256();
    }

}
