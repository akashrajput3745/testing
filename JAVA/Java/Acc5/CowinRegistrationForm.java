import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CowinRegistrationForm extends JFrame implements ActionListener {
    // Components
    JTextField adharField, birthYearField, mobileField;
    JComboBox<String> birthYearBox, hospitalBox;
    JRadioButton age18, age45;
    ButtonGroup ageGroup;
    JRadioButton covishield, covaxin, sputnik;
    ButtonGroup vaccineGroup;
    JRadioButton morning, afternoon, evening;
    ButtonGroup slotGroup;
    JButton submit;

    public CowinRegistrationForm() {
        setTitle("Co-WIN Registration");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("Co-WIN Registration");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBounds(120, 20, 250, 20);
        add(title);

        JLabel adharLabel = new JLabel("AdharCard No. :");
        adharLabel.setBounds(50, 60, 100, 20);
        add(adharLabel);
        adharField = new JTextField();
        adharField.setBounds(180, 60, 180, 20);
        add(adharField);

        JLabel birthYearLabel = new JLabel("Birth Year :");
        birthYearLabel.setBounds(50, 90, 100, 20);
        add(birthYearLabel);

        String[] years = {"Select", "1975", "1980", "1985", "1990", "1995", "2000"};
        birthYearBox = new JComboBox<>(years);
        birthYearBox.setBounds(180, 90, 100, 20);
        add(birthYearBox);

        JLabel mobileLabel = new JLabel("Mobile No. :");
        mobileLabel.setBounds(50, 120, 100, 20);
        add(mobileLabel);
        mobileField = new JTextField();
        mobileField.setBounds(180, 120, 180, 20);
        add(mobileField);

        JLabel ageLabel = new JLabel("Age Group :");
        ageLabel.setBounds(50, 150, 100, 20);
        add(ageLabel);
        age18 = new JRadioButton("18 & above");
        age45 = new JRadioButton("45 & above");
        age18.setBounds(180, 150, 100, 20);
        age45.setBounds(280, 150, 100, 20);
        ageGroup = new ButtonGroup();
        ageGroup.add(age18);
        ageGroup.add(age45);
        add(age18);
        add(age45);

        JLabel hospitalLabel = new JLabel("Select Hospital :");
        hospitalLabel.setBounds(50, 180, 120, 20);
        add(hospitalLabel);
        String[] hospitals = {"Select", "Apollo", "Fortis", "AIIMS"};
        hospitalBox = new JComboBox<>(hospitals);
        hospitalBox.setBounds(180, 180, 120, 20);
        add(hospitalBox);

        JLabel vaccineLabel = new JLabel("Vaccines :");
        vaccineLabel.setBounds(50, 210, 100, 20);
        add(vaccineLabel);
        covishield = new JRadioButton("Covishield");
        covaxin = new JRadioButton("Covaxin");
        sputnik = new JRadioButton("Sputnik V.");
        covishield.setBounds(180, 210, 100, 20);
        covaxin.setBounds(280, 210, 80, 20);
        sputnik.setBounds(370, 210, 90, 20);
        vaccineGroup = new ButtonGroup();
        vaccineGroup.add(covishield);
        vaccineGroup.add(covaxin);
        vaccineGroup.add(sputnik);
        add(covishield);
        add(covaxin);
        add(sputnik);

        JLabel slotLabel = new JLabel("Time Slot :");
        slotLabel.setBounds(50, 240, 100, 20);
        add(slotLabel);
        morning = new JRadioButton("Morning");
        afternoon = new JRadioButton("Afternoon");
        evening = new JRadioButton("Evening");
        morning.setBounds(180, 240, 80, 20);
        afternoon.setBounds(260, 240, 90, 20);
        evening.setBounds(350, 240, 80, 20);
        slotGroup = new ButtonGroup();
        slotGroup.add(morning);
        slotGroup.add(afternoon);
        slotGroup.add(evening);
        add(morning);
        add(afternoon);
        add(evening);

        submit = new JButton("Submit");
        submit.setBounds(150, 300, 120, 30);
        submit.addActionListener(this);
        add(submit);
    }

    public void actionPerformed(ActionEvent e) {
        String adhar = adharField.getText();
        String birthYear = birthYearBox.getSelectedItem().toString();
        String mobile = mobileField.getText();
        String hospital = hospitalBox.getSelectedItem().toString();

        // Validation
        boolean valid = !adhar.isEmpty() && adhar.length() == 12 &&
                        !mobile.isEmpty() && mobile.length() == 10 &&
                        !birthYear.equals("Select") && !hospital.equals("Select") &&
                        (age18.isSelected() || age45.isSelected()) &&
                        (covishield.isSelected() || covaxin.isSelected() || sputnik.isSelected()) &&
                        (morning.isSelected() || afternoon.isSelected() || evening.isSelected());

        if(valid) {
            JOptionPane.showMessageDialog(this, "Registration Successful");
        } else {
            JOptionPane.showMessageDialog(this, "Registration Failed");
        }
    }

    public static void main(String[] args) {
        new CowinRegistrationForm().setVisible(true);
    }
}