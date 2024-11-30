
// RegisterView.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame {
    private JTextField fnameField = new JTextField(20);
    private JTextField lnameField = new JTextField(20);
    private JTextField addressField = new JTextField(20);
    private JTextField phoneField = new JTextField(20);
    private JTextField emailField = new JTextField(20);
    private JTextField collegeNameField = new JTextField(20);
    private JTextField semesterField = new JTextField(5);
    private JTextField rollNoField = new JTextField(10);
    private JButton submitButton = new JButton("Register");

    public RegisterView() {
        JPanel panel = new JPanel(new GridLayout(9, 2));

        panel.add(new JLabel("First Name:"));
        panel.add(fnameField);

        panel.add(new JLabel("Last Name:"));
        panel.add(lnameField);

        panel.add(new JLabel("Address:"));
        panel.add(addressField);

        panel.add(new JLabel("Phone:"));
        panel.add(phoneField);

        panel.add(new JLabel("Email:"));
        panel.add(emailField);

        panel.add(new JLabel("College Name:"));
        panel.add(collegeNameField);

        panel.add(new JLabel("Semester:"));
        panel.add(semesterField);

        panel.add(new JLabel("Roll No:"));
        panel.add(rollNoField);

        panel.add(submitButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }

    public String getFname() {
        return fnameField.getText();
    }

    public String getLname() {
        return lnameField.getText();
    }

    public String getAddress() {
        return addressField.getText();
    }

    public String getPhone() {
        return phoneField.getText();
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getCollegeName() {
        return collegeNameField.getText();
    }

    public int getSemester() {
        return Integer.parseInt(semesterField.getText());
    }

    public String getRollNo() {
        return rollNoField.getText();
    }

    public void addSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
