package ua.khvorov.filemanager.logic;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static junit.framework.Assert.assertTrue;

public class UtilitiesTest {

    private Utilities utilities = new Utilities();

    @Test
    public void testCalculateSubFolders() {
        File file = new File("TestResources");
        assertTrue(utilities.calculateSubFolders(file) == 3);

        File tempDir = new File("TestResources\\TempDirectory");
        tempDir.mkdir();
        assertTrue(utilities.calculateSubFolders(file) == 4);

        tempDir.delete();
        assertTrue(utilities.calculateSubFolders(file) == 3);
    }

    @Test
    public void testCalculateSubFiles() {
        File file = new File("TestResources");
        assertTrue(utilities.calculateSubFiles(file) == 2);

        File tempFile = new File("TestResources\\TempFile");
        try {
            tempFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(utilities.calculateSubFiles(file) == 3);

        tempFile.delete();
        assertTrue(utilities.calculateSubFiles(file) == 2);
    }
}
