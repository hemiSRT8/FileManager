package ua.khvorov.filemanager.consoleinterface.logic;

import ua.khvorov.filemanager.consoleinterface.ui.ShowAvailableFiles;

import java.io.File;

public class AvailableFiles {
    public static void availableFiles(File file) {
        File[] array = file.listFiles();
        if (array == null) {
            throw new NullPointerException();
        } else {
            ShowAvailableFiles.showFiles(array);
        }
    }

    public static void availableRoots(File file) {
        File[] array = file.listFiles();
        if (array == null) {
            throw new NullPointerException();
        } else {
            ShowAvailableFiles.showFolders(array);
        }
    }

}
