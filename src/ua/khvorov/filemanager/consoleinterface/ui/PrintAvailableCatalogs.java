package ua.khvorov.filemanager.consoleinterface.ui;

import ua.khvorov.filemanager.consoleinterface.logic.AvailableStartCatalogs;

import java.io.File;

public class PrintAvailableCatalogs {

    public static void printAvailableCatalogs() {
        File[] array = AvailableStartCatalogs.availableStartCatalogs();

        System.out.println("Choose start catalog :");

        for (File catalog : array) {
            System.out.println(catalog.getPath());
        }

        System.out.println("Or enter it manually");
        System.out.println();
        System.out.println("For exit : type \"quit\"");
    }
}
