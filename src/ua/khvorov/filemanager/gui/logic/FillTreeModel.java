package ua.khvorov.filemanager.gui.logic;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.io.File;

public class FillTreeModel {
    public static DefaultTreeModel fillTreeModel(DefaultMutableTreeNode root) {
        File[] catalogs = File.listRoots();

        for (File f : catalogs) {
            root.add(new DefaultMutableTreeNode(f));
        }

        return new DefaultTreeModel(root);
    }
}
