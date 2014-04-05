package ua.khvorov.filemanager.ui;

import ua.khvorov.filemanager.logic.Utilities;

import java.io.File;

import static java.lang.Integer.parseInt;

public class Switcher {
    private Utilities utilities = new Utilities();

    public void userChoice(String inputFromUser, File file) {
        switch (parseInt(inputFromUser)) {
            case 1: {
                utilities.showDirectories(file);
                break;
            }
            case 2: {
                utilities.showFiles(file);
                break;
            }
            case 3: {
                utilities.showDirectories(file);
                utilities.showFiles(file);
                break;
            }
            case 4: {
                System.out.println("Folders : " + utilities.calculateSubFolders(file));
                break;
            }
            case 5: {
                System.out.println("Files : " + (utilities.calculateSubFiles(file)));
                break;
            }
            case 6: {
                System.out.println("Folders : " + utilities.calculateSubFolders(file));
                System.out.println("Files : " + utilities.calculateSubFiles(file));
                break;
            }
        }
        System.out.println("\n" + "To continue : enter new path OR type \"quit\" to exit");
    }
}
