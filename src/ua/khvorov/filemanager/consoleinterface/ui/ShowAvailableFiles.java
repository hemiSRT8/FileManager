package ua.khvorov.filemanager.consoleinterface.ui;

import ua.khvorov.filemanager.consoleinterface.validation.Validator;

import java.io.File;

public class ShowAvailableFiles {
    public static void showFiles(File[] array) {
        int filesAmount = 0;

        for (File f : array) {
            if (f.isFile()) {
                System.out.println(f);
                filesAmount++;
            }
        }
        if (Validator.amountValidation(filesAmount)) {
            System.out.println("Files not found");
        }
    }

    public static void showFolders(File[] array) {
        int amountOfRoots = 0;

        for (File f : array) {
            if (f.isDirectory()) {
                System.out.println(f);
                amountOfRoots++;
            }
        }

        if (Validator.amountValidation(amountOfRoots)) {
            System.out.println("Files not found");
        }
    }
}
