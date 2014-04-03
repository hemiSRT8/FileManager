package ua.khvorov.filemanager.logic;

import java.io.File;

public class CalculateSubFiles {

    private int count;

    public int calculateSubFiles(File file) {
        File[] array = file.listFiles();
        if (array != null) {
            for (File f : array) {
                if (!f.isDirectory() && f.canRead()) {
                    count += 1;
                    calculateSubFiles(f);
                }
            }
        }
        return count;
    }
}
