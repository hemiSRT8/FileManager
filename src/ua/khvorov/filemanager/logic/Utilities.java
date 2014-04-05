package ua.khvorov.filemanager.logic;

import ua.khvorov.filemanager.exceptions.BusinessException;
import ua.khvorov.filemanager.ui.Checker;

import java.io.File;

public class Utilities {
    private Checker checker = new Checker();
    private static int count = 0;

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

    public int calculateSubFolders(File file) {

        File[] array = file.listFiles();
        if (array != null) {
            for (File f : array) {
                if (f.isDirectory() && !f.isHidden()) {
                    count++;
                    calculateSubFolders(f);
                }
            }
        }
        return count;
    }

    public int calculateSubFiles(File file) {

        File[] array = file.listFiles();
        if (array != null) {
            for (File f : array) {
                if (f.isDirectory() && !f.isHidden()) {
                    calculateSubFiles(f);
                } else if (f.isFile() && f.canRead()) {
                    count++;
                }
            }
        }
        return count;
    }

    public void showFiles(File file) {
        File[] files = file.listFiles();
        int filesAmount = 0;

        if (files == null) {
            throw new BusinessException("file is null");
        }

        for (File f : files) {
            if (!f.isDirectory() && f.canRead()) {
                System.out.println(f);
                filesAmount++;
            }
        }
        checker.filesAmountValidation(filesAmount);
    }

    public void showDirectories(File file) {
        File[] directories = file.listFiles();
        int directoriesAmount = 0;

        if (directories == null) {
            throw new BusinessException("file is null");
        }

        if (directories.length > 0) {
            for (File f : directories) {
                if (f.isDirectory() && !f.isHidden()) {
                    System.out.println(f);
                    directoriesAmount++;
                }
            }
        }
        checker.filesAmountValidation(directoriesAmount);
    }
}

