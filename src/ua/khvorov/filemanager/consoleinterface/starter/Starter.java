package ua.khvorov.filemanager.consoleinterface.starter;

import ua.khvorov.filemanager.consoleinterface.logic.FileManager;

public class Starter {
    public static void main(String[] args) {
        starter();
    }

    public static void starter() {
        new FileManager().start();
    }
}
