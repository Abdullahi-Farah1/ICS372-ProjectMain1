package aya.reviews.ics372projectmain1.view;



import aya.reviews.ics372projectmain1.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;

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
    public void userLogIn(ActionEvent event) throws IOException, SQLException {
        checkLogIn();
    }

    @FXML
    public void registerUser(ActionEvent event) throws IOException, SQLException {
        registerUser();
    }

    private void checkLogIn() throws IOException, SQLException {

        String enteredUsername = username.getText();
        String enteredPassword = password.getText();

        if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
            wrongLogIn.setText("Enter Username and Password or Register.");
        } else {
            boolean res = MainApp.userController.loginUser(enteredUsername, enteredPassword);
            if (res) {
                MainApp.changeScene("afterLogin.fxml");
            } else {
                wrongLogIn.setText("Incorrect login. Try Again.");
            }
        }
    }

    private void registerUser() throws SQLException {
        String enteredUsername = username.getText();
        String enteredPassword = password.getText();

        if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
            wrongLogIn.setText("Please enter both username and password.");
        } else {
            // registerUser should probably not implicitly register the user, but i'm lazy
            boolean res = MainApp.userController.registerUser(enteredUsername, enteredPassword);
            if (!res) {
                wrongLogIn.setText("Registration Successful. Please log in.");
            }
        }
    }

}
