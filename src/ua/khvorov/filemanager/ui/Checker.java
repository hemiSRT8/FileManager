package ua.khvorov.filemanager.ui;

import ua.khvorov.filemanager.starter.Starter;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {
    private static final Pattern PATTERN = Pattern.compile("[1-7]");

    public void quitOrNot(String str) {
        if (str.equalsIgnoreCase("quit")) {
            System.exit(0);
        }
    }

    public void pathValidation(File file) {
        if (!file.exists() || !file.isDirectory()) {
            System.out.println("Not valid path");
            Starter.starter();
        }
    }

    public void numberFormatValidation(String str) {
        Matcher matcher = PATTERN.matcher(str);
        if (!matcher.matches()) {
            System.out.println("Not valid choice");
            Starter.starter();
        }
    }

    public void filesAmountValidation(int filesAmount) {
        if (filesAmount == 0) {
            System.out.println("Nothing was found");
        }
    }
}
