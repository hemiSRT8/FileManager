package ua.khvorov.filemanager.gui.logic;

import ua.khvorov.filemanager.gui.constants.Constants;
import ua.khvorov.filemanager.logic.Utilities;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SwingInterface {
    private DefaultListModel listModel = new DefaultListModel();
    private JTree tree = new JTree();
    private Listeners listeners = new Listeners();

    //Constructor
    public SwingInterface() {
        constructFrame();
    }

    private void constructFrame() {
        JFrame frame = new JFrame("File manager");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setIconImage(new ImageIcon("Resources\\Images\\Icon.png").getImage());
        frame.setJMenuBar(constructMenu());

        frame.add(constructMainPanel());
        ;

        frame.pack();
        frame.setSize(900, 600);

        //Window`s start position : center of display
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(
                screenSize.width / 2 - (frame.getWidth() / 2),
                screenSize.height / 2 - (frame.getHeight() / 2));
    }

    private JPanel constructMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2));

        mainPanel.add(constructFileTreePanel());
        mainPanel.add(constructListPanel());

        return mainPanel;
    }

    private JPanel constructFileTreePanel() {
        JPanel treePanel = new JPanel();
        treePanel.setLayout(new GridLayout(1, 1));
        treePanel.setBorder(Constants.BLACK_BORDER);

        FilesTree filesTree = new FilesTree();
        filesTree.constructTree();

        treePanel.add(new JScrollPane(tree));

        return treePanel;
    }

    private JPanel constructListPanel() {
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(1, 1));
        listPanel.setBackground(Constants.GRAY_BACKGROUND);
        listPanel.setBorder(Constants.BLACK_BORDER);

        JList list = new JList(listModel);
        list.setBackground(Constants.GRAY_BACKGROUND);
        list.setFont(Constants.COMIC_SANS);

        listPanel.add(new JScrollPane(list));

        return listPanel;
    }

    private JMenuBar constructMenu() {
        JMenuBar mainMenu = new JMenuBar();

        JMenu file = new JMenu("File");

        JMenuItem calculateFoldersByPath = new JMenuItem("Calculate folders/subfolders");
        JMenuItem calculateFilesByPath = new JMenuItem("Calculate files/subfiles");

        calculateFoldersByPath.addActionListener(listeners.calculateFolders(tree));
        calculateFilesByPath.addActionListener(listeners.calculateFiles(tree));

        file.add(calculateFoldersByPath);
        file.add(calculateFilesByPath);

        mainMenu.add(file);

        return mainMenu;
    }

    final class FilesTree {
        private void constructTree() {
            tree.setModel(constructTreeModel());
            tree.addTreeSelectionListener(listeners.treeListener(tree, listModel));
        }

        private TreeModel constructTreeModel() {
            DefaultMutableTreeNode root = new DefaultMutableTreeNode();

            File[] catalogs = File.listRoots();

            for (File f : catalogs) {
                root.add(new DefaultMutableTreeNode(f));
            }

            return new DefaultTreeModel(root);
        }
    }

    final class Listeners {

        private Utilities utilities = new Utilities();

        private TreeSelectionListener treeListener(final JTree tree, final DefaultListModel listModel) {
            return new TreeSelectionListener() {
                public void valueChanged(TreeSelectionEvent e) {
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                    if (selectedNode == null) return;

                    File path = new File(ConstructRealPath.getPath(selectedNode.getUserObjectPath())); //Path of the file
                    File[] folders = path.listFiles(); //Folders
                    List<File> files = new ArrayList<File>(); //Files

                    listModel.removeAllElements(); //Clear left panel from old files to add new ones

                    //Adding folders
                    if (folders != null) {
                        for (File folder : folders) {
                            if (folder.isDirectory()) {
                                selectedNode.add(new DefaultMutableTreeNode(folder.getName()));
                                listModel.addElement(folder.getName());
                                listModel.addElement(Constants.FOLDER);
                            } else {
                                files.add(folder);
                            }
                        }
                    }

                    //Adding files
                    for (File file : files) {
                        selectedNode.add(new DefaultMutableTreeNode(file.getName()));
                        listModel.addElement(file.getName());
                        listModel.addElement(Constants.FILE);
                    }
                }
            };
        }


        private ActionListener calculateFolders(final JTree tree) {
            return new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                    if (selectedNode == null) return;

                    JOptionPane.showMessageDialog(null, "Folders : "
                                    + utilities.calculateSubFolders(new File(ConstructRealPath.getPath(selectedNode.getUserObjectPath()))),
                            "",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            };
        }

        private ActionListener calculateFiles(final JTree tree) {
            return new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                    if (selectedNode == null) return;

                    JOptionPane.showMessageDialog(null, "Files : "
                                    + utilities.calculateSubFiles(new File(ConstructRealPath.getPath(selectedNode.getUserObjectPath()))),
                            "",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            };
        }
    }
}