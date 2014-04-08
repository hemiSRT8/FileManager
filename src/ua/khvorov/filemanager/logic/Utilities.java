package ua.khvorov.filemanager.logic;

import ua.khvorov.filemanager.exceptions.BusinessException;
import ua.khvorov.filemanager.validation.Validator;

import java.io.File;

public class Utilities {

    public void printAvailableCatalogs() {
        File[] array = File.listRoots();
        if (array == null) {
            throw new BusinessException("array is null");
        }

        System.out.println("Choose start catalog :");
        for (File catalog : array) {
            System.out.println(catalog.getPath());
        }
        System.out.println("Or enter it manually");
        System.out.println();
        System.out.println("For exit : type \"quit\"");
    }

    public int calculateSubFolders(File file) {
        int count = 0;
        File[] array = file.listFiles();
        if (array != null) {
            for (File f : array) {
                if (f.isDirectory()) {
                    count++;
                    count += calculateSubFolders(f);
                }
            }
        }
        return count;
    }

    public int calculateSubFiles(File file) {
        int count = 0;

        if (file.isFile() && file.canRead()) {
            count++;
        } else {
            File[] array = file.listFiles();

            if (array != null) {
                for (File f : array) {
                    if (f.isDirectory()) {
                        count += calculateSubFiles(f);
                    } else if (f.isFile()) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public void showFiles(File file) {
        File[] array = file.listFiles();
        if (array == null) {
            throw new BusinessException("array is null");
        }

        int filesAmount = 0;

        for (File f : array) {
            if (f.isFile()) {
                System.out.println(f);
                filesAmount++;
            }
        }

        Validator.amountValidation(filesAmount);
    }

    public void showFolders(File file) {
        File[] array = file.listFiles();
        if (array == null) {
            throw new BusinessException("Array is null");
        }

        int amountOfRoots = 0;

        for (File f : array) {
            if (f.isDirectory()) {
                System.out.println(f);
                amountOfRoots++;
            }
        }

        if (amountOfRoots == 0) {
            System.out.println("Roots not found");
        }

    }
}

