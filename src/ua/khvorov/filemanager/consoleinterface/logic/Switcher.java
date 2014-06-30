package ua.khvorov.filemanager.consoleinterface.logic;

import ua.khvorov.filemanager.logic.Utilities;

import java.io.File;

import static java.lang.Integer.parseInt;

public class Switcher {

    public void userChoice(String inputFromUser, File file) {
        switch (parseInt(inputFromUser)) {
            case 1: {
                AvailableFiles.availableRoots(file);
                break;
            }
            case 2: {
                AvailableFiles.availableFiles(file);
                break;
            }
            case 3: {
                AvailableFiles.availableFiles(file);
                AvailableFiles.availableRoots(file);
                break;
            }
            case 4: {
                System.out.println("Loading...");
                int folders = Utilities.calculateSubFolders(file);
                System.out.println("Folders : " + folders);
                break;
            }
            case 5: {
                System.out.println("Loading...");
                int files = Utilities.calculateSubFiles(file);
                System.out.println("Files : " + files);
                break;
            }
            case 6: {
                System.out.println("Loading...");
                int folders = Utilities.calculateSubFolders(file);
                int files = Utilities.calculateSubFiles(file);
                System.out.println("Folders : " + folders);
                System.out.println("Files : " + files);
                break;
            }
        }

        System.out.println("\n" + "To continue : enter new getPath OR type \"quit\" to exit");
    }
}
