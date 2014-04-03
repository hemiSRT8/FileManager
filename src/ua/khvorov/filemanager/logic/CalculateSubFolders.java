package ua.khvorov.filemanager.logic;

import java.io.File;

public class CalculateSubFolders {

    private int count;

    public int calculateSubfolders(File file) {
        File[] array = file.listFiles();
        if (array != null) {
            for (File f : array) {
                if (f.isDirectory() && !f.isHidden()) {
                    count += 1;
                    calculateSubfolders(f);
                }
            }
        }
        return count;
    }
}
