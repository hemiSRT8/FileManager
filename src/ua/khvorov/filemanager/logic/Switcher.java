package ua.khvorov.filemanager.logic;

import java.io.File;

import static java.lang.Integer.parseInt;

public class Switcher {
    private Utilities utilities = new Utilities();

    public void userChoice(String inputFromUser, File file) {
        switch (parseInt(inputFromUser)) {
            case 1: {
                utilities.showFolders(file);
                break;
            }
            case 2: {
                utilities.showFiles(file);
                break;
            }
            case 3: {
                utilities.showFolders(file);
                utilities.showFiles(file);
                break;
            }
            case 4: {
                System.out.println("Loading...");
                int folders = utilities.calculateSubFolders(file);
                System.out.println("Folders : " + folders);
                break;
            }
            case 5: {
                System.out.println("Loading...");
                int files = utilities.calculateSubFiles(file);
                System.out.println("Files : " + files);
                break;
            }
            case 6: {
                System.out.println("Loading...");
                int folders = utilities.calculateSubFolders(file);
                int files = utilities.calculateSubFiles(file);
                System.out.println("Folders : " + folders);
                System.out.println("Files : " + files);
                break;
            }
        }

        System.out.println("\n" + "To continue : enter new getPath OR type \"quit\" to exit");
    }
}
