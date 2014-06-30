package ua.khvorov.filemanager.gui.constants;

import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;

public class Constants {
    public static final ImageIcon FOLDER = new ImageIcon("resources\\images\\folder.png");
    public static final ImageIcon FILE = new ImageIcon("resources\\images\\file.png");
    public static final Color GRAY_BACKGROUND = new Color(234, 227, 231);
    public static final Font COMIC_SANS = new Font("Comic Sans MS", Font.BOLD, 15);
    public static final Border BLACK_BORDER = BorderFactory.createLineBorder(Color.BLACK);
}
