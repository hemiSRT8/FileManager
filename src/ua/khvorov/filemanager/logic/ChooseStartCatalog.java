package ua.khvorov.filemanager.logic;

import java.io.File;

public class ChooseStartCatalog {
    public static void printAvailiableCatalogs() {
        System.out.println("Choose start catalog :");
        File[] arrayRoots = File.listRoots();
        for (File root : arrayRoots) {
            if (root.canExecute()) {
                System.out.println(root.getPath());
            }
        }
        System.out.println("Or type \"quit\" to exit from program");
    }
}
