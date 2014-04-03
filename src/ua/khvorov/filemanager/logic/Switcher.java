package ua.khvorov.filemanager.logic;

import java.io.File;

import static java.lang.Integer.parseInt;

public class Switcher {
    private Browse browse = new Browse();
    private CalculateSubFiles calculateSubFiles = new CalculateSubFiles();
    private CalculateSubFolders calculateSubFolders = new CalculateSubFolders();

    public void userChoice(String inputFromUser, File file) {
        switch (parseInt(inputFromUser)) {
            case 1: {
                browse.showDirectories(file);
                break;
            }
            case 2: {
                browse.showFiles(file);
                break;
            }
            case 3: {
                browse.showDirectories(file);
                browse.showFiles(file);
                break;
            }
            case 4: {
                System.out.println("Folders : " + calculateSubFolders.calculateSubfolders(file));
                break;
            }
            case 5: {
                System.out.println("Files : " + (calculateSubFiles.calculateSubFiles(file)));
                break;
            }
            case 6: {
                System.out.println("Folders : " + calculateSubFolders.calculateSubfolders(file));
                System.out.println("Files : " + calculateSubFiles.calculateSubFiles(file));
                break;
            }
        }
        System.out.println("\n" + "To continue : enter new path OR type \"quit\" to exit");
    }
}
