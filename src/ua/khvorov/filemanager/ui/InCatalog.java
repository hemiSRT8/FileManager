package ua.khvorov.filemanager.ui;

public class InCatalog {
    public static void doNext(String path) {
        System.out.println("Current catalog is " + path);
        System.out.println("1)View folders");
        System.out.println("2)View files");
        System.out.println("3)View all folders / all files in catalog");
        System.out.println("4)Calculate folders(and subfolders) by this path");
        System.out.println("5)Calculate files (and subfiles) by this path");
        System.out.println("6)Calculate all folders / all files by this path");
        System.out.println("7)Change path");
        System.out.println("\n" + "Or type \"quit\" to exit from program");
    }
}

