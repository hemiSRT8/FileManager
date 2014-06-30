package ua.khvorov.filemanager.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitListener {
    public static ActionListener exit() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
    }
}
