import javax.swing.*;
import java.awt.*;

public class MenuBarExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MenuBar, Menu and MenuItem Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create MenuBar
        JMenuBar menuBar = new JMenuBar();

        // Create File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");

        // Create Save As Submenu
        JMenu saveAsMenu = new JMenu("Save As");
        JMenuItem pptItem = new JMenuItem(".ppt");
        JMenuItem docItem = new JMenuItem(".doc");
        JMenuItem pdfItem = new JMenuItem(".pdf");
        saveAsMenu.add(pptItem);
        saveAsMenu.add(docItem);
        saveAsMenu.add(pdfItem);

        // Add items to File Menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsMenu);

        // Add File Menu to MenuBar
        menuBar.add(fileMenu);

        // Set MenuBar to Frame
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }
}