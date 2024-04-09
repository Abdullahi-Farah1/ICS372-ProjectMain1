package aya.reviews.ics372projectmain1;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
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

    public Controller() {
        registeredUsers = new HashMap<>();
        // For simplicity, I'm adding a default admin user during initialization
        registeredUsers.put("admin", "password");
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
        MainApp m = new MainApp();
        String enteredUsername = username.getText();
        String enteredPassword = password.getText();

        if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
            wrongLogIn.setText("Please enter both username and password.");
        } else {
            if (authenticate(enteredUsername, enteredPassword)) {
                wrongLogIn.setText("Login successful");
                m.changeScene("afterLogin.fxml");
            } else {
                wrongLogIn.setText("Incorrect login");
            }
        }
    }

    private boolean authenticate(String username, String password) {
        // Check if the entered username and password match any registered user
        return registeredUsers.containsKey(username) && registeredUsers.get(username).equals(password);
    }

    private void registerUser() {
        String enteredUsername = username.getText();
        String enteredPassword = password.getText();

        if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
            wrongLogIn.setText("Please enter both username and password.");
        } else {
            if (registeredUsers.containsKey(enteredUsername)) {
                wrongLogIn.setText("User already registered. Please log in.");
            } else {
                registeredUsers.put(enteredUsername, enteredPassword);
                wrongLogIn.setText("Registration successful. Please log in.");
            }
        }
    }
}
