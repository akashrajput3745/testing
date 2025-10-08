import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField displayField;
    private JButton[] digitButtons;
    private JButton addButton, subButton, mulButton, modButton, equalButton, clearButton;
    private String operator;
    private double operand1, operand2;
    private boolean startNewNumber;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        displayField = new JTextField();
        displayField.setFont(new Font("SansSerif", Font.BOLD, 24));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setEditable(false);
        add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        // Digit buttons 0-9
        digitButtons = new JButton[10];
        for (int i = 1; i <= 9; i++) {
            digitButtons[i] = new JButton(String.valueOf(i));
            digitButtons[i].setFont(new Font("SansSerif", Font.BOLD, 20));
            digitButtons[i].addActionListener(this);
            buttonPanel.add(digitButtons[i]);
        }

        // Add operator buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        modButton = new JButton("%");

        addButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        subButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        mulButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        modButton.setFont(new Font("SansSerif", Font.BOLD, 20));

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        modButton.addActionListener(this);

        // Add digit 0 button
        digitButtons[0] = new JButton("0");
        digitButtons[0].setFont(new Font("SansSerif", Font.BOLD, 20));
        digitButtons[0].addActionListener(this);

        equalButton = new JButton("=");
        equalButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        equalButton.addActionListener(this);

        clearButton = new JButton("C"); // Clear button
        clearButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        clearButton.addActionListener(this);

        // Add buttons in order to form a 4x4 grid
        buttonPanel.add(digitButtons[0]);
        buttonPanel.add(clearButton);
        buttonPanel.add(equalButton);
        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(modButton);

        // Since 4x4 = 16 slots, and we added fewer buttons, add empty labels to fill gap
        int buttonsAdded = 9 + 1 + 1 + 1 + 4; // digits 1-9 + zero + clear + equal + 4 ops = 16
        // but we already added in order; buttonPanel should have 16 buttons, but last might be empty
        // To maintain layout, we can add empty buttons or blank labels but not strictly necessary here.

        add(buttonPanel, BorderLayout.CENTER);

        operator = "";
        startNewNumber = true;

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if ("0123456789".contains(cmd)) {
            if (startNewNumber) {
                displayField.setText(cmd);
                startNewNumber = false;
            } else {
                displayField.setText(displayField.getText() + cmd);
            }
        } else if ("+-*%".contains(cmd)) {
            try {
                operand1 = Double.parseDouble(displayField.getText());
                operator = cmd;
                startNewNumber = true;
            } catch (NumberFormatException ex) {
                displayField.setText("Error");
            }
        } else if ("=".equals(cmd)) {
            if (!operator.isEmpty()) {
                try {
                    operand2 = Double.parseDouble(displayField.getText());
                    double result = 0;
                    switch (operator) {
                        case "+":
                            result = operand1 + operand2;
                            break;
                        case "-":
                            result = operand1 - operand2;
                            break;
                        case "*":
                            result = operand1 * operand2;
                            break;
                        case "%":
                            if (operand2 == 0) {
                                displayField.setText("Error: /0");
                                operator = "";
                                return;
                            }
                            result = operand1 % operand2;
                            break;
                    }
                    displayField.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    displayField.setText("Error");
                }
                operator = "";
                startNewNumber = true;
            }
        } else if ("C".equals(cmd)) {
            displayField.setText("");
            operator = "";
            startNewNumber = true;
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}