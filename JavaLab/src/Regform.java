import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class Regform extends JFrame implements ActionListener {
    // components
    private Container container;
    private JLabel title, fnamelabel, lnamelabel, doblabel, genderlabel, phonelabel, emaillabel, addlabel, edulabel;
    private JTextField fnamefield, lnamefield, emailfield;
    private JFormattedTextField phonefield;
    private JFormattedTextField dobfield;
    private JTextArea addfield;
    private ButtonGroup genderGroup;
    private JRadioButton male, female;
    private JCheckBox termsCheckBox;
    private JButton submitButton, resetButton;
    private JComboBox<String> educationComboBox;

    private String[] edulevels = { "BCA", "BIT", "BCSIT" };

    public Regform() {
        setTitle("Registration form"); // title
        setBounds(300, 50, 600, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        container = getContentPane();
        container.setLayout(null);

        title = new JLabel("Registration"); // registration title label
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        title.setBounds(200, 20, 300, 30);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        container.add(title);

        fnamelabel = new JLabel("First Name"); // firstnamelabel
        fnamelabel.setBounds(100, 80, 100, 20);
        container.add(fnamelabel);
        fnamefield = new JTextField(); // fnametextfield
        fnamefield.setBounds(200, 80, 190, 20);
        container.add(fnamefield);

        lnamelabel = new JLabel("Last Name"); // lnamelabel
        lnamelabel.setBounds(100, 130, 100, 20);
        container.add(lnamelabel);
        lnamefield = new JTextField(); // lname field
        lnamefield.setBounds(200, 130, 190, 20);
        container.add(lnamefield);

        doblabel = new JLabel("DOB"); // dob label
        doblabel.setBounds(100, 180, 100, 20);
        container.add(doblabel);
        dobfield = createFormattedTextField("####-##-##"); // dob field
        dobfield.setBounds(200, 180, 190, 20);
        container.add(dobfield);

        genderlabel = new JLabel("Gender"); // gender label
        genderlabel.setBounds(100, 230, 100, 20);
        container.add(genderlabel);

        // radio button for gender
        male = new JRadioButton("Male");
        male.setBounds(200, 230, 75, 20);
        container.add(male);
        female = new JRadioButton("Female");
        female.setBounds(275, 230, 80, 20);
        container.add(female);
        genderGroup = new ButtonGroup();// buttongroup
        genderGroup.add(male);
        genderGroup.add(female);

        phonelabel = new JLabel("Phone"); // phonelabel
        phonelabel.setBounds(100, 280, 100, 20);
        container.add(phonelabel);
        phonefield = createFormattedTextField("##########");// phone field
        phonefield.setBounds(200, 280, 190, 20);
        container.add(phonefield);

        emaillabel = new JLabel("Email");// email label
        emaillabel.setBounds(100, 330, 100, 20);
        container.add(emaillabel);
        emailfield = new JTextField();// email field
        emailfield.setBounds(200, 330, 190, 20);
        container.add(emailfield);

        addlabel = new JLabel("Address"); // address label
        addlabel.setBounds(100, 380, 100, 20);
        container.add(addlabel);
        addfield = new JTextArea();// address textarea
        addfield.setBounds(200, 380, 190, 75);
        addfield.setLineWrap(true);
        container.add(addfield);

        edulabel = new JLabel("Education");// education label
        edulabel.setBounds(100, 480, 100, 20);
        container.add(edulabel);
        educationComboBox = new JComboBox<>(edulevels);// educ.. combobox
        educationComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
        educationComboBox.setBounds(200, 480, 190, 20);
        container.add(educationComboBox);

        termsCheckBox = new JCheckBox("Accept Terms And Conditions.");// terms
        termsCheckBox.setFont(new Font("Arial", Font.PLAIN, 15));
        termsCheckBox.setBounds(150, 530, 250, 20);
        container.add(termsCheckBox);

        submitButton = new JButton("Submit");// submit button
        submitButton.setFont(new Font("Arial", Font.PLAIN, 15));
        submitButton.setBounds(150, 580, 100, 20);
        submitButton.addActionListener(this);
        container.add(submitButton);

        resetButton = new JButton("Reset");// reset button
        resetButton.setFont(new Font("Arial", Font.PLAIN, 15));
        resetButton.setBounds(270, 580, 100, 20);
        resetButton.addActionListener(this);
        container.add(resetButton);
        setVisible(true);
    }

    private JFormattedTextField createFormattedTextField(String format) {
        try {
            MaskFormatter maskFormatter = new MaskFormatter(format);
            maskFormatter.setPlaceholderCharacter('_');
            return new JFormattedTextField(maskFormatter);
        } catch (ParseException e) {
            e.printStackTrace();
            return new JFormattedTextField();
        }
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Submit":
                if (termsCheckBox.isSelected()) {
                    String data = "First Name : " + fnamefield.getText() + "\n" + "Last Name : " + lnamefield.getText()
                            + "\n" + "DOB : " + dobfield.getText() + "\n" + "Gender : "
                            + (male.isSelected() ? "Male" : "Female") + "\n" + "Phone : " + phonefield.getText() + "\n"
                            + "Email : " + emailfield.getText() + "\n" + "Address : " + addfield.getText() + "\n"
                            + "Education : " + (String) educationComboBox.getSelectedItem();

                    JOptionPane.showMessageDialog(this, data);
                } else {
                    JOptionPane.showMessageDialog(this, "Please accept the terms & conditions!");
                }
                break;
            case "Reset":
                String def = "";
                fnamefield.setText(def);
                lnamefield.setText(def);
                dobfield.setText(def);
                phonefield.setText(def);
                emailfield.setText(def);
                addfield.setText(def);
                termsCheckBox.setSelected(false);
                educationComboBox.setSelectedIndex(0);
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        new Regform();
    }
}
