package ua.khvorov.filemanager.logic;

import ua.khvorov.filemanager.businessexception.BusinessException;
import ua.khvorov.filemanager.validation.Validator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileManager {

    private Validator validator = new Validator();
    private Switcher switcher = new Switcher();

    public void start() {
        String inputFromUser;
        File file;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ChooseStartCatalog.printAvailiableCatalogs();

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

            validator.quitOrNot(inputFromUser);
            validator.pathValidation(file);


            InCatalog.doNext(file.getPath());

            try {
                inputFromUser = br.readLine();
            } catch (IOException e) {
                throw new BusinessException(e);
            }

            validator.quitOrNot(inputFromUser);
            validator.numberFormatValidation(inputFromUser);

            switcher.userChoice(inputFromUser, file);
        }
    }
}