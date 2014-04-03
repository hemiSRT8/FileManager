package ua.khvorov.filemanager.validation;

import ua.khvorov.filemanager.starter.Starter;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern PATTERN = Pattern.compile("[1-6]");

    public void quitOrNot(String str) {
        if (str.equalsIgnoreCase("quit")) {
            System.exit(0);
        }
    }

    public void pathValidation(File file) {
        if (!file.exists()) {
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
}
