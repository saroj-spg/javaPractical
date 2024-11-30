
// RegisterController.java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController {
    private User model;
    private RegisterView view;

    public RegisterController(User model, RegisterView view) {
        this.model = model;
        this.view = view;

        this.view.addSubmitButtonListener(new SubmitButtonListener());
    }

    class SubmitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.setFname(view.getFname());
            model.setLname(view.getLname());
            model.setAddress(view.getAddress());
            model.setPhone(view.getPhone());
            model.setEmail(view.getEmail());
            model.setCollegeName(view.getCollegeName());
            model.setSemester(view.getSemester());
            model.setRollNo(view.getRollNo());

            view.displayMessage("User registered successfully:\n" +
                    "First Name: " + model.getFname() + "\n" +
                    "Last Name: " + model.getLname() + "\n" +
                    "Address: " + model.getAddress() + "\n" +
                    "Phone: " + model.getPhone() + "\n" +
                    "Email: " + model.getEmail() + "\n" +
                    "College Name: " + model.getCollegeName() + "\n" +
                    "Semester: " + model.getSemester() + "\n" +
                    "Roll No: " + model.getRollNo());
        }
    }
}
