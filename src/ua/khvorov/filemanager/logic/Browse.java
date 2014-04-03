package ua.khvorov.filemanager.logic;

import ua.khvorov.filemanager.businessexception.BusinessException;

import java.io.File;

public class Browse {
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

        if (filesAmount == 0) {
            System.out.println("No files found");
        }
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

        if (directoriesAmount == 0) {
            System.out.println("No directories found");
        }
    }
}
