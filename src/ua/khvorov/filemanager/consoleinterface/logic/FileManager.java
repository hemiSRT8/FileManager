package ua.khvorov.filemanager.consoleinterface.logic;

import ua.khvorov.filemanager.consoleinterface.starter.Starter;
import ua.khvorov.filemanager.consoleinterface.ui.PrintAvailableCatalogs;
import ua.khvorov.filemanager.consoleinterface.ui.PrintCatalogOptions;
import ua.khvorov.filemanager.consoleinterface.validation.Validator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileManager {

    private Switcher switcher = new Switcher();

    public void start() {
        String inputFromUser;
        File file;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PrintAvailableCatalogs.printAvailableCatalogs();

        for (; ; ) {
            try {
                inputFromUser = br.readLine();
                if (inputFromUser.lastIndexOf("\\") != inputFromUser.length() - 1 && inputFromUser.length() < 3) {           //jopokod
                    inputFromUser += "\\";                                                                                   //jopokod
                }                                                                                                            //jopokod
                file = new File(inputFromUser);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (Validator.quit(inputFromUser)) {
                System.out.println("Program finished");
                System.exit(0);
            }

            if (!Validator.pathValidation(file)) {
                System.out.println("Not valid getPath");
                Starter.starter();
            }

            PrintCatalogOptions.doNext(file.getPath());

            try {
                inputFromUser = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (Validator.quit(inputFromUser)) {
                Starter.starter();
            }

            if (!Validator.numberFormatValidation(inputFromUser)) {
                System.out.println("Not valid choice");
                Starter.starter();
            }

            if (Integer.parseInt(inputFromUser) == 7) {
                System.out.println("New getPath :");
            } else {
                switcher.userChoice(inputFromUser, file);
            }
        }
    }
}