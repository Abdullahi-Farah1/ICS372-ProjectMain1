package aya.reviews.ics372projectmain1.view;



import aya.reviews.ics372projectmain1.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class LoginControllerUI {
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button register1;

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
            boolean res = MainApp.userController.loginUser(enteredUsername, enteredPassword);
            if (res) {
                wrongLogIn.setText("Login successful");
//                MainApp m = new MainApp();
                MainApp.changeScene("afterLogin.fxml");
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
            boolean res = MainApp.userController.registerUser(enteredUsername, enteredPassword);
            if (!res) {
                wrongLogIn.setText("User already registered. Please log in.");
            }
        }
    }

}