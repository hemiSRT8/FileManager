package ua.khvorov.filemanager.gui.logic;

import java.io.File;

public class ConstructRealPath {

    public static String getPath(Object[] objects) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Object obj : objects) {
            if (obj != null) {
                stringBuilder.append(String.valueOf(obj)).append(File.separator);
            }
        }

        return stringBuilder.toString();
    }
}
