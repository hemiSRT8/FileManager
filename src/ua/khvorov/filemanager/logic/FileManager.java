package ua.khvorov.filemanager.logic;

import ua.khvorov.filemanager.exceptions.BusinessException;
import ua.khvorov.filemanager.starter.Starter;
import ua.khvorov.filemanager.userinterface.cui.InCatalog;
import ua.khvorov.filemanager.validation.Validator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileManager {

    private Switcher switcher = new Switcher();
    private Utilities utilities = new Utilities();

    public void start() {
        String inputFromUser;
        File file;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        utilities.printAvailableCatalogs();

        for (; ; ) {
            try {
                inputFromUser = br.readLine();
                if (inputFromUser.lastIndexOf("\\") != inputFromUser.length() - 1 && inputFromUser.length() < 3) {           //jopokod
                    inputFromUser += "\\";                                                                                   //jopokod
                }                                                                                                            //jopokod
                file = new File(inputFromUser);
            } catch (IOException e) {
                throw new BusinessException(e);
            }

            if (Validator.quit(inputFromUser)) {
                System.out.println("Program finished");
                System.exit(0);
            }

            if (!Validator.pathValidation(file)) {
                System.out.println("Not valid path");
                Starter.starter();
            }

            InCatalog.doNext(file.getPath());

            try {
                inputFromUser = br.readLine();
            } catch (IOException e) {
                throw new BusinessException(e);
            }

            if (Validator.quit(inputFromUser)) {
                Starter.starter();
            }

            if (!Validator.numberFormatValidation(inputFromUser)) {
                System.out.println("Not valid choice");
                Starter.starter();
            }

            if (Integer.parseInt(inputFromUser) == 7) {
                System.out.println("New path :");
            } else {
                switcher.userChoice(inputFromUser, file);
            }
        }
    }
}