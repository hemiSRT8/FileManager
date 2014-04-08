package ua.khvorov.filemanager.starter;

import ua.khvorov.filemanager.logic.FileManager;

public class Starter {
    public static void main(String[] args) {
        starter();
    }

    public static void starter() {
        new FileManager().start();
    }
}
