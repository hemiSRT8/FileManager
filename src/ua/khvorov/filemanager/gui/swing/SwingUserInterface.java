package ua.khvorov.filemanager.gui.swing;

import ua.khvorov.filemanager.gui.constants.Constants;
import ua.khvorov.filemanager.gui.listeners.CalculateFilesListener;
import ua.khvorov.filemanager.gui.listeners.CalculateFoldersListener;
import ua.khvorov.filemanager.gui.listeners.ExitListener;
import ua.khvorov.filemanager.gui.listeners.TreeListener;
import ua.khvorov.filemanager.gui.logic.FillTreeModel;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GridLayout;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SwingUserInterface {

    private JPanel listPanel = new JPanel();
    private JTree tree = new JTree();
    private DefaultListModel<String> listModel = new DefaultListModel<String>();
    private CalculateFilesListener calculateFilesListener = new CalculateFilesListener();
    private CalculateFoldersListener calculateFoldersListener = new CalculateFoldersListener();

    //Constructor
    public SwingUserInterface() {
        constructFrame();
    }

    private void constructFrame() {
        JFrame frame = new JFrame("File manager");

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setIconImage(new ImageIcon("resources\\images\\icon.png").getImage());
        frame.setJMenuBar(constructMenu());

        frame.add(constructMainPanel());

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

        tree.setModel(constructTreeModel());
        tree.addTreeSelectionListener(TreeListener.treeListener(tree, listPanel));

        treePanel.add(new JScrollPane(tree));

        return treePanel;
    }

    private DefaultTreeModel constructTreeModel() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode();

        return FillTreeModel.fillTreeModel(root);
    }

    private JPanel constructListPanel() {

        listPanel.setLayout(new GridLayout(1, 1));
        listPanel.setBackground(Constants.GRAY_BACKGROUND);
        listPanel.setBorder(Constants.BLACK_BORDER);

        JList<String> list = new JList<String>(listModel);
        list.setBackground(Constants.GRAY_BACKGROUND);
        list.setFont(Constants.COMIC_SANS);

        listPanel.add(new JScrollPane(list));

        return listPanel;
    }

    private JMenuBar constructMenu() {
        JMenuBar mainMenu = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem calculateFoldersByPath = new JMenuItem("Calculate folders/sub-folders");
        JMenuItem calculateFilesByPath = new JMenuItem("Calculate files/sub-files");

        calculateFoldersByPath.addActionListener(calculateFoldersListener.calculateFolders(tree));
        calculateFilesByPath.addActionListener(calculateFilesListener.calculateFiles(tree));

        file.add(calculateFoldersByPath);
        file.add(calculateFilesByPath);

        JMenu exitMenu = new JMenu("Exit");
        JMenuItem exitItem = new JMenuItem("Quit from program");

        exitItem.addActionListener(ExitListener.exit());
        exitMenu.add(exitItem);

        mainMenu.add(file);
        mainMenu.add(exitMenu);

        return mainMenu;
    }
}