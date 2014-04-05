package ua.khvorov.filemanager.ui;

import ua.khvorov.filemanager.exceptions.BusinessException;
import ua.khvorov.filemanager.logic.Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileManager {

    private Checker checker = new Checker();
    private Switcher switcher = new Switcher();

    public void start() {
        String inputFromUser;
        File file;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Utilities.printAvailiableCatalogs();

        while (true) {
            try {
                inputFromUser = br.readLine();
                if (inputFromUser.lastIndexOf("\\") != inputFromUser.length() - 1 && inputFromUser.length() < 3) {           //jopokod
                    inputFromUser += "\\";                                                                                   //jopokod
                }                                                                                                            //jopokod
                file = new File(inputFromUser);
            } catch (IOException e) {
                throw new BusinessException(e);
            }

            checker.quitOrNot(inputFromUser);
            checker.pathValidation(file);


            InCatalog.doNext(file.getPath());

            try {
                inputFromUser = br.readLine();
            } catch (IOException e) {
                throw new BusinessException(e);
            }

            checker.quitOrNot(inputFromUser);
            checker.numberFormatValidation(inputFromUser);

            if (Integer.parseInt(inputFromUser) == 7) {
                System.out.println("New path :");
            } else {
                switcher.userChoice(inputFromUser, file);
            }
        }
    }
}