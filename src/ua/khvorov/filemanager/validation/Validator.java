package ua.khvorov.filemanager.validation;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern PATTERN = Pattern.compile("[1-7]");

    public static boolean quit(String str) {
        return str.equalsIgnoreCase("quit");
    }

    public static boolean pathValidation(File file) {
        return file.exists() && file.isDirectory();
    }

    public static boolean numberFormatValidation(String str) {
        Matcher matcher = PATTERN.matcher(str);
        return matcher.matches();
    }

    public static boolean amountValidation(int amount) {
        return amount == 0;
    }
}
