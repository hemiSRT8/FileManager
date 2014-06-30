package ua.khvorov.filemanager.gui.listeners;

import ua.khvorov.filemanager.gui.logic.ConstructRealPath;
import ua.khvorov.filemanager.logic.Utilities;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CalculateFilesListener {

    public ActionListener calculateFiles(final JTree tree) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (selectedNode == null) return;

                JOptionPane.showMessageDialog(null, "Files : "
                                + Utilities.calculateSubFiles(new File(ConstructRealPath.getPath(selectedNode.getUserObjectPath()))),
                        "",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        };
    }
}
