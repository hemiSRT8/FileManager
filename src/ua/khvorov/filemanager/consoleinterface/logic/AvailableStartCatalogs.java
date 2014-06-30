package ua.khvorov.filemanager.consoleinterface.logic;

import java.io.File;

public class AvailableStartCatalogs {
    public static File[] availableStartCatalogs() {
        File[] array = File.listRoots();
        if (array == null) {
            throw new NullPointerException();
        } else {
            return array;
        }
    }
}
