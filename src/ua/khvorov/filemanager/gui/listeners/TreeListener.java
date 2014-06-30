package ua.khvorov.filemanager.gui.listeners;

import ua.khvorov.filemanager.gui.constants.Constants;
import ua.khvorov.filemanager.gui.logic.ConstructRealPath;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TreeListener {

    public static TreeSelectionListener treeListener(final JTree tree, final JPanel listPanel) {
        return new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (selectedNode == null) return;

                File path = new File(ConstructRealPath.getPath(selectedNode.getUserObjectPath())); //Path of the file
                File[] folders = path.listFiles(); //Folders
                List<File> files = new ArrayList<File>(); //Files

                listPanel.removeAll(); //Clear left panel from old files to add new ones

                //Adding folders
                if (folders != null) {
                    for (File folder : folders) {
                        if (folder.isDirectory()) {
                            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(folder.getName());
                            newNode.add(new DefaultMutableTreeNode(true));
                            selectedNode.add(newNode);
                            JPanel folderPanel = new JPanel();
                            folderPanel.setLayout(new GridLayout(1, 2));
                            folderPanel.add(new JLabel(folder.getName()));
                            folderPanel.add(new JLabel(Constants.FOLDER));
                            folderPanel.setVisible(true);
                            listPanel.add(folderPanel);
                        } else {
                            files.add(folder);
                        }
                    }
                }

                //Adding files
//                for (File file : files) {
//                    selectedNode.add(new DefaultMutableTreeNode(file.getName()));
//                    listModel.addElement(file.getName());
//                    listModel.addElement(Constants.FILE);
//                }
            }
        };
    }
}
