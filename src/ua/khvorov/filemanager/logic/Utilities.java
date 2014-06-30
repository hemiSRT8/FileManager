package ua.khvorov.filemanager.logic;

import java.io.File;

public class Utilities {

    public static int calculateSubFolders(File file) {
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

    public static int calculateSubFiles(File file) {
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
}

