import java.awt.*;
import java.awt.event.*;

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

public class LoginAWT extends Frame implements ActionListener {
    Label lblUser, lblPass, lblMsg;
    TextField txtUser, txtPass;
    Button btnLogin, btnClear;
    int attempt = 0;
    final int MAX_ATTEMPTS = 3;

    public LoginAWT() {
        setLayout(new GridLayout(4, 2));

        lblUser = new Label("User Name:");
        lblPass = new Label("Password:");
        lblMsg = new Label();
        txtUser = new TextField(20);
        txtPass = new TextField(20);
        txtPass.setEchoChar('*');
        btnLogin = new Button("Login");
        btnClear = new Button("Clear");

        add(lblUser);
        add(txtUser);
        add(lblPass);
        add(txtPass);
        add(btnLogin);
        add(btnClear);
        add(lblMsg);

        btnLogin.addActionListener(this);
        btnClear.addActionListener(this);

        setTitle("Login Screen");
        setSize(300, 160);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnClear) {
            txtUser.setText("");
            txtPass.setText("");
            lblMsg.setText("");
        } else if (ae.getSource() == btnLogin) {
            try {
                if (attempt < MAX_ATTEMPTS) {
                    String user = txtUser.getText();
                    String pass = txtPass.getText();
                    if (!user.equals(pass)) {
                        throw new InvalidPasswordException("User name and Password are not same");
                    } else {
                        lblMsg.setText("Login Successful");
                        disableInputs();
                    }
                } else {
                    lblMsg.setText("3 attempts over. Exiting...");
                    System.exit(0);
                }
            } catch (InvalidPasswordException ipe) {
                attempt++;
                lblMsg.setText(ipe.getMessage() + " (" + attempt + "/" + MAX_ATTEMPTS + ")");
                if (attempt == MAX_ATTEMPTS) {
                    System.exit(0);
                }
            }
        }
    }

    private void disableInputs() {
        txtUser.setEnabled(false);
        txtPass.setEnabled(false);
        btnLogin.setEnabled(false);
        btnClear.setEnabled(false);
    }

    public static void main(String[] args) {
        new LoginAWT();
    }
}