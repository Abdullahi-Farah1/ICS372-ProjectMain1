package aya.reviews.ics372projectmain1.view;



import aya.reviews.ics372projectmain1.MainApp;
import aya.reviews.ics372projectmain1.control.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UIController {
    @FXML
    private TextArea reviewInput;
    @FXML
    private TextField ratingInput;
    @FXML
    private Button button;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button register1;

    private Map<String, String> registeredUsers; // Map to store registered users
    private final UserController userController;

    public UIController() {
        this.userController = new UserController();
    }

    @FXML
    public void userLogIn(ActionEvent event) throws IOException {
        checkLogIn();
    }

    @FXML
    public void registerUser(ActionEvent event) throws IOException {
        registerUser();
    }

    private void checkLogIn() throws IOException {

        String enteredUsername = username.getText();
        String enteredPassword = password.getText();

        if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
            wrongLogIn.setText("Please enter both username and password.");
        } else {
            boolean res = this.userController.loginUser(enteredUsername, enteredPassword);
            if (res) {
                wrongLogIn.setText("Login successful");
                MainApp m = new MainApp();
                m.changeScene("afterLogin.fxml");
            } else {
                wrongLogIn.setText("Incorrect login");
            }
        }
    }

    private void registerUser() {
        String enteredUsername = username.getText();
        String enteredPassword = password.getText();

        if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
            wrongLogIn.setText("Please enter both username and password.");
        } else {
            // registerUser should probably not implicitly register the user, but i'm lazy
            boolean res = this.userController.registerUser(enteredUsername, enteredPassword);
            if (!res) {
                wrongLogIn.setText("User already registered. Please log in.");
            }
        }
    }
    public void reviewAndRate() {
        // Retrieve the user input from the text fields
        String review = reviewInput.getText();
        int rating = Integer.parseInt(ratingInput.getText());

        // Do something with the user input (e.g., store it in variables, process it, etc.)
        System.out.println("Review: " + review);
        System.out.println("Rating: " + rating);


    }

    public void cancelButton(ActionEvent event) throws IOException {
        MainApp s = new MainApp();
        s.changeScene("afterLogin.fxml");


    }

}
