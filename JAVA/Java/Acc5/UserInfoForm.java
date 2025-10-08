import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserInfoForm extends JFrame {
    JTextField nameField;
    JRadioButton fy, sy, ty;
    JCheckBox music, sports, travelling;
    JComboBox<String> fontBox;
    JComboBox<String> sizeBox;
    JCheckBox bold, italic, underline;
    JTextField resultField;

    public UserInfoForm() {
        setTitle("User Form");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Top Panel for Name
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Your Name :"));
        nameField = new JTextField(15);
        topPanel.add(nameField);

        // Main inputs Panel (Class, Hobbies, Font, Style)
        JPanel centerPanel = new JPanel(new GridLayout(1, 4, 10, 10));

        // Class
        JPanel classPanel = new JPanel(new GridLayout(4, 1));
        classPanel.add(new JLabel("Your Class"));
        ButtonGroup bg = new ButtonGroup();
        fy = new JRadioButton("FY");
        sy = new JRadioButton("SY");
        ty = new JRadioButton("TY");
        bg.add(fy);  classPanel.add(fy);
        bg.add(sy);  classPanel.add(sy);
        bg.add(ty);  classPanel.add(ty);

        // Hobbies
        JPanel hobbyPanel = new JPanel(new GridLayout(4, 1));
        hobbyPanel.add(new JLabel("Your Hobbies"));
        music = new JCheckBox("Music");
        sports = new JCheckBox("Sports");
        travelling = new JCheckBox("Travelling");
        hobbyPanel.add(music);
        hobbyPanel.add(sports);
        hobbyPanel.add(travelling);

        // Font and size
        JPanel fontPanel = new JPanel(new GridLayout(4, 2));
        fontPanel.add(new JLabel("Font"));
        fontBox = new JComboBox<>(new String[]{"Arial", "Times New Roman", "Verdana"});
        fontPanel.add(fontBox);
        fontPanel.add(new JLabel("Size"));
        sizeBox = new JComboBox<>(new String[]{"8", "10", "12", "14", "16"});
        fontPanel.add(sizeBox);

        // Style
        JPanel stylePanel = new JPanel(new GridLayout(4, 1));
        stylePanel.add(new JLabel("Style"));
        bold = new JCheckBox("Bold");
        italic = new JCheckBox("Italic");
        underline = new JCheckBox("Underline");
        stylePanel.add(bold);
        stylePanel.add(italic);
        stylePanel.add(underline);

        // Add panels to centerPanel
        centerPanel.add(classPanel);
        centerPanel.add(hobbyPanel);
        centerPanel.add(fontPanel);
        centerPanel.add(stylePanel);

        // Bottom Panel for Result
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton showBtn = new JButton("Show");
        resultField = new JTextField();
        bottomPanel.add(showBtn, BorderLayout.WEST);
        bottomPanel.add(resultField, BorderLayout.CENTER);

        // Add all to Frame
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Button Action
        showBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String cls = fy.isSelected() ? "FY" : sy.isSelected() ? "SY" : ty.isSelected() ? "TY" : "";
                StringBuilder hobbies = new StringBuilder();
                if (music.isSelected()) hobbies.append("Music ");
                if (sports.isSelected()) hobbies.append("Sports ");
                if (travelling.isSelected()) hobbies.append("Travelling ");
                resultField.setText("Name : " + name + "   Class : " + cls + "   Hobbies : " + hobbies);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserInfoForm().setVisible(true));
    }
}