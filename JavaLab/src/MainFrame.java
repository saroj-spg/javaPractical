import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MainFrame extends JFrame implements ActionListener{
    JTextField textField;
    JLabel label;
    JButton button;
    JPasswordField passwordField;
    JCheckBox checkbox;
    int yoffset = 20;
    int labelHeight = 40;
    int fieldHeight = 60;
    int buttonHeight = 30;
    int gapHeight = 10;
    public void initialize() {
        setTitle("First Desktop App");
        //label text
        label = new JLabel();
        label.setText("Hello, Everyones");
        label.setBounds(20,yoffset, 200, labelHeight);
        yoffset=yoffset+labelHeight+gapHeight;
        //user name label
        JLabel userNameLabel = new JLabel();
        userNameLabel.setText("User Name");
        userNameLabel.setBounds(20, yoffset , 200, labelHeight);
        yoffset=yoffset+labelHeight+gapHeight;
        //text field
         textField = new JTextField();
        textField.setBounds(20, yoffset, 200,fieldHeight);
        yoffset=yoffset+fieldHeight+gapHeight;
        //user password label
        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setBounds(20, yoffset, 200, labelHeight);
        yoffset=yoffset+labelHeight+gapHeight;
        //password field
        JPasswordField passwordfield = new JPasswordField();
        passwordField.setBounds(20,yoffset, 200, fieldHeight);
        yoffset=yoffset+fieldHeight+gapHeight;
        
        //button
         JButton  button= new JButton("Click Me");
        button.setBounds(20, yoffset, 200, buttonHeight);
        yoffset=yoffset+buttonHeight+gapHeight;



        //checkbox
        JCheckBox checkbox =new JCheckBox("Remember me");
        checkbox.setBounds(20, yoffset, 200, buttonHeight);
        yoffset=yoffset+buttonHeight+gapHeight;


        button.addActionListener(this);
        add(label);
        add(textField);
        add(button);
        add(passwordField);
        add(userNameLabel);
        add(passwordLabel);
        add(passwordfield);
        add(button);
        add(checkbox);

        setSize(500, 600);
        setMinimumSize(new Dimension(200, 300));
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button clicked");
        String textData = textField.getText();
        label.setText(textData);
    }
}