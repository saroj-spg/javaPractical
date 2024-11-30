public class Main {
    public static void main(String[] args) {
        User model = new User();
        RegisterView view = new RegisterView();
        RegisterController controller = new RegisterController(model, view);
    }
}